<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <link rel="stylesheet" href="inputPages.css" type="text/css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
	<s:isAnon/>
    <s:menu/>
    <c:if test="${not empty errorMessage}">
    	<p><c:out value="Username não existe!"/></p>
    </c:if>
    <form action="Login" method="POST">
        <pre>
            Username : <input type="text" name="username">
            Password : <input type="password" name="password">
                       <input type="submit" value="Login">
        </pre>
    </form>
</body>
</html>