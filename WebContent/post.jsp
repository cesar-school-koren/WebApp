<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <a href="homeLoggedIn.jsp">Home</a>
    <a href="UserPosts">Posts</a>
    <a href="logout.jsp">Logout</a>
    <h1 class="titulo"><c:out value="${post.getTitle()}" /></h1>
    <p class="text"><c:out value="${post.getText()}" /></p>
</body>
</html>