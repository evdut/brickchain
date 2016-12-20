package com.brickchain.projectTracker.message.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddProjectConversation extends GenericCommand<Long> {

	@NotNull
	private String projectUUID;

	public AddProjectConversation(String projectUUID) {
		this.projectUUID = projectUUID;
	}

	public String getProjectUUID() {
		return projectUUID;
	}

}
