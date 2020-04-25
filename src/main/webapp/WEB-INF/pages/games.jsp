<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Games</title>
</head>
<body>

<h2>Games</h2>
<table>
    <tr>
        <th>random</th>
    </tr>
    <c:forEach var="game" items="${gamesList}">
        <tr>
            <td>${game.random}</td>
            <td>
                <a href="/deleteGame/${game.id}">delete</a>
                <a href="/results/${game.id}">play</a>
            </td>

        </tr>
    </c:forEach>
</table>
<c:url value="/addGame/${id_u}" var="add"/>
<a href="${add}">Create new game</a>
<c:url value="/" var="back"/>
<a href="${back}">log out</a>
<c:url value="/edit/${id_u}" var="edit"/>
<a href="${edit}">edit</a>
<c:url value="/delete/${id_u}" var="delete"/>
<a href="${delete}">delete account</a>
</body>
</html>
