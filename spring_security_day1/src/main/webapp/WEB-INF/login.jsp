<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/24
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/securityLogin" method="post">
    <label>账号：</label><input type="text" name="username"><br>
    <label>密码：</label><input type="text" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
