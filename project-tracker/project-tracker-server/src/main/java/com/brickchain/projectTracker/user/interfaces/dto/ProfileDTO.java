package com.brickchain.projectTracker.user.interfaces.dto;

import java.io.Serializable;

public class ProfileDTO implements Serializable{
	private String userName;
	private String firstName;
	private String lastName;
	private String profileId;
	private String email;
	private Boolean isContact;
	
	public ProfileDTO(String userName, String firstName, String lastName,
			String profileId, String email, Boolean isContact) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileId = profileId;
		this.email = email;
		this.isContact = isContact;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getProfileId() {
		return profileId;
	}
	
	public Boolean getIsContact() {
		return isContact;
	}

	public String getEmail() {
		return email;
	}
}