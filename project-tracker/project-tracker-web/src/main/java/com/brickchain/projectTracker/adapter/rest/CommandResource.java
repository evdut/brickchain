package com.brickchain.projectTracker.adapter.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.brickchain.projectTracker.interfaces.command.UserSignUpCommand;
import com.brickchain.projectTracker.interfaces.command.invoker.UserCommandInvoker;

@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("command")
@ApplicationScoped
public class CommandResource {

	@Inject
	UserCommandInvoker userCommandInvoker;

	@POST
	@Path("signUp")
	public String signUp(UserSignUpCommand command) {
		return userCommandInvoker.command(command);
	}
}
