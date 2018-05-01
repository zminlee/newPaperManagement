/**
 * Created by DoveXL on 2017/10/27.
 */

$(document).ready(function () {
    $("#collapseOne").show(1);
    $("#collapseTwo").hide();
    $("#collapseThree").hide();
});


function ShowAndHideOne() {
    $("#collapseOne").toggle(500);
    $("#collapseTwo").hide(500);
    $("#collapseThree").hide(500);
}

function ShowAndHideTwo() {
    $("#collapseTwo").toggle(500);
    $("#collapseOne").hide(500);
    $("#collapseThree").hide(500);
}

function ShowAndHideThree() {
    $("#collapseThree").toggle(500);
    $("#collapseOne").hide(500);
    $("#collapseTwo").hide(500);
}





