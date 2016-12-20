package com.brickchain.projectTracker.user.interfaces.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private List<String> roles;

	public UserSignUpCommand() {
	}

	public UserSignUpCommand(String email, String password, @NotNull String... roles) {
		this.email = email;
		this.password = password;
		this.roles = new ArrayList<String>(roles.length);
		Collections.addAll(this.roles, roles);
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getRoles() {
		return roles;
	}
}
