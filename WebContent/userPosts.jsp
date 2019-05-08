<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.school.PostHome"%>
<%@page import="com.school.Post"%>
<%@page import="com.school.AccountHome"%>
<%@page import="com.school.Account"%>
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
    <!-- mostra os post dos usuários (atualmente nao funcionando) -->
	<form action="UserPosts" method="post" name="load">
		<%
			String username = session.getAttribute("username").toString();
			
			Account conta = new Account();
			AccountHome accountHome = new AccountHome();
			conta.setUsername(username);
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			post.setAccountId(accountHome.findByExample(conta).get(0));
			
			// pegar a lista de posts 
			List<Post> postagens = postHome.findByExample(post);
			
			// erro em algo no codigo html abaixo?????
			for(Post postagem : postagens){
				%>
					<hr>
					<h2>(<%= postagem.getTitle() %>)</h2>
					<p>(<%= postagem.getText() %>)</p>
				<% 
			}
		%>
	</form>
</body>
</body>
</html>