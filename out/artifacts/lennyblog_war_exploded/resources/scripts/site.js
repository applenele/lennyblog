/**
 * Created by apple on 15/3/31.
 */


var page = 0;
var lock = false;

var time = "";
var category = "";


function LoadArticles() {
    if (lock) {
        return;
    }
    else {
        lock = true;
        $.ajax({
            url: "/article/getArticles.do",
            method: "post",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: {"page": page, "time": time, "category": category},
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                alert("error");
            }
        })
    }
}

function Load() {
    LoadArticles();
}

$(document).ready(function () {

    Load();

    $(window).scroll(
        function() {
            totalheight = parseFloat($(window).height())
            + parseFloat($(window).scrollTop());
            if ($(document).height() <= totalheight) {
                Load();
            }
        });
});