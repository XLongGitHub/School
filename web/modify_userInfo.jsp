<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/3
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息中心</title>
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
<form action="modifyAction" method="post" role="form" class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-3 control-label">姓名:</label>
        <div class="col-sm-8">
            <input type="text" name="name" value="" id="name" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-3 control-label">性别:</label>
        <div class="form-group">
            <%--<div class="col-sm-offset-8 col-sm-10">--%>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="male">男
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="female">女
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="secret">保密
                    </label>
                </div>
            <%--</div>--%>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-3 control-label">地址:</label>
        <div class="col-sm-8">
            <input type="text" name="address" value="" id="address" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label for="avactor" class="col-sm-3 control-label">头像:</label>
        <div class="col-sm-8">
            <input type="text" name="avactor" value="" id="avactor" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-3 control-label">类别:</label>
        <div class="radio">
            <label>
                <input type="radio" name="grade" value="student">学生
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="grade" value="teacher">教师
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name="grade" value="admin">管理员
            </label>
        </div>
    </div>
    

    <br/>
    <div class="form-group">
        <div class="controls">
            <input type="submit" class="btn-primary btn-lg" value="修改"/>
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

</form>
</body>
</html>
