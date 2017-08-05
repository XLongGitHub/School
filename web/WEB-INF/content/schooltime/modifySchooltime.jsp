<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改上课时间</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<s:iterator value="schooltimes">
    <form action="addSchooltimeAction" method="post" role="form" class="form-inline">
        <label class="control-label">上课时间:</label>
        <div class="form-group">
            <label class="col-sm-3 control-label"></label>
            <div class="">
                <select name="date">
                    <option value=""  <s:if test="#date == 0"> selected </s:if> >请选择星期几</option>
                    <option value="7" <s:if test="#date == 7 "> selected</s:if> >星期日</option>
                    <option value="1" <s:if test="#date == 1 "> selected</s:if> >星期一</option>
                    <option value="2" <s:if test="#date == 2 "> selected</s:if> >星期二</option>
                    <option value="3" <s:if test="#date == 3 "> selected</s:if> >星期三</option>
                    <option value="4" <s:if test="#date == 4 "> selected</s:if> >星期四</option>
                    <option value="5" <s:if test="#date == 5 "> selected</s:if> >星期五</option>
                    <option value="6" <s:if test="#date == 6 "> selected</s:if> >星期六</option>
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
        <br/>
        <div class="form-group">
            <label>描述</label>
            <input type="text" id="desc" name="desc" style="width: 600px;">
        </div>
    </form>
</s:iterator>

</body>
</html>
