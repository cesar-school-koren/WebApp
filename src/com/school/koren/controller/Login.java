package com.school.koren.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.Account;
import com.school.AccountHome;


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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password");
		
		// aqui fazer a operação de checar no banco de dados
		try {
			AccountHome accountHome = new AccountHome();
			Account conta = new Account();
			conta.setUsername(username);
			List<Account> lista = accountHome.findByExample(conta);
			String contaSenha = lista.get(0).getPassword();
			System.out.println(contaSenha);
			if(contaSenha.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("homeLoggedIn.jsp");
			}else {
				System.out.println("Senha errada!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
