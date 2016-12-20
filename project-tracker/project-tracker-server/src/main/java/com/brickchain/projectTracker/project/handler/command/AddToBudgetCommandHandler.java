package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.User;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;
import com.brickchain.projectTracker.project.domain.repository.UserRepository;
import com.brickchain.projectTracker.project.interfaces.command.AddToBudget;
import com.brickchain.projectTracker.project.interfaces.command.AddUser;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = AddToBudget.class)
public class AddToBudgetCommandHandler implements Handler<AddToBudget> {

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	ProjectRepository projectRepository;

	@Override
	//TODO handle optional budget
	public void handle(AddToBudget command) {
		Project project = projectRepository.getReference(command.getProjectId());
		if(command.getTaskId() != null) {
			project.getTask(command.getTaskId()).getBudget().addToBudget(command.getAmount());
		} else {
			project.getBudget().addToBudget(command.getAmount());
		}
	}
}
