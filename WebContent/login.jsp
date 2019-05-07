<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="inputPages.css" type="text/css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <a href="homeNotLoggedIn.jsp">Home</a>
    <form action="Login" method="POST">
        <pre>
            Username : <input type="text" name="username">
            Password : <input type="password" name="password">
                       <input type="submit" value="Login">
        </pre>
    </form>
    <a href="register.jsp">Register</a>
</body>
</html>