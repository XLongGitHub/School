<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上课时间</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table class="table  table-bordered">
    <caption>所有上课时间</caption>
    <tr>
        <th>上课日</th>
        <th>上课时间</th>
        <th>开始周</th>
        <th>结束周</th>
        <th>描述</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>

    <s:iterator value="schooltimes">
        <tr>
            <td><s:property value="date"/> </td>
            <td><s:property value="time"/> </td>
            <td><s:property value="week_start"/> </td>
            <td><s:property value="week_end"/> </td>
            <td><s:property value="desc"/> </td>
            <td><s:property value="create_time"/> </td>
            <td><s:property value="write_time"/> </td>
            <td>
                <a href="modifySchooltimeAction?id=<s:property value="id"/>">
                    修改
                </a>
                <a href="deleteSchooltimeAction?id=<s:property value="id"/>">
                    删除
                </a>
            </td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
