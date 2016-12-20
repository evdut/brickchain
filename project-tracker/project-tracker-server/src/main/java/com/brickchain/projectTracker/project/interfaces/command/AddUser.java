package com.brickchain.projectTracker.project.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddUser extends GenericCommand<String> {

	@NotNull
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	@NotNull
	private String profileId;

	public AddUser() {
	}

	public AddUser(String userName, String profileId, String firstName, String lastName) {
		this.userName = userName;
		this.profileId = profileId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getProfileId() {
		return profileId;
	}
}
