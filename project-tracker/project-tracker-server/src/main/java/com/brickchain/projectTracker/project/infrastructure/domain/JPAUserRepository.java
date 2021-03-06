package com.brickchain.projectTracker.project.infrastructure.domain;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.brickchain.projectTracker.project.domain.User;
import com.brickchain.projectTracker.project.domain.repository.UserRepository;

@Transactional
public class JPAUserRepository extends JPARepository<User> implements UserRepository {

	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(JPAUserRepository.class.getName());

	public JPAUserRepository() {
		super(User.class);
	}

	@Override
	public List<User> findAll() {
		try {
			return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
		} catch (NoResultException e) {
			logger.info("No User found ");
			return null;
		}
	}

	@Override
	public List<User> findByName(String name) {
		return entityManager.createNamedQuery("User.findByName", User.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	@Override
	public List<User> findByIds(Long[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByProfileId(String profileId) {
		try {
			return entityManager.createNamedQuery("User.findByProfileId", User.class)
					.setParameter("profileId", "%" + profileId + "%").getSingleResult();
		} catch (NoResultException e) {
			logger.info("No User found for name: " + profileId);
			return null;
		}
	}

}
