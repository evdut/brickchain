package com.brickchain.projectTracker.project.handler.command;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.project.domain.User;
import com.brickchain.projectTracker.project.domain.repository.UserRepository;
import com.brickchain.projectTracker.project.interfaces.command.AddUser;
import com.brickchain.projectTracker.project.interfaces.command.UpdateBudget;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = UpdateBudget.class)
public class UpdateBudgetCommandHandler implements Handler<UpdateBudget> {

	@PostConstruct
	private void init() {

	}

	@PreDestroy
	private void destroy() {

	}

	@Inject
	UserRepository userRepository;

	@Override
	public void handle(UpdateBudget command) {
//		User user = new User(command.getProfileId(), command.getUserName(),
//				command.getFirstName(), command.getLastName());
//		userRepository.create(user);
	}
}
