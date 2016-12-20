package com.brickchain.projectTracker.project.interfaces.command;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateSchedule extends GenericCommand<Long> {

	@NotNull
	private Long projectId;
	
	private Long taskId;
	
	@NotNull
	private LocalDateTime dueDate;

	/**
	 * 
	 * Update project schedule.
	 * 
	 * @param projectId
	 * @param dueDate
	 */
	
	public UpdateSchedule(Long projectId, LocalDateTime dueDate) {
		this(projectId, null, dueDate);
	}
	
	/**
	 * 
	 * Update project or task schedule
	 * 
	 * @param projectId
	 * @param taskId can be <code>null<code>
	 * @param dueDate
	 */
	public UpdateSchedule(Long projectId, Long taskId, LocalDateTime dueDate) {
		this.projectId = projectId;
		this.taskId = taskId;
		this.dueDate = dueDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}
}
