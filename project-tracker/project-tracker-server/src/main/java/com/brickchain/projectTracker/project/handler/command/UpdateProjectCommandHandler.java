package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.command.UpdateProject;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateProject.class)
public class UpdateProjectCommandHandler implements Handler<UpdateProject> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	public void handle(UpdateProject command) {
		Project project = projectRepository.getReference(command.getProjectId());
		project.update(command.getProjectName(), command.getProjectDescription());
		project.getBudget().update(command.getOriginalBudget());
	}
}
