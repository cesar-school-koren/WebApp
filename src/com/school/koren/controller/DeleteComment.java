package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.model.Commentary;
import com.school.koren.repository.CommentaryHome;

/**
 * Servlet implementation class DeleteComment
 */
@WebServlet("/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteComment() {
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
		
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		System.out.println("vou entrar no try");
		try {
			int commId = Integer.parseInt(request.getParameter("commentId"));
			System.out.println(commId);
			CommentaryHome commentaryHome= new CommentaryHome();
			Commentary commentary = commentaryHome.findById(commId);
			System.out.println(commentary.getAccountId());
			commentaryHome.delete(commentary);
			ServletContext context = getServletContext();
			context.getRequestDispatcher("/ShowPost").forward(request, response);
		} catch (IOException e) {
			writer.print("Houve um problema ao deletar o comentario!");
			RequestDispatcher rd = request.getRequestDispatcher("post.jsp");
			rd.include(request, response);
		}
		
	}

}
