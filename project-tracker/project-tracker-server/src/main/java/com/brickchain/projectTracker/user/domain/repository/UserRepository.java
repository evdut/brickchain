package com.brickchain.projectTracker.user.domain.repository;

import java.util.List;

import com.brickchain.projectTracker.user.domain.User;

public interface UserRepository extends Repository<User>{
	public List<User> findByName(String name);
	public User findByProfileId(String profileId);
}
