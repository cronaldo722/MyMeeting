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
            会议详情
            <a href="AttendMeeting?mid=${mt.idmeeting}">【加入会议】</a>
        </div>
        <form>
            <fieldset>
                <legend>会议信息</legend>
                <table class="formtable">
                    <tr>
                        <td>会议编号：</td>
                        <td>${mt.idmeeting}</td>
                    </tr>
                    <tr>
                        <td>会议名称：</td>
                        <td>${mt.namemeeting}</td>
                    </tr>
                    <tr>
                        <td>会议地点：</td>
                        <td>${mt.placemeeting}</td>
                    </tr>
                    <tr>
                        <td>会议房间号：</td>
                        <td>${mt.roomid}</td>
                    </tr>
                    <tr>
                        <td>预计参加人数：</td>
                        <td>${mt.pnums}</td>
                    </tr>
                    <tr>
                        <td>预计开始时间：</td>
                        <td>${mt.starttime}</td>
                    </tr>
                    <tr>
                        <td>预计结束时间：</td>
                        <td>${mt.endtime}</td>
                    </tr>
                    <tr>
                        <td>会议说明：</td>
                        <td>
                            <textarea id="description" rows="5" readonly>${mt.description}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>参会人员：</td>
                        <td>
                            <table class="listtable" id="targettable">
                                <tr class="listheader">
                                    <th>姓名</th>
                                    <th>联系电话</th>
                                    <th>性别</th>
                                </tr>
                                <c:forEach items="${requestScope.users}" var="user">
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.sex}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td class="command" colspan="2">
                            //待实现下载功能
                            <a href="javascript:" onclick="loadExcel();">
                                <input id="Button1" type="button" value="导出人员信息" />
                            </a>
<%--                            <input type="button" class="clickbutton" value="下载人员信息" onclick="">--%>
                            <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                        </td>
                    </tr>
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
