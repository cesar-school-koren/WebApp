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
		PostHome postHome = new PostHome();
		CategoryHome categoryHome = new CategoryHome();
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			List<Tag> tags = new ArrayList<Tag>();
			
			// pega array de tags selecionadas
			String[] tagsSelected = request.getParameterValues("tags");
			
			for(String tag : tagsSelected) {
				if(!tag.equals("QUALQUER")) {
					tags.add(Tag.valueOf(tag));
				}
			}
				
			Integer categoryId = Integer.parseInt(request.getParameter("categoria"));
			
			Post post = new Post();
			
			if(categoryId != 0) {
				post.setCategoryId(categoryHome.findById(categoryId));
			}
			
			if(tags.size()!= 0)
				post.setTags(tags);
						
			List<Post> postagens = new ArrayList<>();
			
			if(categoryId == 0 && tags.size() == 0) {
				postagens = postHome.getAll();
			}else {
				postagens = postHome.findByExample(post);
			}
				
			request.setAttribute("posts", postagens);
			
			RequestDispatcher rd = request.getRequestDispatcher("/searchResult.jsp");
			rd.forward(request, response);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			postHome.terminate();
			categoryHome.terminate();
		}
	}

}
