package com.brickchain.projectTracker.message.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.brickchain.projectTracker.message.domain.repository.Repository;

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
	
	protected TypedQuery<T> createNamedQuery(String name) {
		return entityManager.createNamedQuery(name, type);
	}
//	@Override
//	public abstract List<T> findAll();
}
