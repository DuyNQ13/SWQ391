/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var state = 'pause';
function buttonPlayPress() {
    if (state === 'pause') {
        state = 'play';
        $('#play-pause-button').removeClass('fa-play');
        $('#play-pause-button').addClass('fa-pause');
    } else if (state === 'play') {
        state = 'pause';
        $('#play-pause-button').removeClass('fa-pause');
        $('#play-pause-button').addClass('fa-play');
    }
}