package com.brickchain.projectTracker.adapter.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.brickchain.projectTracker.user.interfaces.UserCommandInvoker;
import com.brickchain.projectTracker.user.interfaces.command.UserSignUpCommand;

@Path("/public/auth")
@ApplicationScoped
public class PublicAPI {

	@Inject
	UserCommandInvoker userCommandInvoker;
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
    public void signUp(UserSignUpCommand command) {
		userCommandInvoker.command(command);
    }
}
