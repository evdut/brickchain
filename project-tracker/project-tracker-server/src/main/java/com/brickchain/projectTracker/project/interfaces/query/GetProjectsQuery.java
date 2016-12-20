package com.brickchain.projectTracker.project.interfaces.query;

import java.util.ArrayList;

import com.brickchain.projectTracker.project.interfaces.dto.ProjectDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetProjectsQuery extends GenericQuery<ArrayList<ProjectDTO>>{
	
	private Long[] projectIds;
	private String participantId;
	
	public GetProjectsQuery(Long... projectIds) {
		this.projectIds = projectIds;
	}
	
	public GetProjectsQuery(String participantId) {
		this.participantId = participantId;
	}

	public Long[] getProjectIds() {
		return projectIds;
	}

	public String getParticipantId() {
		return participantId;
	}
}
