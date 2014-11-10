'use strict';

var mainController = angular.module('mainController', []);

mainController.controller('MainController', function($scope, $location, AuthServices) {
    $scope.$on('login', function(details) {
        $scope.authenticated = true;
        $location.path('/users');
    });

    $scope.$on('logout', function(details) {
        AuthServices.logout($scope);
        $scope.authenticated = false;
        $location.path('/');
    });
});