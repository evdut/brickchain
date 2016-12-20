package com.brickchain.projectTracker.project.interfaces.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import javax.validation.constraints.NotNull;

import net.evdut.cqrs.framework.api.GenericCommand;

public class CreateProject extends GenericCommand<Long> {

	@NotNull
	private String profileId;

	@NotNull
	private String projectName;

	private String projectDescription;

	private LocalDateTime dueDate;

	private BigDecimal originalBudget;

	private Currency currency;

	public CreateProject(String profileId, String projectName, String projectDescription, LocalDateTime dueDate,
			BigDecimal originalBudget, String currency) {
		this.profileId = profileId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.dueDate = dueDate;
		this.originalBudget = originalBudget;
		this.currency = Currency.getInstance(currency);
	}

	public String getProfileId() {
		return profileId;
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

	public Currency getCurrency() {
		return currency;
	}
}
