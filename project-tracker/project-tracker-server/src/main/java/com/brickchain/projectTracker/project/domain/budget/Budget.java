package com.brickchain.projectTracker.project.domain.budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Embeddable
@Access(AccessType.FIELD)
public class Budget {

	private BigDecimal original;

	private BigDecimal last;

	private String currencyISO;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "BUDGET_ID", referencedColumnName = "ID")
	private List<Entry> entries;

	public Budget(BigDecimal amount, Currency currency) {
		this.currencyISO = currency.getCurrencyCode();
		update(amount);
	}

	public void update(BigDecimal amount) {
		if (amount != null) {
			entries = new ArrayList<>(1);
			entries.add(new Entry(amount, currencyISO));
			this.last = amount;
			this.original = amount;
		}
	}

	public void addToBudget(BigDecimal amount) {
		entries.add(new Entry(amount, currencyISO));
		this.last = this.last.add(amount);
	}

	public Budget() {
	}

	public BigDecimal getOriginal() {
		return original;
	}

	public BigDecimal getLast() {
		return last;
	}

	public Currency getCurrency() {
		return Currency.getInstance(currencyISO);
	}
}
