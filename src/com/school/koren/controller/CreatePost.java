package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.school.CategoryHome;
import com.school.Post;
import com.school.Post.Tag;
import com.school.PostHome;

/**
 * Servlet implementation class Post
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePost() {
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
		doGet(request, response);
		
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		
		// operação pra mandar post
		Date agora = new Date(); // pega data
		Post post = new Post();  // instancia objeto tipo Post
		PostHome posthome = new PostHome();  // instancia objeto PostDAO
		Account conta = new Account();  // instancia objeto Account
		AccountHome accountHome = new AccountHome(); // instancia objeto AccountDAO
		CategoryHome categoryHome = new CategoryHome(); // instancia objeto CategoryDAO
		
		conta.setUsername(username);  
		
		// set atributos do objeto Post
		post.setAccountId(accountHome.findByExample(conta).get(0));
		post.setCategoryId(categoryHome.findById(1));
		post.setCreationDate(agora);
		
		// pega lista de tags e atribui ao Post
		List<Tag> tags = new ArrayList<Tag>();
		tags.add(Tag.EDUCACAO);
		
		// set o resto dos atributos
		post.setTags(tags);
		post.setTitle(titulo);
		post.setText(texto);
		posthome.persist(post);
		response.sendRedirect("homeLoggedIn.jsp");
	}

}
