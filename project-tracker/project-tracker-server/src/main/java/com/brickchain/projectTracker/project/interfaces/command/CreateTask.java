package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class CreateTask extends GenericCommand<Long> {

	@NotNull
	private Long projectId;
	
	private String taskName;
	
	private String taskDescription;
	
	private LocalDateTime dueDate;
	
	private BigDecimal originalBudget;
	
	private Currency currency;
	
	public CreateTask(Long projectId, String taskName, String taskDescription, 
			LocalDateTime dueDate, BigDecimal originalBudget, String currency) {
		this.projectId = projectId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.dueDate = dueDate;
		this.originalBudget = originalBudget;
		this.currency = Currency.getInstance(currency);
	}

	public Long getProjectId() {
		return projectId;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public BigDecimal getOriginalBudget() {
		return originalBudget;
	}

	public Currency getCurrency() {
		return currency;
	}
}
