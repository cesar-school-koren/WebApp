package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.model.Category;
import com.school.koren.model.Post;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class SeteADez
 */
@WebServlet("/ZeroACinco")
public class ZeroACinco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="zeroAcinco.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZeroACinco() {
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
		
		Integer categoryId = 1;
		
		try {
			Category category = new Category();
			CategoryHome categoryHome = new CategoryHome();
			category.setCategoryId(1);
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			post.setCategoryId(categoryHome.findByExample(category).get(0));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
						
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/userPost.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}