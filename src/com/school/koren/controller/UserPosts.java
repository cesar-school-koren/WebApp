package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.dao.AccountHome;
import com.school.koren.dao.PostHome;
import com.school.koren.model.Account;
import com.school.koren.model.Post;

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
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		String username = session.getAttribute("username").toString();
		
		try {
			Account conta = new Account();
			AccountHome accountHome = new AccountHome();
			conta.setUsername(username);
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			post.setAccountId(accountHome.findByExample(conta).get(0));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
			
			
//			conta = accountHome.findByExample(conta).get(0);
//			
//			List<Post> postagens = new ArrayList<>();
			
//			for (Post postagem : conta.getPosts()) {
//				postagens.add(postagem);
//			}
			
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/userPost.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
