<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教室信息</title>
    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${pageContext.request.contextPath}/css/bootstarp.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
<a href="addClassroomAction">添加教室</a>
<table class="table  table-bordered">
    <caption>所有教室</caption>
    <tr>
        <th>教室</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>

    <s:iterator value="classrooms">
        <tr>
            <td><s:property value="name"/> </td>
            <td><s:property value="create_time"/> </td>
            <td><s:property value="write_time"/> </td>
            <td>
                <a href="modifyClassroomAction?id=<s:property value="id"/>">
                    修改
                </a>
                <a href="deleteClassroomAction?id=<s:property value="id"/>">
                    删除
                </a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
