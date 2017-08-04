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
</head>
<body>
<form action="addSchooltimeAction" method="post" role="form" class="form-horizontal">
    <div class="form-group">
        <h2><label for="time" class="col-sm-3 control-label">上课时间:</label></h2>
        <div class="col-sm-8">
            <input type="text" name="time" value="" id="time" class="form-control" />
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

