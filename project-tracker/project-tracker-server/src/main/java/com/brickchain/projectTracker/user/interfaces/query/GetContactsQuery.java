package com.brickchain.projectTracker.user.interfaces.query;

import java.util.ArrayList;

import com.brickchain.projectTracker.user.interfaces.dto.UserDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetContactsQuery extends GenericQuery<ArrayList<UserDTO>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String profileId;
	
	public GetContactsQuery(String profileId) {
		this.profileId = profileId;
	}

	public String getProfileId() {
		return profileId;
	}
}
