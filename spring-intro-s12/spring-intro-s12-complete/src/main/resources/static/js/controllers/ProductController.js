'use strict';

var productController = angular.module('productController', []);

productController.controller('ProductController', function($scope, ProductServices) {
    $scope.products = [];
    /*
    ProductServices.all.get({}, function success(data) {
        $scope.products = data;
    });
    */
});