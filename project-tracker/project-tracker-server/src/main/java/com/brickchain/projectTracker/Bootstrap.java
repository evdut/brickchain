package com.brickchain.projectTracker;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.brickchain.projectTracker.user.domain.Group;

@Singleton
@Startup
@LocalBean
public class Bootstrap {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void init() {
		Group group = new Group("USER", null);
		em.persist(group);
	}
}
