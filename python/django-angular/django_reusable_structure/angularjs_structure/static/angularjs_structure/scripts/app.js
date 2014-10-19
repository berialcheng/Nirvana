var staticRoot = '/static/angularjs_structure';
function getURL(path){
	return staticRoot + path
}

function init() {
      if (window.sessionStorage["userInfo"]) {
        userInfo = JSON.parse(window.sessionStorage["userInfo"]);
      }
    }
init();

var app = angular.module('project',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
		.when('/',{
			controller:"ViewCtrl",
			templateUrl:getURL('/views/view.html'),
			resolve: {
			    auth: ["$q", "authenticationService", function($q, authenticationService) {
					//var userInfo = authenticationService.getUserInfo();
					var userInfo = this.userInfo;
					if (userInfo) {
						return $q.when(userInfo);
					} else {
						return $q.reject({ authenticated: false });
					}
			    }]
			}
		})
		.when('/edit/:personId',{
			controller:"EditCtrl",
			templateUrl:getURL('/views/edit.html'),
			resolve: {
			    auth: ["$q", "authenticationService", function($q, authenticationService) {
					//var userInfo = authenticationService.getUserInfo();
					var userInfo = this.userInfo;
					if (userInfo) {
						return $q.when(userInfo);
					} else {
						return $q.reject({ authenticated: false });
					}
			    }]
			}
		})
		.when('/login',{
			controller:"LoginCtrl",
			templateUrl:getURL('/views/login.html')
		})
		.otherwise({redirectTo: '/'})
})
.service('personService',[function(){
	var instance = {
    	persons: [
			{id:1,name:"Adrian",phone:"13777777777"},
			{id:2,name:"Benny", phone:"13666666666"},
			{id:3,name:"Cat", phone:"13555555555"},
			{id:4,name:"Danny", phone:"13444444444"}
		],
    	getPersons:  function(){
			return this.persons
		}
  	}
	return instance;
}])
.service('authenticationService',['$http','$q','$window',function($http, $q, $window) {
	this.userInfo = null;
	this.login = function(userName, password) {
		    var deferred = $q.defer();
			$http.post("/api/auth", {
				userName: userName,
				password: password
			}).then(function(result) {
				userInfo = {
					accessToken: result.data.access_token,
					userName: result.data.userName
				};
				$window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
				deferred.resolve(userInfo);
			}, function(error) {
				deferred.reject(error);
			});
			return deferred.promise;
		}
	this.getUserInfo = function(){
			return this.userInfo;
		}
	return this;
}])
.controller('ViewCtrl', ['$scope','personService',function($scope,personService){
	$scope.persons = personService.getPersons()
}])
.controller('EditCtrl', ['$scope','$routeParams','personService',function($scope, $routeParams, personService){
	var persons = personService.getPersons()
	for(var i=0;i<persons.length ;i++){
		if(persons[i].id == $routeParams.personId){
			$scope.name = persons[i].name;
		}
	}
}])
.controller('LoginCtrl',['$scope',"$location",'authenticationService', function($scope,$location,authenticationService){
	$scope.login = function(){
		authenticationService.login($scope.username,$scope.password).then(
			function(result) {
				$location.path("/");
			}, function(error) {
				
			})
	}
}])
.config(function($interpolateProvider) {
	$interpolateProvider.startSymbol('{[{');
	$interpolateProvider.endSymbol('}]}');
});

app.run(["$rootScope", "$location", function($rootScope, $location) {
	$rootScope.$on("$routeChangeSuccess", function(userInfo) {
		console.log(userInfo);
	});
	$rootScope.$on("$routeChangeError", function(event, current, previous, eventObj) {
    	if (eventObj.authenticated === false) {
			$location.path("/login");
    	}
  	});
}]);
