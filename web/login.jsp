<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/3
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
    * {
        margin: 0px;
        padding: 0px;
    }
    form {
        width:800px;
        margin:0px auto;
        background: #eee;
    }
</style>
    <form action="loginAction" method="post" role="form" class="form-horizontal">
        <div class="form-group">
            <h2><label for="phone" class="col-sm-3 control-label">电话号码:</label></h2>
            <div class="col-sm-8">
                <input type="text" name="phone" value="" id="phone" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <h2><label for="password" class="col-sm-3 control-label">密码:</label></h2>
            <div class="col-sm-8">
                <input type="password" name="password" value="" id="password" class="form-control"/>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="controls">
            <input type="submit" class="btn-primary btn-lg" value="登陆" onclick="login()"/>
            <input type="submit" class="btn-primary btn-lg" value="注册" onclick="register()"/>
            </div>
        </div>
    </form>
<script>
    window.onload = function () {
        var password = document.querySelector("#password");
        password.value = "";

        var phone = document.querySelector("#phone");
        phone.value = "";
    }
    var targetForm = document.forms[0];
    function login() {
        targetForm.action = "loginAction";
    }
    function register() {
        targetForm.action = "registerAction";
    }
</script>
</body>
</html>
