package com.brickchain.projectTracker.project.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProjectDTO implements Serializable{
	
	private String title;
	private String description;
	private String dueDate;
	private BigDecimal originalBudget;
	private BigDecimal profit;
	private List<BigDecimal> budgetEntries;
	private List<UserDTO> participants;
	private List<TaskDTO> tasks;
	
	public ProjectDTO(String title, String description, LocalDateTime dueDate, BigDecimal originalBudget) {
		this.title = title;
		this.description = description;
		//TODO checkout with date
		this.dueDate = dueDate.format(DateTimeFormatter.BASIC_ISO_DATE);
		this.originalBudget = originalBudget;
		this.profit = originalBudget != null ? originalBudget : new BigDecimal(0);
		this.participants = new ArrayList<>();
		this.tasks = new ArrayList<>();
		this.budgetEntries = new ArrayList<>();
	}

	public ProjectDTO addUserDTO(UserDTO participant) {
		participants.add(participant);
		return this;
	}
	
	public ProjectDTO addTask(TaskDTO task) {
		tasks.add(task);
		budgetEntries.add(task.getFinalBudget());
		profit.subtract(task.getFinalBudget());
		return this;
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

	public BigDecimal getProfit() {
		return profit;
	}

	public List<BigDecimal> getBudgetEntries() {
		return budgetEntries;
	}

	public List<UserDTO> getParticipants() {
		return participants;
	}

	public List<TaskDTO> getTasks() {
		return tasks;
	}
}