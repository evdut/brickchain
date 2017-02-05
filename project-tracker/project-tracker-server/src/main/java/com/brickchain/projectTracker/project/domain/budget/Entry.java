package com.brickchain.projectTracker.project.domain.budget;

import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUDJET_ENTRY")
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BugetEntryGenerator")
	@SequenceGenerator(name = "BugetEntryGenerator", sequenceName = "Budget_ENTRY_SEQ", allocationSize = 1)
	private Long id;
	
	private BigDecimal amount;
	
	private String currencyISO;
	
	public Entry(BigDecimal amount, String currencyISO) {
		this.amount = amount;
		this.currencyISO = currencyISO;
	}
	
	public Long getId() {
		return id;
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
