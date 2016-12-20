package com.brickchain.projectTracker.project.interfaces.query;

import com.brickchain.projectTracker.project.interfaces.dto.ProjectDTO;
import com.brickchain.projectTracker.project.interfaces.dto.TaskDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetProjectQuery extends GenericQuery<ProjectDTO>{
	
	private Long projectId;
	
	public GetProjectQuery(Long projectId) {
		super();
		this.projectId = projectId;
	}

	public Long getProjectId() {
		return projectId;
	}
}
