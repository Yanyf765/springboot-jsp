$().ready(function () {

    $('#Login').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();

        if (username == "" || password == "") {
            alert("用户名或密码不能为空！");
        } else {
            $.ajax({
                type: "POST",
                url: "login",
                data: "username=" + escape(username) + "&password=" + escape(password),
                beforeSend: function () {
                    $("#loading").css("display", "block"); //点击登录后显示loading，隐藏输入框
                    $("#login").css("display", "none");
                },
                success: function (result) {
                    $("#loading").hide(); //隐藏loading
                    if (result.code == "200") {
                        parent.document.location.href = "index.jsp"; //如果登录成功则跳到管理界面
                    } else {
                        alert("登录失败！");
                    }
                }
            });
        }



    });
});