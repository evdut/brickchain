package com.brickchain.projectTracker.project.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaskDTO implements Serializable{
	
	private String title;
	private String description;
	private String dueDate;
	private BigDecimal originalBudget;
	private BigDecimal finalBudget;
	private BigDecimal[] budgetEntries;
	private String performerProfileId;
	
	public TaskDTO(String title, String description, String dueDate, BigDecimal originalBudget, BigDecimal finalBudget,
			BigDecimal[] budgetEntries, String performerProfileId) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.originalBudget = originalBudget;
		this.finalBudget = finalBudget;
		this.budgetEntries = budgetEntries;
		this.performerProfileId = performerProfileId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public BigDecimal getOriginalBudget() {
		return originalBudget;
	}

	public BigDecimal getFinalBudget() {
		return finalBudget;
	}

	public BigDecimal[] getBudgetEntries() {
		return budgetEntries;
	}

	public String getPerformerProfileId() {
		return performerProfileId;
	}
}