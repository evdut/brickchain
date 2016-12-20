package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class UpdateBudget extends GenericCommand<Long> {

	@NotNull
	private Long projectId;
	
	private Long taskId;
	
	@NotNull
	private BigDecimal amount;

	/**
	 * 
	 * Update project budget.
	 * 
	 * @param projectId
	 * @param amount
	 */
	
	public UpdateBudget(Long projectId, BigDecimal amount) {
		this(projectId, null, amount);
	}
	
	/**
	 * 
	 * Update project or task budget
	 * 
	 * @param projectId
	 * @param taskId can be <code>null<code>
	 * @param amount
	 */
	public UpdateBudget(Long projectId, Long taskId, BigDecimal amount) {
		this.projectId = projectId;
		this.taskId = taskId;
		this.amount = amount;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
