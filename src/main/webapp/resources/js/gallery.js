"use strict"
var photoNo = Math.floor(Math.random() * 6) + 1;
var timerFirst = 0;
var timerSecond = 0;


function choosePhoto(number) {
    clearTimeout(timerFirst);
    clearTimeout(timerSecond);

    hide();
    setTimeout("gallery()", 500);
    photoNo = number - 1;
}

function hide() {
    $("#slider").fadeOut(500);
}

function gallery() {
    photoNo++;
    if (photoNo > 6) photoNo = 1;

    var file = "<img src=\"../resources/images/gallery/" + photoNo + ".jpg\"/>";
    document.getElementById("slider").innerHTML = file;
    $("#slider").fadeIn(500);

    timerFirst = setTimeout("gallery()", 5000);
    timerSecond = setTimeout("hide()", 4500);
}