'use strict';

var springIntro = angular.module('springIntro', ['ngRoute',
    // services
    'userServices', 'productServices', 'authServices',

    // directives
    'auth', 'navbar',

    // controllers
    'mainController', 'userController', 'productController'
]);

springIntro.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/',          {templateUrl: 'templates/home.html',        controller: 'MainController'})
        .when('/home',      {templateUrl: 'templates/home.html',        controller: 'MainController'})

        .when('/users',     {templateUrl: 'templates/users.html',       controller: 'UserController'})
        .when('/products',  {templateUrl: 'templates/products.html',    controller: 'ProductController'})

        .otherwise({redirectTo: '/'});
}]);
