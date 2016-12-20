package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brickchain.projectTracker.interfaces.command.invoker.UserCommandInvoker;
import com.brickchain.projectTracker.interfaces.query.CoursesQuery;

@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

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
		request.setAttribute("courses", userCommandInvoker.command(query).getResult());
		request.setAttribute("activeMenu", "courses");
		request.setAttribute("title", "Курсы");
		request.getRequestDispatcher("WEB-INF/courses.jsp").forward(request, response);
	}

}
