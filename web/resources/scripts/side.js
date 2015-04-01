/**
 * Created by apple on 15/4/1.
 */


function LoadCatogorues(){
    $.ajax({
        url:"/article/getCategories.do",
        method:"post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){
            var str="";
            for(var key in data){
                str=str+" <li><a href=#'>"+key+"("+data[key]+")</a></li>"
            }
            $("#categories").html(str);
        },
        error:function(data){
            console.log("error");
        }
    });
}

function LoadTime(){
    $.ajax({
        url:"/article/getTime.do",
        method:"post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){
            var str="";
            for(var key in data){
                str=str+" <li><a href=#'>"+key+"("+data[key]+")</a></li>"
            }
            $("#categories").html(str);
        },
        error:function(data){
            console.log("error");
        }
    });
}

$(document).ready(function () {
   LoadCatogorues();
})