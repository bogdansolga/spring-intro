'use strict';

var userServices = angular.module('userServices', ['ngResource'])

userServices.factory('UserServices', function($resource){
    return {
        all:    $resource('/user/', {},
            {
                'get': {method: 'GET', isArray: true}
            }
        ),

        one:    $resource('/user/:id', {id: '@id'},
            {
                'delete':       {method: 'DELETE'},
                'create':       {method: 'POST'}
            }
        )
    }
});
