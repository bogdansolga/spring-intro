'use strict';

var userController = angular.module('userController', []);

userController.controller('UserController', function($scope, UserServices) {
    UserServices.all.get({}, function success(data) {
        $scope.users = data;
    });
});