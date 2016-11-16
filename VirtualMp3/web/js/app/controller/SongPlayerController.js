/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("SongPlayerControllerModule", ["SongService"])
        .controller("SongPlayerController", ["$scope", "SongService", NavBotCtrl]);


function NavBotCtrl($scope, SongService) {
    $scope.state = "pause";
    $scope.song = {
        link : "",
        cover : "resource/cover.jpg",
        name : "default name",
        artist : "default artist"
    };
    
    $scope.songQueue = "";
    $scope.progress = "";
    $scope.durationTotal = "";
    $scope.duration = "";
    $scope.volume = "";
    
    $scope.audioEl = new Audio();

    $scope.$on("PlaySong", function (event, data) {
        setSong(data.song);
    });

    $scope.getSong = function (id) {
        SongService.getSong(id, getSongSuccess, getSongError);
        
    };

    function getSongSuccess(song) {
        setSong(song);
    }

    function getSongError() {
        alert("Error while getting song");
    }

    $scope.play = function () {
        console.log($scope.audioEl);
        console.log($scope.link);
        if ($scope.state == "pause") {
            play();
        } else {
            pause();
        }

    };
    function play() {
        $scope.audioEl.play();
        $scope.state = "play";
    }

    function pause() {
        $scope.audioEl.pause();
        $scope.state = "pause";
    };



    function setSong(song) {
        $scope.song = song;
        $scope.audioEl.src = $scope.song.link;
        $scope.state = "pause";
    }
}