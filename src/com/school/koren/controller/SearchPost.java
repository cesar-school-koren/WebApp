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
import com.school.koren.model.Post.Tag;
import com.school.koren.repository.CategoryHome;
import com.school.koren.repository.PostHome;

/**
 * Servlet implementation class SearchPost
 */
@WebServlet("/SearchPost")
public class SearchPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPost() {
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
		try {
			request.setCharacterEncoding("UTF-8");
			CategoryHome categoryHome = new CategoryHome();
			List<Tag> tags = new ArrayList<Tag>();
			
			// pega array de tags selecionadas
			String[] tagsSelected = request.getParameterValues("tags");
			for(int i = 0; i < tagsSelected.length; i++)
				tags.add(Tag.valueOf(tagsSelected[i]));
			
			Integer categoryId = Integer.parseInt(request.getParameter("categoria"));
			
			Post post = new Post();
			PostHome postHome = new PostHome();
			if(categoryId != 0) {
				post.setCategoryId(categoryHome.findById(categoryId));
			}

			post.setTags(tags);
			List<Post> postagens = new ArrayList<>();
			
			String text = request.getParameter("search");
			//postagens = postHome.findByExample(post);
			postagens = postHome.searchText(text);		
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/searchResult.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
