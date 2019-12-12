<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <script src="./My97DatePicker/WdatePicker.js"></script>
    <style type="text/css">

    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 查看会议
        </div>
<%--        <form action="ServletViewMeeting" method="post">--%>
<%--            <fieldset>--%>
<%--                <legend>查看会议</legend>--%>
<%--                <table class="formtable">--%>
<%--                    <tr>--%>
<%--                        <td>会议编号：</td>--%>
<%--                        <td>--%>
<%--                            <input type="text" id="idmeeting" name="idmeeting" value="${idmeeting}" maxlength="20"/>--%>
<%--                        </td>--%>
<%--                    <tr>--%>
<%--                        <td colspan="6" class="command">--%>
<%--                            <input type="submit" class="clickbutton" value="查询"/>--%>
<%--                            <input type="reset" class="clickbutton" value="重置"/>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </table>--%>
<%--            </fieldset>--%>
<%--        </form>--%>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3>
            <c:if test="${requestScope.upmmsg!=null}">
                    <p>${requestScope.upmmsg}</p>
            </c:if>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议地点</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议描述</th>
                <th>操作</th>
                <c:if test="${sessionScope.UserLogin.role==3}">
                <th>管理会议</th>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.Meetings}" var="m">
                <tr>
                    <td>${m.namemeeting}</td>
                    <td>${m.placemeeting}</td>
                    <td>${m.starttime}</td>
                    <td>${m.endtime}</td>
                    <td>${m.description}</td>
                    <td>
                        <a class="clickbutton" href="MeetingDetail?mid=${m.idmeeting}">查看详情</a>
                    </td>
                    <c:if test="${sessionScope.UserLogin.role==3}">
                        <td>
                            <a class="clickbutton" href="ManagerMeeting?mid=${m.idmeeting}">删除会议</a>
                        </td>
                    </c:if>
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
</body>
</html>
