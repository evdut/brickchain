package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.Schedule;
import com.brickchain.projectTracker.project.domain.budget.Budget;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.interfaces.command.CreateProject;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = CreateProject.class)
public class CreateProjectCommandHandler implements Handler<CreateProject> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectRepository articleRepository;

	@Override
	public void handle(CreateProject command) {
		
		Project project = new Project(command.getProjectName(), command.getProjectDescription(),
				new Schedule(command.getDueDate()), 
				new Budget(command.getOriginalBudget(), command.getCurrency()));

		command.setResult(project.getId());
	}
}
