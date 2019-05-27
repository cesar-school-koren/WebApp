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

import com.school.Commentary;
import com.school.CommentaryHome;
import com.school.Post;
import com.school.PostHome;

/**
 * Servlet implementation class ShowPost
 */
@WebServlet("/ShowPost")
public class ShowPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		int id = new Integer(request.getParameter("id"));
		
		PostHome postHome = new PostHome();
		Post post = postHome.findById(id);
		
		try {
			HttpSession session = request.getSession();
			CommentaryHome commentaryHome = new CommentaryHome();
			Commentary exemplo = new Commentary();
			exemplo.setPostId(post);
			List<Commentary> comentarios = commentaryHome.findByExample(exemplo);
						
			session.setAttribute("post", post);
			session.setAttribute("commentaries", comentarios);
			
			response.sendRedirect(response.encodeURL("post.jsp"));
			
		} catch (IOException e) {
			e.printStackTrace();
			out.println("Postagem sem comentários");
			response.sendRedirect(response.encodeURL("post.jsp")); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
