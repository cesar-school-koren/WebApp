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
 * Servlet implementation class DezAQuinze
 */
@WebServlet("/DezAQuinze")
public class DezAQuinze extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page="dezAQuinze.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DezAQuinze() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostHome postHome = new PostHome();
		CategoryHome categoryHome = new CategoryHome();
		
		try {
			
			Post post = new Post();

			post.setCategoryId(categoryHome.findById(4));
			
			List<Post> postagens = new ArrayList<>();
			
			for (Post postagem : postHome.findByExample(post)) {
				postagens.add(postagem);
			}
						
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/dezAquinze.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally{
			postHome.terminate();
			categoryHome.terminate();
		}
	}

}
