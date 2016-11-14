/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('App',
        ['index',"NavBotCtrl",'ngRoute'])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'template/welcomeTest.html'
                    })
                    .when("/home", {
                        templateUrl: 'template/Home.html',
                    });
//            $locationProvider.html5Mode(true);
        });

