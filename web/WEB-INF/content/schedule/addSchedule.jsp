<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/6
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程计划</title>
</head>
<body>
<table class="table">
    <caption>选课</caption>
    <tr>
        <th>课程名</th>
        <th>老师</th>
        <th>教室</th>
        <th>上课时间</th>
        <th>操作</th>
    </tr>
<s:iterator value="courseDetails">
    <tr>
        <%--<td><s:property value="id"/></td>--%>
        <td><s:property value="name"/> </td>
        <td><s:property value="teacher_name"/></td>
        <td><s:property value="classroom_name"/> </td>
        <td><s:property value="schooltime_desc"/> </td>
        <td><a href="addScheduleAction?id=<s:property value="id"/>">添加</a> </td>
    </tr>
</s:iterator>
</table>
</body>
</html>
