package com.brickchain.projectTracker.message.application.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.message.domain.Project;
import com.brickchain.projectTracker.message.domain.repository.ProjectConversationRepository;
import com.brickchain.projectTracker.message.interfaces.command.AddProjectConversation;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = AddProjectConversation.class)
public class AddProjectConversationHandler implements Handler<AddProjectConversation> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectConversationRepository repository;

	@Override
	public void handle(AddProjectConversation command) {
		Project project = new Project(command.getProjectUUID());
		repository.create(project);
		command.setResult(project.getId());
	}
}
