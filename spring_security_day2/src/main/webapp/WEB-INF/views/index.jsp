<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/24
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
欢迎${username}来到首页<br>
<a href="${pageContext.request.contextPath}/toLogin">登录页面</a><br>
<security:authorize access="hasRole('ROLE_ADD_PRODUCT')">
    <a href="${pageContext.request.contextPath}/productAdd">商品新增页面</a><br>
</security:authorize>
<security:authorize access="hasRole('ROLE_DELETE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/productDel">商品删除页面</a><br>
</security:authorize>
<security:authorize access="hasRole('ROLE_LIST_PRODUCT')">
    <a href="${pageContext.request.contextPath}/productList">商品列表页面</a><br>
</security:authorize>
<security:authorize access="hasRole('ROLE_UPDATE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/productUpdate">商品更新页面</a><br>
</security:authorize>
</body>
</html>
