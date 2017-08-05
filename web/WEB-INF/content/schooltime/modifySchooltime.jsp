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
    <form action="modifySchooltimeAction" method="post" role="form" class="form-horizontal">
        <input type="text" name="id" value="<s:property value="id"/>" hidden="true" />
        <div class="form-group">
            <h2><label for="time" class="col-sm-3 control-label">上课时间:</label></h2>
            <div class="col-sm-8">
                <input type="text" name="time" value="<s:property value="time"/>" id="time" class="form-control" />
            </div>
        </div>

        <br/>
        <div class="form-group">
            <div class="controls">
                <input type="submit" class="btn-primary btn-lg" value="修改"/>
            </div>
        </div>
    </form>
</s:iterator>

</body>
</html>
