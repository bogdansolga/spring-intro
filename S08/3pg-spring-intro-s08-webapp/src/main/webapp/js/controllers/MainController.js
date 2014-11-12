'use strict';

var mainController = angular.module('mainController', []);

mainController.controller('MainController', function($scope, $location) {
    $scope.$on('login', function(details) {
        $scope.authenticated = true;
        $location.path('/users');
    });

    $scope.$on('logout', function(details) {
        $scope.authenticated = false;
        $location.path('/');
    });
});