/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("HomeModule", ["SongService","PlaylistService"])
        .controller("PlaylistController", ["$scope", "SongService","PlaylistService", HomeController]);

function HomeController ($scope, SongService, PlaylistService){
    $scope.topPlaylists = [];
    
    PlaylistService.getTopPlaylist(getTopPlaylistSuccess,getTopPlaylistError);
    
    function getTopPlaylistSuccess(data){
        $scope.topPlaylist = data;
    }
    
    function getTopPlaylistError(){
        alert("Error while getting home's album");
    }
}