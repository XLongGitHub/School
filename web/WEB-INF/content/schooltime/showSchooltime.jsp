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
<%@include file="../header.jsp" %>
<a href="addSchooltimeAction">添加上课时间安排</a>
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
            <td class="date"><s:property value="date"/> </td>
            <td class="time"><s:property value="time"/> </td>
            <td><s:property value="week_start"/> </td>
            <td><s:property value="week_end"/> </td>
            <td><s:property value="description"/> </td>
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

<script>
window.onload = function() {
    var date = document.querySelectorAll(".date");
    date.forEach(item => {
        switch (item.innerText) {
            case '1':
                item.innerText = "星期一";
                break;
            case '2':
                item.innerText = "星期二";
                break;
            case '3':
                item.innerText = "星期三";
                break;
            case '4':
                item.innerText = "星期四";
                break;
            case '5':
                item.innerText = "星期五";
                break;
            case '6':
                item.innerText = "星期六";
                break;
            case '7':
                item.innerText = "星期日";
                break;
            default:
                console.log("no");
        } 
    });
    var time = document.querySelectorAll(".time");
    time.forEach(item => {
        switch (item.innerText) {
             case '1':
                    item.innerHTML = "8:00 - 9:40";
                    break;
                case '2':
                    item.innerHTML = "10:00 - 11:40";
                    break;
                case '3':
                    item.innerHTML = "14:00 - 15:40";
                    break;
                case '4':
                    item.innerHTML = "16:00 - 17:40";
                    break;
                case '5':
                    item.innerHTML = "19:00 - 20:40";
                    break;
        }
    })
}
</script>

</body>
</html>
