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
<%@include file="../header.jsp" %>
<s:iterator value="schooltimes">
    <form action="modifySchooltimeAction" method="post" role="form" class="form-inline">
        <label class="control-label">上课时间:</label>
        <input type="text" name="id" value="<s:property value="id" />"  hidden="true">
        <div class="form-group">
            <label class="col-sm-3 control-label"></label>
            <div class="">
                <select name="date">
                    <option value=""  <s:if test="%{date == 0}"> selected </s:if> >请选择星期几</option>
                    <option value="7" <s:if test="%{date == 7}"> selected </s:if> >星期日</option>
                    <option value="1" <s:if test="%{date == 1}"> selected </s:if> >星期一</option>
                    <option value="2" <s:if test="%{date == 2}"> selected </s:if> >星期二</option>
                    <option value="3" <s:if test="%{date == 3}"> selected </s:if> >星期三</option>
                    <option value="4" <s:if test="%{date == 4}"> selected </s:if> >星期四</option>
                    <option value="5" <s:if test="%{date == 5}"> selected </s:if> >星期五</option>
                    <option value="6" <s:if test="%{date == 6}"> selected </s:if> >星期六</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <!-- <label class="col-sm-3 control-label"></label> -->
            <div class="">
                <select name="time">
                    <option value="" <s:if test="%{time == 0}"> selected </s:if> >每日上课时间</option>
                    <option value="1" <s:if test="%{time == 1}"> selected </s:if> >8:00 - 9:40</option>
                    <option value="2" <s:if test="%{time == 2}"> selected </s:if> >10:00 - 11:40</option>
                    <option value="3" <s:if test="%{time == 3}"> selected </s:if> >14:00 - 15:40</option>
                    <option value="4" <s:if test="%{time == 4}"> selected </s:if> >16:00 - 17:40</option>
                    <option value="5" <s:if test="%{time == 5}"> selected </s:if> >19:00 - 20:40</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="">
                <select name="week_start">
                    <option>上课开始周</option>
                    <option value="1" <s:if test="%{week_start == 1}"> selected </s:if>  >week-1</option>
                    <option value="2" <s:if test="%{week_start == 2}"> selected </s:if>  >week-2</option>
                    <option value="3" <s:if test="%{week_start == 3}"> selected </s:if>  >week-3</option>
                    <option value="4" <s:if test="%{week_start == 4}"> selected </s:if>  >week-4</option>
                    <option value="5" <s:if test="%{week_start == 5}"> selected </s:if>  >week-5</option>
                    <option value="6" <s:if test="%{week_start == 6}"> selected </s:if>  >week-6</option>
                    <option value="7" <s:if test="%{week_start == 7}"> selected </s:if>  >week-7</option>
                    <option value="8" <s:if test="%{week_start == 8}"> selected </s:if>  >week-8</option>
                    <option value="9" <s:if test="%{week_start == 9}"> selected </s:if>  >week-9</option>
                    <option value="10" <s:if test="%{week_start == 10}"> selected </s:if>  >week-10</option>
                    <option value="11" <s:if test="%{week_start == 11}"> selected </s:if>  >week-11</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="">
                <select name="week_end">
                    <option>上课结束周</option>
                    <option value="1" <s:if test="%{week_end == 1}"> selected </s:if>  >week-1</option>
                    <option value="2" <s:if test="%{week_end == 2}"> selected </s:if>  >week-2</option>
                    <option value="3" <s:if test="%{week_end == 3}"> selected </s:if>  >week-3</option>
                    <option value="4" <s:if test="%{week_end == 4}"> selected </s:if>  >week-4</option>
                    <option value="5" <s:if test="%{week_end == 5}"> selected </s:if>  >week-5</option>
                    <option value="6" <s:if test="%{week_end == 6}"> selected </s:if>  >week-6</option>
                    <option value="7" <s:if test="%{week_end == 7}"> selected </s:if>  >week-7</option>
                    <option value="8" <s:if test="%{week_end == 8}"> selected </s:if>  >week-8</option>
                    <option value="9" <s:if test="%{week_end == 9}"> selected </s:if>  >week-9</option>
                    <option value="10" <s:if test="%{week_end == 10}"> selected </s:if> >week-10</option>
                    <option value="11"  <s:if test="%{week_end == 11}"> selected </s:if> >week-11</option>
                </select>
            </div>
        </div>
        <div class="form-group" >
            <div class="controls">
                <input type="submit" class="btn-primary" value="添加"/>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <label>描述</label>
            <input type="text" id="desc" name="desc" style="width: 600px;" value="<s:property value="desc"/> ">
        </div>
    </form>
</s:iterator>

<script>
    window.onload = function () {
        var form = document.querySelector("form");
        var date = document.querySelector("select[name=date]");
        var time = document.querySelector("select[name=time]");
        var week_start = document.querySelector("select[name=week_start]");
        var week_end = document.querySelector("select[name=week_end]");
        var desc = document.getElementById("desc");
        var descStr = "";
        form.onclick = function () {
            descStr = "";
            descStr += week_start.value;
            descStr += " -- ";
            descStr += week_end.value;
            console.log(descStr);
            descStr += " " + dateConvert(date.value);
            console.log(descStr);
            descStr += " " + timeConvert(time.value);
            desc.value = descStr;
        }

        function dateConvert(date) {
            console.log(date);
            console.log(typeof date);
            console.log(date == 1);
            console.log(date == "1");
            var dateStr = "";
            switch (date) {
                case '1':
                    dateStr = "星期一";
                    break;
                case '2':
                    dateStr = "星期二";
                    break;
                case '3':
                    dateStr = "星期三";
                    break;
                case '4':
                    dateStr = "星期四";
                    break;
                case '5':
                    dateStr = "星期五";
                    break;
                case '6':
                    dateStr = "星期六";
                    break;
                case '7':
                    dateStr = "星期日";
                    break;
                default:
                    console.log("no");
            }
            // console.log(dateStr);
            return dateStr;
        }

        function timeConvert(time) {
            var timeStr = "";
            switch (time) {
                case '1':
                    timeStr = "8:00 - 9:40";
                    break;
                case '2':
                    timeStr = "10:00 - 11:40";
                    break;
                case '3':
                    timeStr = "14:00 - 15:40";
                    break;
                case '4':
                    timeStr = "16:00 - 17:40";
                    break;
                case '5':
                    timeStr = "19:00 - 20:40";
                    break;
            }
            return timeStr;
        }

    }
</script>

</body>
</html>
