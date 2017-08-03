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
</head>
<body>
<script>
    window.onload = function () {
//        var form = document.getElementsByName("form")[0];
//        form.username.value = "";
//        form.password.value = "";

        var username = document.querySelector("input[name=username]");
        var password = document.querySelector("input[name=password]");
        username.value = "";
        password.value = "";
    }
</script>

<form action="LoginAction" method="post">
    <label for="username">姓名:</label><input type="text" name="username" value=""/>
    <label for="password">密码:</label><input type="password" name="password" value=""/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
