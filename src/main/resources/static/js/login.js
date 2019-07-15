$().ready(function () {
    $('#Login').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        console.log("username="+username);
        console.log("password="+password);

        if ($('#username').val() == "" || $('#password').val() == "") {
            alert("用户名或密码不能为空！");
        }
        else {
            $.ajax({
                type: "POST",
                url: "login",
                data: "username=" + escape($('#username').val()) + "&password=" + escape($('#password').val()),
                beforeSend: function () {
                    $("#loading").css("display", "block"); //点击登录后显示loading，隐藏输入框
                    $("#login").css("display", "none");
                },
                success: function (result) {
                    $("#loading").hide(); //隐藏loading
                    if (result.code == "200") {
                        //parent.tb_remove();
                        parent.document.location.href = "index.html"; //如果登录成功则跳到管理界面
                        parent.tb_remove();
                    }else {
                        alert("登录失败！");
                    }
                },
                error: function (XMLHttpRequest, textStatus, thrownError) {
                }
            });
        }
    });
});