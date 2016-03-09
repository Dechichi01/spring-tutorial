<%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 09/03/16
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css"
    rel="stylesheet" type="text/css">
</head>
<body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3>
<form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
    <table class="formtable">
        <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
</body>
</html>
