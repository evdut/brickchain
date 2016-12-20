package com.brickchain.projectTracker.project.domain.repository;

import java.util.List;

import com.brickchain.projectTracker.project.domain.User;

public interface UserRepository extends Repository<User>{
	public List<User> findByName(String name);
	public User findByProfileId(String profileId);
}
