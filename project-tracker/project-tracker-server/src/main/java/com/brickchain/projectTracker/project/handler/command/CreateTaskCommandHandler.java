package com.brickchain.projectTracker.project.handler.command;

import java.util.Currency;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.Schedule;
import com.brickchain.projectTracker.project.domain.Task;
import com.brickchain.projectTracker.project.domain.budget.Budget;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.command.CreateTask;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = CreateTask.class)
public class CreateTaskCommandHandler implements Handler<CreateTask> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	public void handle(CreateTask command) {
		Project project = projectRepository.find(command.getProjectId());
		Currency currency = command.getCurrency();
		project.addTask(new Task(command.getTaskName(), command.getTaskDescription(),
				new Schedule(command.getDueDate()),
				new Budget(command.getOriginalBudget(), currency)));
	}
}
