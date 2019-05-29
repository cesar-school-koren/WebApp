package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.koren.model.Account;
import com.school.koren.repository.AccountHome;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter writer = response.getWriter();
		
		String username = request.getParameter("username").trim();
		String email = request.getParameter("email").trim();
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if (password1.isEmpty() == false && password1.equals(password2)) {
			try {
				Date agora = new Date();
				AccountHome accountHome = new AccountHome();
				Account conta = new Account();
				conta.setUsername(username);
				conta.setPassword(password1);
				conta.setEmail(email);
				conta.setCreationDate(agora);
				conta.setPrivilege(1);
				accountHome.persist(conta);
				accountHome.terminate();
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				writer.print("Usuario ja existe!");
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
		}
		else {
			writer.print("Senhas nao batem!");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		
	}

}
