<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">

    </style>
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
            <caption>我参加的会议：</caption>
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议地点</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.mymts}" var="mymt">
                <tr>
                    <td>${mymt.namemeeting}</td>
                    <td>${mymt.placemeeting}</td>
                    <td><fmt:formatDate value="${mymt.starttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td><fmt:formatDate value="${mymt.endtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
                    <td>
                        <a class="clickbutton" href="MeetingDetail?mid=${mymt.idmeeting}">查看详情</a>
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
</body>
</html>
