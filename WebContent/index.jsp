<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>index</title>
</head>
<body>

<%
	String contextPath = request.getContextPath();
	response.sendRedirect(contextPath + "/login.jsp");
%>

</body>
</html>