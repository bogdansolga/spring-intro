'use strict';

var authServices = angular.module('authServices', []);

authServices.factory('AuthServices', function ($http) {
    return {
        login: function(user) {
            var login = $.param(user);

            return $http({
                method: 'POST',
                url: '/j_spring_security_check',
                data: login,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });
        },

        logout: function(scope) {
            $http.post('/j_spring_security_logout').success(function() {
                scope.authenticated = false;
            });
        }
    };
});