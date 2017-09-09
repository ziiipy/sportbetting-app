package com.epam.training.sportsbetting.domain.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.training.sportsbetting.domain.betting.AssignedBet;

public class Player extends User {

	private String name;
	private int accountNumber;
	private float balance;
	private Currency currency;
	private LocalDate dateOfBirth;
	private List<AssignedBet> bets = new ArrayList<>();

	public Player(String name, int accountNumber, int balance, Currency currency, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.currency = currency;
		this.dateOfBirth = dateOfBirth;
	}
	
	public void addBet(AssignedBet bet) {
		
		bets.add(bet);
	}

	public void evaluateBets() {
		
		for (AssignedBet bet : bets) {

			if (!bet.isProcessed()) {

				if (bet.evaulateBet()) {
					changeBalanceByAmount(bet.getAssignedOdd() * bet.getWager());
				} else {
					changeBalanceByAmount(-bet.getWager());
				}

				bet.setProcessed(true);

			}

		}

	}

	public void changeBalanceByAmount(float amount) {
		balance += amount;
	}

	public String getName() {
		return name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public List<AssignedBet> getBets() {
		return Collections.unmodifiableList(bets);
	}

	public enum Currency {
		HUF, EUR, USD
	}

}
