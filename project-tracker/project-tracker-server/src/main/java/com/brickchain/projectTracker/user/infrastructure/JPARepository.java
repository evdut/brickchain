package com.brickchain.projectTracker.user.infrastructure;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.brickchain.projectTracker.user.domain.repository.Repository;

public abstract class JPARepository<T extends Serializable> implements Repository<T>{

	private Logger logger = Logger.getLogger(JPARepository.class.getName());
	private Class<T> type;
	
	public JPARepository(Class<T> type) {
		this.type = type;
	}

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public T find(Long id) {
		return entityManager.find(this.type, id);
	}
	
	@Override
	public void create(T entity) {
		entityManager.persist(entity);
	}
	
	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	@Override
	public T getReference(Long id) {
		return entityManager.getReference(this.type, id);
	}

	@Override
	public abstract List<T> findAll();
}
