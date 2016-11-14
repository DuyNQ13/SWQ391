/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("NavBotCtrl",[])
        .controller("PlayerController",["$scope",NavBotCtrl])


function NavBotCtrl ($scope){
    $scope.state = "pause";
    $scope.musicSrc = "";
    $scope.cover = "";
    $scope.name = "";
    $scope.artist = "";
    $scope.progress = "";
    $scope.songQueue = "";
    
    $scope.setSong = function(song){
        
    };
    
}