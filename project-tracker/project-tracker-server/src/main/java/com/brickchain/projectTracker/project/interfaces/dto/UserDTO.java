package com.brickchain.projectTracker.project.interfaces.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{
	
	private String userName;
	private String firstName;
	private String lastName;
	private String profileId;
	
	public UserDTO(String userName, String firstName, String lastName, String profileId) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profileId = profileId;
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
}