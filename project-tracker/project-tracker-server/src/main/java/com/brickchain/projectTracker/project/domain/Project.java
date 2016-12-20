package com.brickchain.projectTracker.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.brickchain.projectTracker.project.domain.budget.Budget;
import com.brickchain.projectTracker.utils.ConstantUtils;

@Entity
@Table(name = "PROJECT")
 @NamedQueries({
 @NamedQuery(name = "Project.findAll", query = "Select p from Project p order by p.title asc"),
 @NamedQuery(name = "Project.findByName", query = "Select p from Project p where p.title like :title order by p.title asc"),
 @NamedQuery(name = "Project.findByProjectUUID", query = "Select p from Project p where p.projectUUID like :projectUUID") })
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProjectSeqGenerator")
	@SequenceGenerator(name = "ProjectSeqGenerator", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "TITLE", unique = true)
	private String title;

	private String description;

	@Column(unique = true)
	private String projectUUID;
	
	@Embedded
	private Schedule schedule;

	@Embedded
	private Budget budget;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
	private List<Task> tasks;

	@ManyToMany(mappedBy = "projects")
	private List<User> users;

	@SuppressWarnings("unused")
	private Project() {
	}

	public Project(Long id) {
		this.id = id;
	}

	public Project(String title, String description, Schedule schedule, Budget budget) {
		this.users = new ArrayList<>();
		this.title = title;
		this.description = description;
		this.schedule = (schedule != null) ? schedule : new Schedule(null);
		this.budget = (budget != null) ? budget : new Budget();
		this.tasks = new ArrayList<Task>(0);
	}

	public void update(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void removeUser(User user) {
		this.users.remove(user);
	}

	public List<User> getUsers() {
		return users;
	}

	@PostPersist
	private void createProjectUUID() {
		this.projectUUID = String.format(ConstantUtils.UUID_FORMAT, id);
	}
	
	public void addTask(Task task) {
		//TODO Multicurrency ?????????!!!!!!!!!!!
		if(task.getBudget().getCurrency() != budget.getCurrency()) {
			throw new RuntimeException(String.format("Currency of task '%s' does not equal currency of the project", task.getTitle()));
		}
		this.tasks.add(task);
	}

	public void removeTask(Task task) {
		this.tasks.remove(task);
	}

	public List<Task> getTasks() {
		return tasks;
	}
	
	//TODO update after exception handling is implemented
	public Task getTask(Long taskId) {
		return tasks.stream().filter(task -> task.getId().equals(taskId)).
				findAny().orElseThrow(() -> new RuntimeException(""));
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getProjectUUID() {
		return projectUUID;
	}

	public String getDescription() {
		return description;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public Budget getBudget() {
		return budget;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
