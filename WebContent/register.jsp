<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="inputPages.css" type="text/css">
	<meta charset="UTF-8">
	<title>Register</title>
</head>
<body>
    <a href="homeNotLoggedIn.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <form action="Register" method="POST">
        <pre>
            Username : <input type="text" name="username">
            Email : <input type="text" name="email">
            Password : <input type="password" name="password1">
            Type Again : <input type="password" name="password2">
      					<input type="submit" value="register">
        </pre>
    </form>
</body>
</html>