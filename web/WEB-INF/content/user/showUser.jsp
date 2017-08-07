<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
<a href="addUserAction">添加用户</a>
<table class="table">
    <tr>
        <th>头像</th>
        <th>姓名</th>
        <th>性别</th>
        <th>地址</th>
        <th>电话号码</th>
        <th>等级</th>
        <th>注册时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    <%--<s:iterator value="users" id="user" status="us">--%>
    <%--<s:if test="(#us.index+1) / 7  == 0 && #us.index > 6">--%>
    <%--<tr>--%>
    <%--</s:if>--%>
    <%--<td>--%>
    <%--<s:property />--%>
    <%--</td>--%>
    <%--<s:if test="(#us.index+1) % 7 == 0 && #us.index > 6">--%>
    <%--</tr>--%>
    <%--</s:if>--%>
    <%--</s:iterator>--%>

    <s:iterator value="users">
        <tr>
                <%--String name, String avactor, String sex, String address, String phone, String grade, String create_time--%>
            <td><s:property value="avactor"/></td>
            <td><s:property value="name"/></td>
            <td class="sex"><s:property value="sex"/></td>
            <td><s:property value="address"/></td>
            <td><s:property value="phone"/></td>
            <td class="grade"><s:property value="grade"/></td>
            <td><s:property value="create_time"/></td>
            <td><s:property value="write_time"/></td>
            <td>
                <a href="modifyUserAction?id=<s:property value="id"/>&phone=<s:property value="phone"/>">修改</a>
                <a href="deleteUserAction?id=<s:property value="id"/>&phone=<s:property value="phone"/>">删除</a>
            </td>
        </tr>
    </s:iterator>
    <script>
        window.onload = function () {
            var sex = document.querySelectorAll(".sex");
            var grade = document.querySelectorAll(".grade");
            for (let i = 0; i < sex.length; i++) {
                console.log(i);
                let text = sex[i].innerText;
                let str = '';
                switch (text) {
                    case '0': str = '未知'; break;
                    case '1': str = '男' ; break;
                    case '2': str = '女' ; break;
                    case '3': str = '保密' ; break;
                }
                sex[i].innerText = str;
            }
            for (let i = 0; i < grade.length; i++) {
                let text = grade[i].innerText;
                let str = '';
                switch (text) {
                    case '0': str = '未知' ; break;
                    case '1': str = '学生' ; break;
                    case '2': str = '教师'; break;
                    case '9' : str = '管理员'; break;
                }
                grade[i].innerText = str;
            }
        }
    </script>
</table>
</body>
</html>
