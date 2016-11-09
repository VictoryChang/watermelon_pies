/**
 * 
 */

var serviceUrl = 'http://localhost:8080/Watermelon_Pies/rest/hello/phone/';
var phoneApp = angular.module('phoneApp',[]);
var PhoneController = function($scope, $http) {    
	$scope.search = function() {        
		var request = {        
				method: 'GET',        
				url: serviceUrl + $scope.name    
		};        
		$http(request).then(        
				function successCallback(response) { //success          
					$scope.phone = response.data.phone;        
				},            
				
		function errorCallback(response) { //error          
			$scope.phone = 'An unknow problem happened.';        
		});  
		} //search  
	} //PhoneController
phoneApp.controller('PhoneController', PhoneController);
	
	
