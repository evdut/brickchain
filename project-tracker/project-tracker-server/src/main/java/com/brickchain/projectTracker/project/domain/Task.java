package com.brickchain.projectTracker.project.domain;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.brickchain.projectTracker.project.domain.budget.Budget;

@Entity
@Table(name = "TASK")
// @NamedQueries({
// @NamedQuery(name = "Project.findAll", query = "Select p from Project p order
// by u.userName asc"),
// @NamedQuery(name = "Project.findByName", query = "Select p from Project p
// where u.userName like :name order by u.userName asc") })
public class Task implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskSeqGenerator")
	@SequenceGenerator(name = "TaskSeqGenerator", sequenceName = "TASK_ID_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "TITLE", unique = true)
	private String title;

	private String description;

	@Embedded
	private Schedule schedule;
	
	@Embedded
	private Budget budget;

	@SuppressWarnings("unused")
	private Task() {
	}

	public Task(Long id) {
		this.id = id;
	}

	public Task(String title, String description, Schedule schedule, Budget budget) {
		update(title, description);
		this.schedule = (schedule != null) ? schedule : new Schedule(null);
		this.budget = (budget != null) ? budget : new Budget();
	}

	public void update(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
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
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
