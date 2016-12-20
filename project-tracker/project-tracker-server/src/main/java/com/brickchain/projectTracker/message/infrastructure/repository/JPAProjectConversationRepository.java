package com.brickchain.projectTracker.message.infrastructure.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.brickchain.projectTracker.message.domain.Project;
import com.brickchain.projectTracker.message.domain.repository.ProjectConversationRepository;

@Transactional
public class JPAProjectConversationRepository extends JPARepository<Project> implements ProjectConversationRepository {

	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(JPAProjectConversationRepository.class.getName());

	public JPAProjectConversationRepository() {
		super(Project.class);
	}

	@Override
	public List<Project> findByIds(Long[] id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Project getByProjectUUID(String projectUUID) {
		return createNamedQuery("ProjectConversation.findByProjectUUID")
				.setParameter("projectUUID",  projectUUID).getSingleResult();
	}

}
