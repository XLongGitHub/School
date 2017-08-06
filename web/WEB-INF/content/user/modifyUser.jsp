<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/3
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息中心</title>
</head>
<body>
<%@include file="../header.jsp" %>
<style>
    * {
        margin: 0px;
        padding: 0px;
    }

    form {
        width: 800px;
        margin: 0px auto;
        background: #eee;
    }
</style>
<s:iterator value="users">
    <form action="modifyUserAction" method="post" role="form" class="form-horizontal">
        <input name="id" value="<s:property value="id"/>" hidden="true">
        <input name="phone" value="<s:property value="phone"/>" hidden="true">
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">姓名:</label>
            <div class="col-sm-8">
                <input  name="name" value="<s:property value="name"/>" id="name" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">性别:</label>
            <div class="form-group">
                    <%--<div class="col-sm-offset-8 col-sm-10">--%>
                <div class="radio">
                    <label><input type="radio" name="sex" value="0" <s:if test="%{sex == 0}">checked</s:if> >保密</label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="1" <s:if test="%{sex == 1}"> checked</s:if>  >  男
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="2" <s:if test="%{sex == 2}"> checked</s:if> >女
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" value="3" <s:if test="%{sex == 3}"> checked</s:if> >保密
                    </label>
                </div>
                    <%--</div>--%>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-3 control-label">地址:</label>
            <div class="col-sm-8">
                <input type="text" name="address" value="<s:property value="address"/>" id="address" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="avactor" class="col-sm-3 control-label">头像:</label>
            <div class="col-sm-8">
                <input type="text" name="avactor" value="<s:property value="avactor"/>" id="avactor" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">类别:</label>
            <div class="radio">
                <label>
                    <input type="radio" name="grade" value="0" <s:if test="%{grade == 0}"> checked</s:if> >未知
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="grade" value="1" <s:if test="%{grade == 1}"> checked</s:if> >学生
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="grade" value="2" <s:if test="%{grade == 2}">checked</s:if> >教师
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="grade" value="9" <s:if test="%{grade == 9}">checked</s:if> >管理员
                </label>
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
<script>
</script>

</form>
</body>
</html>
