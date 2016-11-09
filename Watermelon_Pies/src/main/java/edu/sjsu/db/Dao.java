package edu.sjsu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Connect to database via JDBC
public class Dao {
	public static Connection getConn() {    
		String driverStr = "com.mysql.jdbc.Driver";    
		String urlStr = "jdbc:mysql://localhost:3306/cs160test";    
		String uid = "root";    
		String pwd = "underRoot12";    
		
		try {      
			Class.forName(driverStr);      
				return DriverManager.getConnection(urlStr, uid, pwd);    
			} catch (SQLException | ClassNotFoundException ex) {      
				System.err.println("The connection failed because " + ex.getMessage());      
				ex.printStackTrace();      
				return null;    
		}
	} // method
	
	// Retrieve data based on name
	 public static String getPhone(String name) throws SQLException {    
		  //String output = name + "'s phone is ";    
		 String output = "{\"phone\" : ";
		  Connection conn = getConn();    
		  if (conn == null) return output + "\"connection failed\"}";   
		  String sqlStr = "select * from phones where name=?;";    
		  ResultSet rs = null;    
		  PreparedStatement pstmt = conn.prepareStatement(sqlStr);    
		  pstmt.setString(1, name);    rs = pstmt.executeQuery();    
		  if (rs == null)      
			  output += "\"Name not found!\"";    
		  else {      
			  rs.next();      
			  output += "\"" + rs.getString(2) + "\"";    
			  }    
		  return output + "}";  
	  } // method
}
