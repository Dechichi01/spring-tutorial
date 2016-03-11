<%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 11/03/16
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" />
    <title>Admin</title>
</head>
<body>
<h3>Authorised Users Only!</h3>

<table class="formtable">
    <tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>

    <c:forEach var="user" items="${users}">

        <tr><td><c:out value="${user.username}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.authority}"></c:out></td>
            <td><c:out value="${user.enabled}"></c:out></td>

        </tr>

    </c:forEach>

</table>

</body>
</html>
