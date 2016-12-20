package com.brickchain.projectTracker.user.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddContactCommand extends GenericCommand<String> {

	private String profileId;
	private String contactProfileId;
	
	public AddContactCommand(@NotNull String profileId, @NotNull String contactProfileId) {
		this.profileId = profileId;
		this.contactProfileId = contactProfileId;
	}

	public String getContactProfileId() {
		return contactProfileId;
	}

	public String getProfileId() {
		return profileId;
	}
}
