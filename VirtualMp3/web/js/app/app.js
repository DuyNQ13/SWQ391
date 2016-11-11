/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//angular.module('App',
//        ['ngRoute'])
//        .config(function ($routeProvider) {
//            $routeProvider.when('/', {
//                templateUrl: '/template/welcomeTestAA.html'
//            });
//        });

angular.module('App',
    ['ngRoute']
    ).config(function($routeProvider) {
        $routeProvider.when('/p',
        {
            templateUrl: '/templates/posts/index.html'
        });
});
