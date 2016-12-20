package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brickchain.projectTracker.interfaces.command.UserSignUpCommand;
import com.brickchain.projectTracker.interfaces.command.invoker.UserCommandInvoker;

@WebServlet("/signup-student")
public class SignUpStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String STUDENT_ROLE = "STUDENT";
	@EJB
	UserCommandInvoker userCommandInvoker;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserSignUpCommand command = new UserSignUpCommand(username, password, STUDENT_ROLE);
		userCommandInvoker.command(command);
	}
}
