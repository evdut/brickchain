package com.brickchain.projectTracker.message.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddTaskConversation extends GenericCommand<Long> {

	@NotNull
	private Long taksId;

	@NotNull
	private String projectUUID;
	
	public AddTaskConversation(String projectUUID, Long taksId) {
		super();
		this.taksId = taksId;
		this.projectUUID = projectUUID;
	}

	public String getProjectUUID() {
		return projectUUID;
	}

	public Long getTaksId() {
		return taksId;
	}
}
