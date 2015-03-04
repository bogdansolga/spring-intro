'use strict';

var userServices = angular.module('userServices', ['ngResource'])

userServices.factory('UserServices', function($resource){
    return {
        all:    $resource('/spring-intro/user/', {},
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
