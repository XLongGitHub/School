<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教室信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
<form action="addClassroomAction" method="post" role="form" class="form-horizontal">
    <div class="form-group">
        <h2><label for="name" class="col-sm-3 control-label">教室</label></h2>
        <div class="col-sm-8">
            <input type="text" name="name" value="" id="name" class="form-control" />
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
