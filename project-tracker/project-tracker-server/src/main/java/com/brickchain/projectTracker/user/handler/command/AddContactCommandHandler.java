package com.brickchain.projectTracker.user.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.user.domain.User;
import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.command.AddContactCommand;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = AddContactCommand.class)
public class AddContactCommandHandler implements Handler<AddContactCommand> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	UserRepository userRepository;

	@Override
	public void handle(AddContactCommand command) {
		User user = userRepository.findByProfileId(command.getProfileId());
		User userContact = userRepository.findByProfileId(command.getContactProfileId());
		user.addContact(userContact);
		command.setResult(userContact.getProfileId());
	}
}
