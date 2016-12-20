package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;

public class AddToBudget extends UpdateBudget {

	public AddToBudget(Long projectId, BigDecimal amount) {
		super(projectId, amount);
	}
	
	public AddToBudget(Long projectId, Long taskId, BigDecimal amount) {
		super(projectId, taskId, amount);
	}
}
