<!-- In order to add Jslt:
	1. Google search: jslt core (for documentation)
	2. Copy the General sintax and add to the jsp file
-->

<!--  In order do add Jndi (tomcat):
	1. Google search: tomcat8 mysql datasource jndi
	2. Follow the instructions
		2.1 If you already have a database look for: Configure the JNDI DataSource in Tomcat by adding a declaration for your resource to your Context.
	3. Change the user and password fields (if is a company project it's necessary to alter the mysql url as well
	
		
	
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- This is the added jslt tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- sql prefix -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	

<p><a href="${pageContext.request.contextPath}/offers">Show current offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a></p>

</body>
</html>

