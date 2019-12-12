<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cronaldo7
  Date: 2019/12/6
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <title>Meeting会议管理系统</title>
  <link rel="stylesheet" href="styles/common.css" />
</head>

<body>
<div class="page-header">
  <div class="header-banner">
    <img src="images/header.png" alt="CoolMeeting" />
  </div>
  <div class="header-title">
    欢迎访问Meeting会议管理系统

  </div>
  <div class="header-quicklink">


  </div>
</div>
<div class="page-body">
  <div class="page-content">
    <div class="content-nav">
      登录
    </div>
    <form action="Login" method="post">
      <fieldset>
        <legend>登录信息</legend>
        <table class="formtable" style="width:50%">
          <tr>
            <td>账号名:</td>
            <td>
              <input type="text" name="name"/>
            </td>
          </tr>
          <tr>
            <td>密码:</td>
            <td>
              <input type="password" name="password"/>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="command">
              <input type="submit" value="登录" />
              <input type="reset" value="重置" />
            </td>
          </tr>
        </table>
      </fieldset>
      <a href="register.jsp">没有账号，点击注册</a>
    </form>
  </div>
</div>
<div class="page-footer">
  <hr />
  更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
  <img src="images/footer.png" alt="Meeting" />
</div>
</body>

</html>
