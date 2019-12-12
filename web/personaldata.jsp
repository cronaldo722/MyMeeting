<%--
  Created by IntelliJ IDEA.
  User: Cronaldo7
  Date: 2019/12/11
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">
        #divfrom {
            float: left;
            width: 200px;
        }

        #divto {
            float: left;
            width: 200px;
        }

        #divoperator {
            float: left;
            width: 50px;
            padding: 60px 5px;
        }

        #divoperator input[type="button"] {
            margin: 10px 0;
        }

        #selDepartments {
            display: block;
            width: 100%;
        }

        #selEmployees {
            display: block;
            width: 100%;
            height: 200px;
        }

        #selSelectedEmployees {
            display: block;
            width: 100%;
            height: 225px;
        }
    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            个人资料
        </div>
        <form>
            <fieldset>
                <legend>个人资料</legend>
                <table class="formtable">
                    <tr>
                        <td>用户名：</td>
                        <td>${sessionScope.UserLogin.username}</td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td>${sessionScope.UserLogin.name}</td>
                    </tr>
                    <tr>
                        <td>工作单位：</td>
                        <td>${sessionScope.UserLogin.workunit}</td>
                    </tr>
                    <tr>
                        <td>身份证号：</td>
                        <td>${sessionScope.UserLogin.idcard}</td>
                    </tr>
                    <tr>
                        <td>联系方式：</td>
                        <td>${sessionScope.UserLogin.phone}</td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td>${sessionScope.UserLogin.sex}</td>
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
