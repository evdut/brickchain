package com.brickchain.projectTracker.user.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UserSignUpCommand extends GenericCommand<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String email;
	private String password;

	public UserSignUpCommand() {
	}

	public UserSignUpCommand(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
