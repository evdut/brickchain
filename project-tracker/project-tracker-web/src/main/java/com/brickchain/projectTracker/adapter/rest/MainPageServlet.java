package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brickchain.projectTracker.interfaces.command.invoker.UserCommandInvoker;
import com.brickchain.projectTracker.interfaces.query.ArticlesQuery;
import com.brickchain.projectTracker.interfaces.query.CoursesQuery;
import com.brickchain.projectTracker.interfaces.query.WebinarsQuery;

@WebServlet("")
public class MainPageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserCommandInvoker userCommandInvoker;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CoursesQuery query = new CoursesQuery();
		ArticlesQuery articles = new ArticlesQuery();
		WebinarsQuery webinars = new WebinarsQuery();
		request.setAttribute("courses", userCommandInvoker.command(query).getResult());
		request.setAttribute("articles", userCommandInvoker.command(articles).getResult());
		request.setAttribute("webinars", userCommandInvoker.command(webinars).getResult());
		request.setAttribute("activeMenu", "main");
		request.setAttribute("title", "Главная");
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
	}

}
