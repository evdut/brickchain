package com.brickchain.projectTracker.user.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.user.domain.User;
import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.command.UserSignUpCommand;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UserSignUpCommand.class)
public class UserSignUpCommandHandler implements Handler<UserSignUpCommand> {

	@PostConstruct
	private void init() {
	}

	@PreDestroy
	private void destroy() {
	}

	@Inject
	UserRepository userRepository;

	@Override
	public void handle(UserSignUpCommand command) {
		User user = new User(command.getPassword(), command.getEmail(), command.getEmail());
		user.addGroup(userRepository.findGroupByName("USER"));
		userRepository.create(user);
		command.setResult(user.getProfileId());
	}
}
