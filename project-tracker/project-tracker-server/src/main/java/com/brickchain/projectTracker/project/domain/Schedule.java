package com.brickchain.projectTracker.project.domain;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable @Access(AccessType.FIELD)
public class Schedule {
	private LocalDateTime dueDate;

	public Schedule(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void updateDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	} 
}
