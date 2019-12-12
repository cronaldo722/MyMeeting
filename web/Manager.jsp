<%--
  Created by IntelliJ IDEA.
  User: Cronaldo7
  Date: 2019/12/7
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            个人中心 > 我的会议
        </div>
        <table class="listtable">
            <caption>我将参加的会议：</caption>
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议室名称</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议预定时间</th>
                <th>预定者</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${mrs}" var="mr">
                <tr>
                    <td>${mr.meetingname}</td>
                    <td>${mr.roomname}</td>
                    <td><fmt:formatDate value="${mr.starttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td><fmt:formatDate value="${mr.endtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td><fmt:formatDate value="${mr.reservationtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td>${mr.empname}</td>
                    <td>
                        <a class="clickbutton" href="/meeting/meetingdetail?mid=${mr.meetingid}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>




<%--<form action="ServletAddMeeting" method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>会议信息</legend>--%>
<%--        <table class="formtable">--%>
<%--            <tr>--%>
<%--                <td>会议名称：</td>--%>
<%--                <td>--%>
<%--                    <input type="text" id="meetingname" name="meetingname" maxlength="20"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>预计参加人数：</td>--%>
<%--                <td>--%>
<%--                    <input type="text" id="pnmus" name="pums"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>预计开始时间：</td>--%>
<%--                <td>--%>
<%--                    <input class="Wdate" type="text" id="starttime" name="starttime"--%>
<%--                           onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>预计结束时间：</td>--%>
<%--                <td>--%>
<%--                    <input class="Wdate" type="text" id="endtime" name="endtime"--%>
<%--                           onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>会议室名称：</td>--%>
<%--                <td>--%>
<%--                    <select name="roomid">--%>
<%--                        <c:forEach items="${mrs}" var="mr">--%>
<%--                            <option value="${mr.roomid}">${mr.roomname}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>会议说明：</td>--%>
<%--                <td>--%>
<%--                    <textarea id="description" rows="5" name="description"></textarea>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <!-- <tr>--%>
<%--                <td>选择参会人员：</td>--%>
<%--                <td>--%>
<%--                    <div id="divfrom">--%>
<%--                        <select id="selDepartments" onchange="fillEmployees()">--%>
<%--                        </select>--%>
<%--                        <select id="selEmployees" multiple="true">--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <div id="divoperator">--%>
<%--                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()"/>--%>
<%--                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()"/>--%>
<%--                    </div>--%>
<%--                    <div id="divto">--%>
<%--                        <select id="selSelectedEmployees" name="selSelectedEmployees" multiple="true">--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </td>--%>
<%--            </tr> -->--%>
<%--            <tr>--%>
<%--                <td class="command" colspan="2">--%>
<%--                    <input type="submit" class="clickbutton" value="新建会议"/>--%>
<%--                    <input type="reset" class="clickbutton" value="重置"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
</body>
</html>
