package com.epam.training.sportsbetting.domain.betting;

import java.time.LocalDate;

public class AssignedBet {

	private Bet bet;
	private float assignedOdd;
	private LocalDate timeStamp;
	private long wager;
	private boolean isProcessed = false;

	public AssignedBet(Bet bet, LocalDate timeStamp, long wager) {
		super();
		this.bet = bet;
		assignedOdd = bet.getOdd().getValue();
		this.timeStamp = timeStamp;
		this.wager = wager;

	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public boolean evaulateBet() {
		return bet.evaulateBet();
	}

	public Bet getBet() {
		return bet;
	}

	public float getAssignedOdd() {
		return assignedOdd;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public long getWager() {
		return wager;
	}

}
