'use strict';

var springIntro = angular.module('springIntro', ['ngRoute',
    // services
    'userServices', 'productServices',

    // directives
    //'navbar',

    // controllers
    'userController', 'productController',
]);

springIntro.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/',          {templateUrl: 'templates/home.html'})

        .when('/users',     {templateUrl: 'templates/users.html',       controller: 'UserController'})
        .when('/products',  {templateUrl: 'templates/products.html',    controller: 'ProductController'})

        .otherwise({redirectTo: '/'});
}]);
