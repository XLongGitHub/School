<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有课程</title>
        <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<%@include file="../header.jsp" %>
<a href="addCourseAction">添加课程</a>
<table class="table  table-bordered">
    <caption>所有课程</caption>
    <tr>
        <th>课程名</th>
        <th>教室</th>
        <th>上课时间</th>
        <th>教师</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    
    <s:iterator value="courses">
        <tr>
            <td><s:property value="name"/> </td>
            <%--<td><s:property value="classroom_id"/> </td>--%>
            <td><s:property value="classroom_name"/> </td>
            <%--<td><s:property value="schooltime_id"/> </td>--%>
            <td><s:property value="schooltime_desc"/> </td>
            <td><s:property value="teacher_name"/> </td>
            <td><s:property value="create_time"/> </td>
            <td><s:property value="write_time"/> </td>
            <td>
                <a href="modifyCourseAction?id=<s:property value="id"/>">
                    修改
                </a>
                <a href="deleteCourseAction?id=<s:property value="id"/>">
                    删除
                </a>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
