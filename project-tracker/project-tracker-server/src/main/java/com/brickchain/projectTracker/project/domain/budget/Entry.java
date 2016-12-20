package com.brickchain.projectTracker.project.domain.budget;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Table(name = "PROJECT_USER")
public class Entry {
	
	private BigDecimal amount;
	
	private String currencyISO;
	
	public Entry(BigDecimal amount, String currencyISO) {
		this.amount = amount;
		this.currencyISO = currencyISO;
	}
	
	@SuppressWarnings("unused")
	private Entry() {
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return Currency.getInstance(currencyISO);
	}
}
