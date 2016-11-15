/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("NavBotCtrl",["SongService"])
        .controller("PlayerController",["$scope","SongService",NavBotCtrl])


function NavBotCtrl ($scope,SongService){
    $scope.state = "pause";
    $scope.link = "";
    $scope.cover = "resource/cover.jpg";
    $scope.name = "default name";
    $scope.artist = "default artist";
    $scope.progress = "";
    $scope.songQueue = "";
    
    $scope.getSong = function(id){
        SongService.getSong(id,getSongSuccess,getSongError);
    };
    
    function getSongSuccess(song){
        setSong(song);
    }
    
    function getSongError(){
        alert("Error while getting song");
    }
    
    
    function setSong(song){
        $scope.musicSrc = song.link;
        $scope.name = song.song;
        $scope.artist = song.singer;
        $scope.cover = song.cover;
    }
}