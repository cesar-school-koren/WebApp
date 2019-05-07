package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.school.PostHome;

/**
 * Servlet implementation class UserPosts
 */
@WebServlet("/UserPosts")
public class UserPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPosts() {
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
		//doGet(request, response);
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		// aqui fazer a operação de checar no banco de dados
		try {
			response.setContentType("text/html");
			PostHome postHome = new PostHome();
			Post post = new Post();
			AccountHome accountHome = new AccountHome();
			Account conta = new Account();
			conta.setUsername(username);
		
			
			post.setAccountId(accountHome.findByExample(conta).get(0));;
			
			List<Post> lista = postHome.findByExample(post);
			
			session.setAttribute("data", lista);
			
			
			for(int i = 0; i < lista.size(); i++) {
				out.println(
						"Title: " + lista.get(i).getTitle() + "</br> createdBy: " + lista.get(i).getAccountId().getUsername());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
