package com.brickchain.projectTracker.user.interfaces.query;

import javax.validation.constraints.NotNull;

import com.brickchain.projectTracker.user.interfaces.dto.ProfileDTO;

import net.evdut.cqrs.framework.api.GenericQuery;

public class GetProfileQuery extends GenericQuery<ProfileDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * sourceProfileId defines user who is requesting for a profile.
	 * Used to mark if requesting profile is a contact.
	 * 
	 * Can be <code>null</code>.
	 */
	private String sourceProfileId;
	
	/**
	 * targetProfileId defines profile that is requesting
	 */
	@NotNull
	private String targetProfileId;
	
	public GetProfileQuery(String targetProfileId) {
		this(null, targetProfileId);
	}
	
	public GetProfileQuery(String sourceProfileId, String targetProfileId) {
		this.targetProfileId = targetProfileId;
		this.sourceProfileId = sourceProfileId;
	}

	public String getSourceProfileId() {
		return sourceProfileId;
	}

	public String getTargetProfileId() {
		return targetProfileId;
	}
}
