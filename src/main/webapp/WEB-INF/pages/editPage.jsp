
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.fname}">
        <title>Sign up</title>
    </c:if>
    <c:if test="${!empty user.fname}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.fname}">
    <c:url value="/signUp" var="var"/>
</c:if>
<c:if test="${!empty user.fname}">
    <c:url value="/edit" var="var"/>
</c:if>

<form action="${var}" method="POST">
    <c:if test="${!empty user.fname}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="fname">Fname</label>
    <input type="text" name="fname" id="fname">
    <label for="login">Login</label>
    <input type="text" name="login" id="login">
    <label for="password">Password</label>
    <input type="text" name="password" id="password">
    <c:if test="${empty user.fname}">
        <input type="submit" value="sign up">
    </c:if>
    <c:if test="${!empty user.fname}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>
