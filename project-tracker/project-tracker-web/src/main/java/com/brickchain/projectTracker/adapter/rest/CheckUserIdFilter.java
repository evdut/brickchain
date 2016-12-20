package com.brickchain.projectTracker.adapter.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

@CheckUserId
public class CheckUserIdFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		String userName = requestContext.getSecurityContext().getUserPrincipal().getName();
		requestContext.abortWith(Response.status( Response.Status.FORBIDDEN ).build());
	}

}
