<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Logout</title>
</head>
<body>
	<%
		// termina a sessao http e redireciona para a home page comum
		session.invalidate();
		response.sendRedirect("homeNotLoggedIn.jsp");
	%>
</body>
</html>