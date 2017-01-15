package com.brickchain.projectTracker.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = Optional.ofNullable(request.getServletPath()).orElse("");
		request.getRequestDispatcher((servletPath.isEmpty() ? "home" : servletPath) + ".jsp").forward(request,
				response);
	}
}
