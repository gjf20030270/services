<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理后台</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="include/static.jsp"%>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <b>管理后台</b>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">

        <div class="form-group has-feedback">
            <input id="username" type="text" name="username" class="form-control" placeholder="用户名">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input id="password" type="password" name="password" class="form-control" placeholder="密码">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <div class="col-sm-5" style="padding-left:0px;">
                <input id="captcha" name="captcha" tabindex="3" placeholder="验证码" class="form-control" type="text" value="" size="6" autocomplete="off"></div>
            <div class="col-sm-3">
                <img alt="验证码" style="cursor: pointer;height: 38px;" id="img_captcha" src="/captcha-image">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-9">
                <%--<div class="checkbox icheck">
                    <label>
                        <input type="checkbox"> Remember Me
                    </label>
                </div>--%>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
                <button onclick="login();" class="btn btn-primary btn-block btn-flat">登录</button>
            </div>
            <!-- /.col -->
        </div>


        <!-- /.social-auth-links -->

        <%--<a href="#">I forgot my password</a><br>
        <a href="register.html" class="text-center">Register a new membership</a>--%>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->


<script src="/static/js/jQuery/jquery-2.2.3.min.js"></script>
<script src="/static/js/bootstrap/bootstrap.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('#img_captcha').click(function () {
            $(this).prop('src', '/captcha-image?' + Math.random());
        })
    });
    function login(){
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var captcha = document.getElementById("captcha");
        if(username.value.trim() == ""){
            alert("用户名不能为空!");
            username.focus();
            return false;
        }
        if(password.value.trim() == ""){
            alert("密码不能为空!");
            password.focus();
            return false;
        }
        if(captcha.value.trim() == ""){
            alert("验证码不能为空!");
            captcha.focus();
            return false;
        }
        $.post(
                '/login',
                {
                    username: username.value.trim(),
                    password: password.value.trim(),
                    captcha:captcha.value.trim()
                },
                function(data){
                    var resCode = data.resCode;
                    var msg = data.msg;
                    if(resCode==1){
                        window.location = "/";
                    }else{
                        $('#img_captcha').prop('src', '/captcha-image?' + Math.random());
                        alert(msg);

                    }
                }
        );
    }
</script>
</body>
</html>
