package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.command.UpdateSchedule;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateSchedule.class)
public class UpdateScheduleCommandHandler implements Handler<UpdateSchedule> {

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	public void handle(UpdateSchedule command) {
		Project project = projectRepository.getReference(command.getProjectId());
		if(command.getTaskId() != null) {
			project.getTask(command.getTaskId()).getSchedule().updateDueDate(command.getDueDate());
		} else {
			project.getSchedule().updateDueDate(command.getDueDate());
		}
	}
}
