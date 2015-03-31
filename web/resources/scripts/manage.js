/**
 * Created by apple on 15/3/31.
 */
$(document).ready(function () {

    /**
     *  login
     */
    $("#btnLogin").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();

        $.post("/manage/login.do", {"username": username, "password": password}, function (data) {
            if (data == "ok") {
                window.location.href = "/manage/index.do";
            } else {
                alert("用户名或密码错误！");
            }
        });
    });

    /**
     * add article
     */
    $("#btnAddArticle").click(function () {
        var title = $("#title").val();
        var content = $("#content").val();
        var category = $("#category").val();
        var tags = $("#tags").val();

        if (title == "") {
            $(".warning").text("标题不能为空！");
            return;
        }
        if (content == "") {
            $(".warning").text("内容不能为空！");
            return;
        }

        $.ajax({
            url: "/manage/addArticle.do",
            method: "post",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: { "title": title ,"content":content,"category":category,"tags":tags},
            success: function (data) {
               alert(data);
            },
            error: function (data) {
                alert("error！");
            }
        });

    });
});