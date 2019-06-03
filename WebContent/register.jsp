<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="inputPages.css" type="text/css">
	<meta charset="UTF-8">
	<title>Register</title>
</head>
<body>
	<s:isAnon/>
	<s:menu/>
    <c:if test="${not empty errorMessage}">
    	<p><c:out value="Username e Email já existem!"/></p>
    </c:if>
    <c:if test="${not empty errorMessageUsername}">
    	<p><c:out value="Username já existe!"/></p>
    </c:if>
    <c:if test="${not empty errorMessageEmail}">
    	<p><c:out value="Email já existe!"/></p>
    </c:if>
    <form action="Register" method="POST">
        <pre>
            Username : <input type="text" name="username" required>
            Email : <input type="text" name="email" required>
            Password : <input type="password" name="password1" required>
            Type Again : <input type="password" name="password2" required>
      					<input type="submit" value="register">
        </pre>
    </form>
</body>
</html>