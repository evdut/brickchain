package com.brickchain.projectTracker.notification.domain;

import java.io.Serializable;
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
@Table(name = "NOTIFICATION_USER")
@NamedQuery(name = "User.findByProfileId", query = "Select u from User u where u.profileId like :profileId")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NotificationUserSeqGenerator")
	@SequenceGenerator(name = "NotificationUserSeqGenerator", sequenceName = "NOTIFICATION_USER_ID_SEQ", allocationSize = 1)
	private Long id;

	@Column(unique = true)
	private String profileId;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_PROJECT", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID"))
	private List<Project> projects;

	public User() {
	}

	public User(String profileId) {
		this.profileId = profileId;
	}

	public User(Long id) {
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
		final User other = (User) obj;
		return Objects.equals(this.profileId, other.profileId);
	}
}
