/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module("SongService", [])
        .service("SongService", ["$http", SongService]);

function SongService($http) {
    this.getSong = function (id, getSongSuccess, getSongError) {
        var url = "http://localhost:8080/VirtualMp3/song?id=8";
        
        var successCallback = function(response){
            getSongSuccess(response.data);
        };
        
        var errorCallback = function(response){
            getSongError();
        };
        
        CallServer($http,url,successCallback,errorCallback);
    };
}
;

function CallServer($http, url, successCallBack, errorCallBack) {
    $http({
        method: "JSONP",
        url: url+"&callback=JSON_CALLBACK"
    }).then(
            function success(response) {
                successCallBack(response);
            },
            function error(response) {
                errorCallBack(response);
            });
}