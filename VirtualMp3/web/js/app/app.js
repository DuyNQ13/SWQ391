/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('App',
        [
            "SongService",
            "index",
            "SongPlayerControllerModule",
            'PlaylistModule',
            "ngRoute"
        ])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                    .when('/', {
                        redirectTo: '/home'
                    })
                    .when("/home", {
                        templateUrl: 'template/Home.html',
                        controller:HomeController
                    })
                    .when("/album", {
                        templateUrl: 'template/album.html'
                    });
//            $locationProvider.html5Mode(true);
        });

