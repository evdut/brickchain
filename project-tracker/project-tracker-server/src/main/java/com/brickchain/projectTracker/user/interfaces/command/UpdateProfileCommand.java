package com.brickchain.projectTracker.user.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateProfileCommand extends GenericCommand<String> {

	private String profileId;
	private String firstName;
	private String lastName;
	private String phone;
	private String username;
	
	public UpdateProfileCommand(@NotNull String profileId, String firstName, String lastName,
			String phone, @NotNull String email, String username) {
		super();
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.username = username;
	}
	public String getProfileId() {
		return profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
}
