$(function () {
    document.onkeydown = function (evt) {
        var evt = window.event ? window.event : evt;
        if (evt.keyCode == 13) {
            login();
        }
    }
});

function login() {
    $("#error").html("");
    var loginName = $("#loginName").val();
    if (isEmpty(trim(loginName))) {
        $("#error").html("登录名不能为空");
        return;
    }
    var password = $("#password").val();
    if (isEmpty(trim(password))) {
        $("#error").html("密码不能为空");
        return;
    }
    $.ajax({
        url: "/auth/check.do",
        type: "post",
        data: {"username": loginName, "password": $.md5(password)},
        async: false,
        dataType: "text",
        success: function (result) {
            if (result == "ticket-error") {
                $("#error").html("用户名或密码错误");
            } else if (result == "success") {
                $("#password").val($.md5(password));
                $("#loginForm").submit();
            } else {
                alert("服务器错误，登录失败");
            }
        },
        error: function (data, textstatus) {
            alert("服务器错误，登录失败");
        }

    });
}

