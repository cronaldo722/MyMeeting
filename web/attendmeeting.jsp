<%--
  Created by IntelliJ IDEA.
  User: Cronaldo7
  Date: 2019/12/11
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
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
            加入会议 > 填写资料
        </div>
        <form action="AttendMeeting" method="post">
            <fieldset>
                <legend>会议信息</legend>
                <table class="formtable">
                    <c:forEach items="${mrs}" var="mr">
                        <tr>
                            <td>

                            </td>
                            <td>
                                <input type="text" id="meetingname" name="meetingname" maxlength="20"/>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="command" colspan="2">
                            <input type="submit" class="clickbutton" value="提交"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>
