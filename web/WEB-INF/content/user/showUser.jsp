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
            <td><s:property value="sex"/></td>
            <td><s:property value="address"/></td>
            <td><s:property value="phone"/></td>
            <td><s:property value="grade"/></td>
            <td><s:property value="create_time"/></td>
            <td><s:property value="write_time"/></td>
            <td>
                <a href="modifyUserAction?id=<s:property value="id"/>&phone=<s:property value="phone"/>">修改</a>
                <a href="deleteUserAction?id=<s:property value="id"/>&phone=<s:property value="phone"/>">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
