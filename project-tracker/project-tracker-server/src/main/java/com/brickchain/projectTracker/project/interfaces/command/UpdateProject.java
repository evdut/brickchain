package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateProject extends GenericCommand<Long> {

	@NotNull
	private Long projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	private LocalDateTime dueDate;
	
	private BigDecimal originalBudget;
	
	public UpdateProject(Long projectId, String projectName, String projectDescription, LocalDateTime dueDate,
			BigDecimal originalBudget) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.dueDate = dueDate;
		this.originalBudget = originalBudget;
	}

	public Long getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public BigDecimal getOriginalBudget() {
		return originalBudget;
	}
}
