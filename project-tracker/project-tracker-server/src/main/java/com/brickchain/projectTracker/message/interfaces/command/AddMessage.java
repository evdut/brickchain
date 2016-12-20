package com.brickchain.projectTracker.message.interfaces.command;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class AddMessage extends GenericCommand<Long> {

	@NotNull
	private Long taksId;

	@NotNull
	private String projectUUID;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String content;

	public AddMessage(Long taksId, String projectUUID, String userId, String content) {
		this.taksId = taksId;
		this.projectUUID = projectUUID;
		this.userId = userId;
		this.content = content;
	}

	public Long getTaksId() {
		return taksId;
	}

	public String getProjectUUID() {
		return projectUUID;
	}

	public String getUserId() {
		return userId;
	}

	public String getContent() {
		return content;
	}
}
