package com.brickchain.projectTracker.user.handler.query;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.brickchain.projectTracker.user.domain.User;
import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.dto.UserDTO;
import com.brickchain.projectTracker.user.interfaces.query.GetContactsQuery;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = GetContactsQuery.class)
public class GetContactsQueryHandler implements Handler<GetContactsQuery> {

	private static final Logger logger = Logger.getLogger(
			GetContactsQueryHandler.class.getName());
	
	@PostConstruct
    private void init() {
		
    }

    @PreDestroy
    private void destroy() {
    	
    }
    
	@Inject
	UserRepository userRepository;
	
	@Override
	public void handle(GetContactsQuery query) {
		User user = userRepository.findByProfileId(query.getProfileId());
		query.setResult((ArrayList<UserDTO>) user.getContacts().stream().map(contact -> {
			User userContact = contact.getContact();
			return new UserDTO(userContact.getUserName(), userContact.getFirstName(), 
					userContact.getLastName(), userContact.getProfileId(), true);}
			
		).collect(Collectors.toList()));
	}
}
