<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Postagens do Usuário</title>
</head>
<body>
<script>
function onLoadSubmit() {
	document.load.submit();
}
</script>
</head>
<body onload = "onLoadSubmit()">
	<a href="logout.jsp">Logout</a>
    <!-- mostra o nome do usuario logado -->
    <div class="user">
        <%
        	// pega o username a partir do atributo adicionado durante a etapa de login no servlet (src/com/school/koren/controller/Login.java)
            out.print(session.getAttribute("username"));
        %>
    </div>
	<form action="UserPosts" method="post" name="load"></form>
</body>
</body>
</html>