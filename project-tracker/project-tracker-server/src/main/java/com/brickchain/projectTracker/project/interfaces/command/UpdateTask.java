package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class UpdateTask extends CreateTask {
	
	@NotNull
	private Long taskId;
	
	public UpdateTask(Long projectId, Long taskId, String taskName, String taskDescription, 
			LocalDateTime dueDate, BigDecimal originalBudget) {
		super(projectId, taskName, taskDescription, dueDate, originalBudget, null);
		this.taskId = taskId;
	}

	public Long getTaskId() {
		return taskId;
	}
}
