<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>

<h2>Results</h2>
<h2>integer: ${random}</h2>
<table>
    <tr>
        <th>user_integer</th>
        <th>bulls</th>
        <th>cows</th>
    </tr>
    <c:forEach var="result" items="${resultList}">
        <tr>
            <td>${result.userint}</td>
            <td>${result.getBulls(random)}</td>
            <td>${result.getCows(random)}</td>
        </tr>
    </c:forEach>
</table>
<c:url value="/addResult/${id_game}" var="add"/>
<a href="${add}">add new integer</a>
<c:url value="/games/${id_u}" var="back"/>
<a href="${back}">back</a>
</body>
</html>

