package com.brickchain.projectTracker.project.interfaces.query;

import javax.validation.constraints.NotNull;

import com.brickchain.projectTracker.project.interfaces.dto.TaskDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetTaskQuery extends GenericQuery<TaskDTO>{
	
	@NotNull
	private Long projectId;
	
	@NotNull
	private Long taskId;
	
	public GetTaskQuery(Long projectId, Long taskId) {
		super();
		this.projectId = projectId;
		this.taskId = taskId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Long getTaskId() {
		return taskId;
	}
}
