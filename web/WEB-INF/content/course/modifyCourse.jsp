<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xulong
  Date: 2017/8/4
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程信息</title>
    <!-- <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body>
<s:iterator value="courses">
    <form action="modifyCourseAction" method="post" role="form" class="form-horizontal">
        <input type="text" name="id" value="<s:property value="id"/>" hidden="true" />
        <input name="classroom_id_old" value="<s:property value="classroom_id"/>" hidden="true"/>
        <input name="schooltime_id_old" value="<s:property value="schooltime_id"/>" hidden="true"/>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">课程名:</label>
            <div class="col-sm-8">
                <input type="text" name="name" value="<s:property value="name"/>" id="name" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-3 control-label">教室:</label>
            <div class="col-sm-8">
                <%--<input type="text" name="classroom_id" value="<s:property value="classroom_id"/>" id="classroom_id" class="form-control"/>--%>
                <select name="classroom_id">
                    <s:iterator value="classrooms">
                        <option value="<s:property value="id" />"> <s:property value="name"/> </option>
                    </s:iterator>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-3 control-label">上课时间:</label>
            <div class="col-sm-8">
                <%--<input type="text" name="schooltime_id" value="<s:property value="schooltime_id"/>" id="schooltime_id" class="form-control"/>--%>
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
                <input type="submit" class="btn-primary btn-lg" value="修改"/>
            </div>
        </div>
    </form>
</s:iterator>

<script>
    window.onload = function () {
//       选中select
        var classroom_id = document.querySelector("input[name=classroom_id_old]");
        var schooltime_id = document.querySelector("input[name=schooltime_id_old");
        var classroom_ids = document.querySelector("select[name=classroom_id]");
        var schooltime_ids = document.querySelector("select[name=schooltime_id]");
        for (let i = 0; i < classroom_ids.children.length; i++) {
            if (classroom_ids.children[i].value === classroom_id.value) {
//                 classroom_ids.children[i].attributes("selected = true");
                classroom_ids.children[i].setAttribute("selected", "true");
                break;
//                alert(classroom_ids.children[i].innerHTML);
//                classroom_ids.children[i].innerHTML = ""; 
            }
        }
        for (let i = 0; i < schooltime_ids.children.length; i++) {
            if (schooltime_ids.children[i].value === schooltime_id.value) {
                schooltime_ids.children[i].setAttribute("selected", "true");
                break;
            }
        }
    }

</script>

</body>
</html>
