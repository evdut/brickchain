package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.Task;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.command.UpdateProject;
import com.brickchain.projectTracker.project.interfaces.command.UpdateTask;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateTask.class)
public class UpdateTaskCommandHandler implements Handler<UpdateTask> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	public void handle(UpdateTask command) {
		Task task = projectRepository.find(command.getProjectId()).
				getTask(command.getTaskId());
		task.update(command.getTaskName(), command.getTaskDescription());
		task.getBudget().update(command.getOriginalBudget());
		task.getSchedule().updateDueDate(command.getDueDate());
	}
}
