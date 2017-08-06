<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<form action="addCourseAction" method="post" role="form" class="form-horizontal">
    <div class="form-group">
        <h2><label for="name" class="col-sm-3 control-label">课程名:</label></h2>
        <div class="col-sm-8">
            <input type="text" name="name" value="" id="name" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label">教室:</label>
        <%--<div class="col-sm-8">--%>
            <%--<input type="text" name="classroom_id" value="" id="classroom_id" class="form-control"/>--%>
        <%--</div>--%>
        <select name="classroom_id">
            <s:iterator value="classrooms">
                <option value="<s:property value="id"/> "><s:property value="name"/> </option>
            </s:iterator>
        </select>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label">上课时间:</label>
        <div class="col-sm-8">
            <%--<input type="text" name="schooltime_id" value="" id="schooltime_id" class="form-control"/>--%>
            <select name="schooltime_id">
                <s:iterator value="schooltimes">
                    <option value="<s:property value="id"/>"> <s:property value="desc"/> </option>
                </s:iterator>
            </select>
        </div>
    </div>

    <br/>
    <div class="form-group">
        <div class="controls">
            <input type="submit" class="btn-primary btn-lg" value="添加"/>
        </div>
    </div>
</form>
</body>
</html>
