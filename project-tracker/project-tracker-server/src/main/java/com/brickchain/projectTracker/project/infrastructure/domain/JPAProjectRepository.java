package com.brickchain.projectTracker.project.infrastructure.domain;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.brickchain.projectTracker.project.domain.Project;
import com.brickchain.projectTracker.project.domain.repository.ProjectRepository;

@Transactional
public class JPAProjectRepository extends JPARepository<Project> implements ProjectRepository {

	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(JPAProjectRepository.class.getName());

	public JPAProjectRepository() {
		super(Project.class);
	}

	@Override
	public List<Project> findAll() {
		try {
			return createNamedQuery("Project.findAll").getResultList();
		} catch (NoResultException e) {
			logger.info("No User found ");
			return null;
		}
	}

	@Override
	public List<Project> findByName(String title) {
		return createNamedQuery("Project.findByName")
				.setParameter("title", "%" + title + "%").getResultList();
	}

	@Override
	public List<Project> findByIds(Long[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getByProjectUUID(String projectUUID) {
		return createNamedQuery("Project.findByProjectUUID")
				.setParameter("projectUUID",  projectUUID).getSingleResult();
	}
}
