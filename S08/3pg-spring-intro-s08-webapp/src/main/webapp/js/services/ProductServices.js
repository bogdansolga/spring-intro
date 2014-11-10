'use strict';

var productServices = angular.module('productServices', ['ngResource']);

productServices.factory('ProductServices', function($resource){
    return {
        all:    $resource('/spring-intro/product/', {},
            {
                'get': {method: 'GET', isArray: true}
            }
        ),

        one:    $resource('/spring-intro/product/:id', {id: '@id'},
            {
                'delete':       {method: 'DELETE'},
                'create':       {method: 'POST'}
            }
        )
    }
});
