var navbar = angular.module("navbar", []);

navbar.directive("navbar", function() {
    return {
        templateUrl: "templates/navbar.html"
    }
});