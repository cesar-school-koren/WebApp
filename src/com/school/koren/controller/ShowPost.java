package com.school.koren.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.Commentary;
import com.school.Post;

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
		
		HttpSession session = request.getSession(false);
		Post post = (Post) session.getAttribute("post");
		
		try {
			List<Commentary> comentarios = new ArrayList<>();
			
			for (Commentary commentary : post.getCommentaries()) {
				comentarios.add(commentary);
			}
			
			request.setAttribute("commentaries", comentarios);
			request.getRequestDispatcher("/post.jsp").forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
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
