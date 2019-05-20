package com.school.koren.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.Account;
import com.school.AccountHome;
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
		doGet(request, response);
		
		HttpSession session = request.getSession(false);
		
		String username = session.getAttribute("username").toString();
		
		try {
			Account conta = new Account();
			AccountHome accountHome = new AccountHome();
			conta.setUsername(username);
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			post.setAccountId(accountHome.findByExample(conta).get(0));
			
			List<Post> postagens = postHome.findByExample(post);
			
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("userPosts.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
