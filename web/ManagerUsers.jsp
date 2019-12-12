<%--
  Created by IntelliJ IDEA.
  User: Cronaldo7
  Date: 2019/12/12
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">
        #divoperator input[type="button"] {
            margin: 10px 0;
        }
    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            管理中心>用户管理
        </div>
        <form>
            <fieldset>
                <legend>用户管理</legend>
                <table class="formtable">
                    <c:if test="${requestScope.meessge!=null}">
                        <tr>
                            <td colspan="2">${requestScope.meessge}</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>所有用户：</td>
                        <td>
                            <table class="listtable" id="targettable">
                                <tr class="listheader">
                                    <th>用户名</th>
                                    <th>姓名</th>
                                    <th>联系电话</th>
                                    <th>用户权限</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${requestScope.Musers}" var="user">
                                    <tr>
                                        <td>${user.username}</td>
                                        <td>${user.name}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.role}</td>
                                    <c:if test="${user.role!=3}">
                                        <td>
                                            <a class="clickbutton" href="ManagerUsers?username=${user.username}&role=2">设为会议组织者</a>|
                                            <a class="clickbutton" href="ManagerUsers?username=${user.username}&role=1">设为会议参与者</a>
                                        </td>
                                    </c:if>
                                    </tr>
                                </c:forEach>
                            </table>
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
