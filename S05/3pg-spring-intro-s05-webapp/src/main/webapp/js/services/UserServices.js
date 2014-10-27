'use strict';

var userServices = angular.module('userServices', ['ngResource'])

userServices.factory('UserServices', function($resource){
    return {
        all:    $resource('/spring-intro/users/', {},
            {
                'get': {method: 'GET', isArray: true}
            }
        ),

        one:    $resource('/spring-intro/user/:id', {id: '@id'},
            {
                'delete':       {method: 'DELETE'},
                'create':       {method: 'POST'}
            }
        )
    }
});
