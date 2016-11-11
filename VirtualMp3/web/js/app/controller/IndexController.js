/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('index', [])
        .controller('indexController', ['$scope', '$location','$log', indexController ]);


function indexController($scope, $location,$log) {
    $scope.LogLocation = function () {
        $log.log($location.path())
    };
}