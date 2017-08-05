<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加上课时间</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        form {
            width:1000px;
            margin:0 auto;
            font-size:22px;
            border: 1px solid deepskyblue;
        }
    </style>
</head>
<body>
<form action="addSchooltimeAction" method="post" role="form" class="form-inline">
    <%--<div class="form-group">--%>
        <label class="control-label">上课时间:</label>
        <%--<div class="">--%>
            <%--<input type="text" name="time" value="" id="time" class="form-control" />--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="form-group">
         <label class="col-sm-3 control-label"></label> 
        <div class="">
            <select name="date">
                <option value="">请选择星期几</option>
                <option value="0">星期日</option>
                <option value="1">星期一</option>
                <option value="2">星期二</option>
                <option value="3">星期三</option>
                <option value="4">星期四</option>
                <option value="5">星期五</option>
                <option value="6">星期六</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <!-- <label class="col-sm-3 control-label"></label> -->
        <div class="">
            <select name="time">
                <option value="">每日上课时间</option>
                <option value="1">8:00 - 9:40</option>
                <option value="2">10:00 - 11:40</option>
                <option value="3">14:00 - 15:40</option>
                <option value="4">16:00 - 17:40</option>
                <option value="5">19:00 - 20:40</option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <div class="">
            <select name="week_start">
                <option>上课开始周</option>
                <option value="1">week-1</option>
                <option value="2">week-2</option>
                <option value="3">week-3</option>
                <option value="4">week-4</option>
                <option value="5">week-5</option>
                <option value="6">week-6</option>
                <option value="7">week-7</option>
                <option value="8">week-8</option>
                <option value="9">week-9</option>
                <option value="10">week-10</option>
                <option value="11">week-11</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="">
            <select name="week_end">
                <option>上课结束周</option>
                <option value="1">week-1</option>
                <option value="2">week-2</option>
                <option value="3">week-3</option>
                <option value="4">week-4</option>
                <option value="5">week-5</option>
                <option value="6">week-6</option>
                <option value="7">week-7</option>
                <option value="8">week-8</option>
                <option value="9">week-9</option>
                <option value="10">week-10</option>
                <option value="11">week-11</option>
            </select>
        </div>
    </div>
        <div class="form-group">
        <div class="controls">
            <input type="submit" class="btn-primary" value="添加"/>
        </div>
    </div>
</form>
</body>
</html>

