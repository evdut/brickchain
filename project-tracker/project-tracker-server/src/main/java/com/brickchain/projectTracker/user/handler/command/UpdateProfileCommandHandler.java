package com.brickchain.projectTracker.user.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.user.domain.User;
import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.command.UpdateProfileCommand;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateProfileCommand.class)
public class UpdateProfileCommandHandler implements Handler<UpdateProfileCommand> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	UserRepository userRepository;

	@Override
	public void handle(UpdateProfileCommand command) {
		User user = userRepository.findByProfileId(command.getProfileId());
		user.updateProfile(command.getFirstName(), command.getLastName(),
				command.getUsername(), command.getPhone());
		command.setResult(user.getProfileId());
	}
}
