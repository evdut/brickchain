package com.brickchain.projectTracker.message.application.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.message.domain.Project;
import com.brickchain.projectTracker.message.domain.Task;
import com.brickchain.projectTracker.message.domain.repository.ProjectConversationRepository;
import com.brickchain.projectTracker.message.interfaces.command.AddTaskConversation;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = AddTaskConversation.class)
public class AddTaskConversationHandler implements Handler<AddTaskConversation> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectConversationRepository repository;

	@Override
	public void handle(AddTaskConversation command) {
		Project project = repository.getByProjectUUID(command.getProjectUUID());
		project.addTask(new Task(command.getTaksId()));
		repository.update(project);
		command.setResult(project.getId());
	}
}
