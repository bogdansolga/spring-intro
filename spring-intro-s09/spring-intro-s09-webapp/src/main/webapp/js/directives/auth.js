'use strict';

var auth = angular.module('auth', []);

auth.directive('auth', function($rootScope, $http, AuthServices) {
    return {
        templateUrl: "templates/login.html",
        link: function(scope) {
            scope.login = function() {
                $('#login').modal('hide');

                AuthServices.login(scope.login).success(function(data) {
                    // this callback will be called asynchronously when the response is available
                    scope.authenticated = true;

                    $rootScope.$broadcast('login', scope);
                }).error(function(data, status) {
                    // called asynchronously if an error occurs or the server returns response with an error status
                    if (status == 401 || status == 403) {
                        // unauthorized
                        var message = data.substring(data.indexOf('Invalid username or password'), data.lastIndexOf('</h1>'));

                        alert(message);
                    } else {
                        console.log(data);
                    }
                });
            };

            scope.logout = function() {
                $http.post('/j_spring_security_logout').success(function() {
                    scope.authenticated = false;
                    $rootScope.$broadcast('logout', scope);
                });
            };
        }
    }
});