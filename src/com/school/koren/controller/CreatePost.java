package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.model.Account;
import com.school.koren.model.Post;
import com.school.koren.model.Post.Tag;
import com.school.koren.repository.AccountHome;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

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
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Account user = (Account) session.getAttribute("conta");
		
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		Integer categoryId = Integer.parseInt(request.getParameter("categoria"));
		
		// operação pra mandar post
		Date agora = new Date(); // pega data
		Post post = new Post();  // instancia objeto tipo Post
		PostHome posthome = new PostHome();  // instancia objeto PostDAO
		Account conta = new Account();  // instancia objeto Account
		AccountHome accountHome = new AccountHome(); // instancia objeto AccountDAO
		CategoryHome categoryHome = new CategoryHome(); // instancia objeto CategoryDAO
		List<Tag> tags = new ArrayList<Tag>(); // instancia uma lista de enum Tag
		
		// pega array de tags selecionadas
		String[] tagsSelected = request.getParameterValues("tags");
		for(int i = 0; i < tagsSelected.length; i++)
			tags.add(Tag.valueOf(tagsSelected[i]));
		
		conta.setUsername(user.getUsername());  
		
	
		// set atributos do objeto Post
		post.setAccountId(accountHome.findByExample(conta).get(0));
		post.setCategoryId(categoryHome.findById(categoryId));
		post.setCreationDate(agora);

		
		// set o resto dos atributos
		post.setTags(tags);
		post.setTitle(titulo);
		post.setText(texto);
		posthome.persist(post);
		response.sendRedirect("home.jsp");
	}

}
