package com.brickchain.projectTracker.notification.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NOTIFICATION")
public class Notification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NotificationSeqGenerator")
	@SequenceGenerator(name = "NotificationSeqGenerator", sequenceName = "NOTIFICATION_ID_SEQ", allocationSize = 1)
	private Long id;

	private String action;
	private String sourceUsers;
	private LocalDateTime eventDate;
	private Boolean read;

	public Notification() {
	}

	public Notification(String profileId) {
		this.profileId = profileId;
	}

	public Notification(Long id) {
		this.id = id;
	}

	public void updateProfile(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public String getProfileId() {
		return this.profileId;
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

	// TODO update after exception handling is implemented
	public Project getProject(Long projectId) {
		return projects.stream().filter(project -> project.getId().equals(projectId)).findAny()
				.orElseThrow(() -> new RuntimeException(""));
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.profileId);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Notification other = (Notification) obj;
		return Objects.equals(this.profileId, other.profileId);
	}
}
