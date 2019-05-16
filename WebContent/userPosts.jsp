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
    <!-- mostra os post dos usuários -->
	<form name="load" > <!-- o metodo action tentava chamar o servlet e dava erro, agora funcionando! -->
		<%
			// algum erro com o hibernate após muito tempo executando
			// try catch tambem nao funcionou
			String username = session.getAttribute("username").toString();
			
			Account conta = new Account();
			AccountHome accountHome = new AccountHome();
			conta.setUsername(username);
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			post.setAccountId(accountHome.findByExample(conta).get(0));
			
			
			List<Post> postagens = postHome.findByExample(post);
			
			if (!postagens.isEmpty()){
				for(Post postagem : postagens){
					%>
						<hr>
						<h2><%= postagem.getTitle() %></h2>
						<p><%= postagem.getText() %></p>
					<% 
				}
			}
			else{
				%>
					<h2>Esse usuario nao tem postagens.</h2>
				<% 
			}
		%>
	</form>
</body>
</body>
</html>