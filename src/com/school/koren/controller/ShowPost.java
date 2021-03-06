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

import com.school.koren.model.Commentary;
import com.school.koren.model.Post;
import com.school.koren.repository.CommentaryHome;
import com.school.koren.repository.PostHome;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession();
		int id;
		
		if (request.getParameter("id") != null) {
			id = new Integer(request.getParameter("id"));
		}
		else {
			id = ((Post) session.getAttribute("post")).getPostId(); 
		}
		
		CommentaryHome commentaryHome = new CommentaryHome();
		PostHome postHome = new PostHome();
		Post post = postHome.findById(id);
		session.setAttribute("post", post);
		
		try {
			// Pega lista dos comentarios atuais
			Commentary exemplo = new Commentary();
			exemplo.setPostId(post);
			List<Commentary> comentarios = commentaryHome.findByExample(exemplo);	
			
			if (!comentarios.isEmpty())
				comentarios = Commentary.sortComments(comentarios);
			
			// Escreve a sessao de comentarios existente
			session.setAttribute("comentarios", comentarios);

			response.sendRedirect(response.encodeURL("post.jsp"));
			
		} catch (IOException e) {
			e.printStackTrace();
			out.println("Postagem sem comentarios");
			response.sendRedirect(response.encodeURL("post.jsp")); 
		}finally {
			postHome.terminate();
			commentaryHome.terminate();
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
