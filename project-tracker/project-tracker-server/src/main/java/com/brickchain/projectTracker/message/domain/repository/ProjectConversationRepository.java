package com.brickchain.projectTracker.message.domain.repository;

import com.brickchain.projectTracker.message.domain.Project;

public interface ProjectConversationRepository extends Repository<Project>{
	public Project getByProjectUUID(String projectUUID);
}
