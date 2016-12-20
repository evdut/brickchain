package com.brickchain.projectTracker.message.application.command;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.message.domain.Conversation;
import com.brickchain.projectTracker.message.domain.Message;
import com.brickchain.projectTracker.message.domain.Project;
import com.brickchain.projectTracker.message.domain.repository.ProjectConversationRepository;
import com.brickchain.projectTracker.message.interfaces.command.AddMessage;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = AddMessage.class)
public class AddMessageHandler implements Handler<AddMessage> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	ProjectConversationRepository repository;

	@Override
	public void handle(AddMessage command) {
		Project project = repository.getByProjectUUID(command.getProjectUUID());
		Message message = new Message(LocalDateTime.now(), command.getUserId(), command.getContent());
		Conversation conversation = command.getTaksId() != null ?
				project.getTask(command.getTaksId()) : project;
		conversation.addMessages(message);
		repository.update(project);
		command.setResult(message.getId());
	}
}
