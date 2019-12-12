<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem active"><a href="personaldata.jsp">个人资料</a></li>
            <li class="sidebar-menuitem"><a href="ShowMyMeetings">我的会议</a></li>
            <li class="sidebar-menuitem"><a href="ServletViewMeeting">查看会议</a></li>
        </ul>
    </div>
<%--    <c:if test="${UserLogin.role==1}">--%>
<%--        <div class="sidebar-menugroup">--%>
<%--            <div class="sidebar-grouptitle">人员管理</div>--%>
<%--            <ul class="sidebar-menu">--%>
<%--                <li class="sidebar-menuitem"><a href="reg">员工注册</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </c:if>--%>
    <c:if test="${UserLogin.role==1}">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议添加</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="bookmeeting.jsp">新建会议</a></li>
        </ul>
    </div>
    </c:if>
</div>
