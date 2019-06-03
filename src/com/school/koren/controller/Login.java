package com.school.koren.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.koren.model.Account;
import com.school.koren.repository.AccountHome;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password");
		
		// aqui fazer a operação de checar no banco de dados
		try {
			AccountHome accountHome = new AccountHome();
			Account conta = new Account();
			Date agora = new Date();
			conta.setUsername(username);
			try {
				List<Account> lista = accountHome.findByExample(conta);
				String contaSenha = lista.get(0).getPassword();
				
				if(contaSenha.equals(password)) {
					HttpSession session = request.getSession();
					lista.get(0).setLastLogin(agora);
					accountHome.merge(lista.get(0));
					session.setAttribute("conta", lista.get(0));
					response.sendRedirect("home.jsp");
				}else {
					System.out.println("Senha errada!");
					out.print("Senha errada!");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			}catch (Exception e){
				request.setAttribute("errorMessage", "Username n�o existe!");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}

		} catch (IOException e) {
			System.out.println("Usuario nao existe!");
			out.print("Usuario nao existe!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

}
