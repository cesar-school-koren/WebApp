package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.Account;
import com.school.AccountHome;
import com.school.Commentary;
import com.school.CommentaryHome;
import com.school.Post;
import com.school.PostHome;

/**
 * Servlet implementation class CommentPost
 */
@WebServlet("/CommentPost")
public class CommentPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession(false);
		
		String texto = request.getParameter("conteudo");	// pega o texto do comentario
		String username = session.getAttribute("username").toString(); // pegar a username do usuário que vai comentar
		int postId = Integer.parseInt(request.getParameter("id")); // pegar o id do post onde está sendo feito o comentário
		
		//Operação para postar comentário
		Date agora = new Date(); // pega data
		Post post = new Post(); // instancia objeto Post
		PostHome postHome = new PostHome();  // instancia objeto PostDAO
		Account conta = new Account();  // instancia objeto Account
		AccountHome accountHome = new AccountHome(); // instancia objeto AccountDAO
		Commentary comentario = new Commentary(); // instancia objeto Commentary
		CommentaryHome commentaryHome = new CommentaryHome(); // instancia objeto CommentaryHome	
				
		try {
			post = postHome.findById(postId); // pega o post onde está sendo feito o comentário
			conta.setUsername(username); // seta o username para poder pegar a conta por ele
			conta = accountHome.findByExample(conta).get(0); // pega o usuário que está fazendo o comentário
			
			// Set atributos do comentário
			comentario.setAccountId(conta);
			comentario.setPostId(post);
			comentario.setCreationDate(agora);
			comentario.setText(texto);
			
			// Persiste o comentario para o banco de dados
			commentaryHome.persist(comentario);
			
			// Pega lista dos comentários atuais
			Commentary exemplo = new Commentary();
			exemplo.setPostId(post);
			List<Commentary> comentarios = commentaryHome.findByExample(exemplo);	
			
			//verificar - sobrescreve a sessão comentarios existente
			session.setAttribute("comentarios", comentarios);		
			response.sendRedirect(response.encodeURL("post.jsp"));			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Por favor, preencha os campos corretamente.");
		}
	}

}
