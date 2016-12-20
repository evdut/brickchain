package com.brickchain.projectTracker.project.domain.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T extends Serializable> {
	T find(Long id);

	List<T> findAll();

	void create(T entity);
	
	void update(T entity);

	void delete(T entity);

	T getReference(Long id);

	List<T> findByIds(Long[] id);

}
