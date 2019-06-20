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

import com.school.koren.model.Post;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class CincoADez
 */
@WebServlet("/CincoADez")
public class CincoADez extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="cincoAdez.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CincoADez() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryHome categoryHome = new CategoryHome();
		Post post = new Post();
		PostHome postHome = new PostHome();
		
		try {			
			post.setCategoryId(categoryHome.findById(3));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
						
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/cincoAdez.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally{
			postHome.terminate();
			categoryHome.terminate();
		}
		
	}

}
