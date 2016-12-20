package com.brickchain.projectTracker.user.interfaces.query;

import java.util.ArrayList;

import com.brickchain.projectTracker.user.interfaces.dto.UserDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetUsersQuery extends GenericQuery<ArrayList<UserDTO>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * User profileId used to mark contacts of this user as contact in result list
	 * if need just a simple list of users then profileId mast be null
	 */
	private String profileId;
	
	public GetUsersQuery(String profileId) {
		this.profileId = profileId;
	}
	
	public String getUserProfileId() {
		return this.profileId;
	}
}
