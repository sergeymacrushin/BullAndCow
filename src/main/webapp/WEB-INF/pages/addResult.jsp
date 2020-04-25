
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>Add</title>
</head>
<body>
    <c:url value="/addResult" var="var"/>
<form action="${var}" method="POST">
    <label for="integer">integer</label>
    <input type="text" name="userint" id="integer">
    <input type="hidden" name="id_game" value="${id_game}">
        <input type="submit" value="Add new integer">

</form>
</body>
</html>
