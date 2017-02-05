package com.brickchain.projectTracker.project.domain;

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


@Entity(name = "ProjectUser")
@Table(name = "PROJECT_USER")
@NamedQueries({ @NamedQuery(name = "ProjectUser.findAll", query = "Select u from User u order by u.userName asc"),
		@NamedQuery(name = "ProjectUser.findByName", query = "Select u from User u where u.userName like :name order by u.userName asc"),
		@NamedQuery(name = "ProjectUser.findByProfileId", query = "Select u from User u where u.profileId like :profileId")})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571604976241524943L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "USERNAME", unique = true)
	private String userName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(unique = true)
	private String profileId;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_PROJECT", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID"))
	private List<Project> projects;

	public User() {
	}

	public User(String profileId, String userName, String firstName, String lastName) {
		this.profileId = profileId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Project createProject(String title, Project project) {
		if (projects == null) {
			projects = new ArrayList<Project>();
		}
		projects.add(project);
		return project;
	}
	
	public List<Project> getProjects() {
		return projects;
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
