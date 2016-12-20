package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brickchain.projectTracker.interfaces.command.invoker.UserCommandInvoker;
import com.brickchain.projectTracker.interfaces.query.WebinarsQuery;

@WebServlet("/webinars")
public class WebinarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserCommandInvoker userCommandInvoker;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WebinarsQuery query = new WebinarsQuery();
		request.setAttribute("webinars", userCommandInvoker.command(query).getResult());
		request.setAttribute("activeMenu", "webinars");
		request.setAttribute("title", "Вебинары");
		request.getRequestDispatcher("WEB-INF/webinars.jsp").forward(request, response);
	}

}
