/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var state = 'stop';
function buttonPlayPress() {
    if (state === 'stop') {
        state = 'play';
        $('#play-pause-button').removeClass('glyphicon-play');
        $('#play-pause-button').addClass('glyphicon-pause');
    } else if (state === 'play' || state === 'resume') {
        state = 'pause';
        $('#play-pause-button').removeClass('glyphicon-pause');
        $('#play-pause-button').addClass('glyphicon-play');
    } else if (state === 'pause') {
        state = 'resume';
        $('#play-pause-button').removeClass('glyphicon-play');
        $('#play-pause-button').addClass('glyphicon-pause');
    }
}

function buttonStopPress() {
    state = 'stop';
    $('#play-pause-button').removeClass('glyphicon-pause');
    $('#play-pause-button').addClass('glyphicon-play');
}