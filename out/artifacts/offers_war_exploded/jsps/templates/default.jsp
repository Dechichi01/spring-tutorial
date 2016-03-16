<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>

    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>

<div class="content">
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>

<hr/>
<div class="footer">
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>

</body>
</html>
