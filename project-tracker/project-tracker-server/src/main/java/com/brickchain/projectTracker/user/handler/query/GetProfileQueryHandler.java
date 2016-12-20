package com.brickchain.projectTracker.user.handler.query;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.brickchain.projectTracker.user.domain.User;
import com.brickchain.projectTracker.user.domain.repository.UserRepository;
import com.brickchain.projectTracker.user.interfaces.dto.ProfileDTO;
import com.brickchain.projectTracker.user.interfaces.query.GetProfileQuery;

import net.evdut.cqrs.framework.api.Handler;
import net.evdut.cqrs.framework.command.CommandHandler;

@Transactional
@CommandHandler(command = GetProfileQuery.class)
public class GetProfileQueryHandler implements Handler<GetProfileQuery> {

	private static final Logger logger = Logger.getLogger(
			GetProfileQueryHandler.class.getName());
	
	@PostConstruct
    private void init() {
		
    }

    @PreDestroy
    private void destroy() {
    	
    }
    
	@Inject
	UserRepository userRepository;
	
	@Override
	public void handle(GetProfileQuery query) {
		User user = userRepository.findByProfileId(query.getTargetProfileId());
		query.setResult(new ProfileDTO(user.getUserName(), user.getFirstName(),
				user.getLastName(), user.getProfileId(), user.getEmail(), false));
	}
}
