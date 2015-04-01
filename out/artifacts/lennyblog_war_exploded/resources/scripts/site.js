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
                if (data.length > 0) {
                    var str = "";
                    for (var i = 0; i < data.length; i++) {
                        str = str + "<div class='post'><h2><a href=''#' class='post-title'>" + data[i].title + "</a></h2><p class='time'>" +
                        "Published on " + data[i].ptime + "</p><div class='post-content'>" + data[i].content + "</div>" +
                        "<div class='post-tags'><a href='#' class='post-tags-item'>Backend</a></div></div>";
                    }
                    $("#articleLst").append(str);
                    if(data.length==6){
                        lock=false;
                        page++;
                    }
                }
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
        function () {
            totalheight = parseFloat($(window).height())
            + parseFloat($(window).scrollTop());
            if ($(document).height() <= totalheight) {
                Load();
            }
        });
});