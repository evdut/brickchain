package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brickchain.projectTracker.user.interfaces.UserCommandInvoker;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserCommandInvoker userCommandInvoker;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticlesQuery query = new ArticlesQuery();
		List<ArticleDto> articles = userCommandInvoker.command(query).getResult();
		List<ArticleDto> interestingArticles = articles;
		request.setAttribute("articles", articles);
		request.setAttribute("interestingArticles", interestingArticles);
		request.setAttribute("activeMenu", "blog");
		request.setAttribute("title", "Блог");
		request.getRequestDispatcher("WEB-INF/blog.jsp").forward(request, response);
	}

}
