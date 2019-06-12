<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/menu.css" type="text/css">
	<link rel="stylesheet" href="CSS/inputPages.css" type="text/css">
	    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
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
            <div class="input">
                    <input type="text" name="username" placeholder="Username" class="texto" required>
                    <input type="text" name="email" placeholder="Email" class="texto" required>
                    <input type="password" name="password1" placeholder="Senha" class="texto" required>
                    <input type="password" name="password2" placeholder="Digite Novamente" class="texto" required>
                          <input type="submit" value="register" class="btn">
            </div>                          
        </pre>
    </form>
    <img src="Images/formas.png" class="formas">
</body>
</html>