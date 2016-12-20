package com.brickchain.projectTracker.user.handler.query;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.dto.UserDTO;
import com.brickchain.projectTracker.user.interfaces.query.GetUsersQuery;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = GetUsersQuery.class)
public class GetUsersQueryHandler implements Handler<GetUsersQuery> {

	private static final Logger logger = Logger.getLogger(
			GetUsersQueryHandler.class.getName());
	
	@PostConstruct
    private void init() {
		
    }

    @PreDestroy
    private void destroy() {
    	
    }
    
	@Inject
	UserRepository userRepository;
	
	@Override
	public void handle(GetUsersQuery query) {
		query.setResult((ArrayList<UserDTO>) userRepository.findAll().stream().map(user -> 
			new UserDTO(user.getUserName(), user.getFirstName(), 
					user.getLastName(), user.getProfileId(), false)
			
		).collect(Collectors.toList()));
	}
}
