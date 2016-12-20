package com.brickchain.projectTracker.project.domain.repository;

import java.util.List;

import com.brickchain.projectTracker.project.domain.Project;

public interface ProjectRepository extends Repository<Project>{
	public List<Project> findByName(String title);
	
	public Project getByProjectUUID(String projectUUID);
}
