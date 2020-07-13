<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/24
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<c:if test="${not empty param.error}">
    <label color="red">用户名或者密码错误</label>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post" id="demo">
    <label>账号：</label><input type="text" name="username"><br>
    <label>密码：</label><input type="password" name="password"><br>
    <label>验证码：</label><input type="text" name="verify"><img src="${pageContext.request.contextPath}/checkCode"><br>
    记住我<input type="checkbox" name="remember-me" value="true"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
<script>

</script>
</body>
</html>
