package com.epam.training.sportsbetting.domain.betting;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Bet {

	protected List<Odd> odds = new ArrayList<>();
	protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Bet(Odd odd) {
		super();
		odds.add(odd);
		BetPool.addBets(this);
	}

	public abstract boolean evaulateBet();

	public abstract void printBet();
	
	public Odd getOdd() {
		return odds.get(odds.size()-1).copy();
	};

	public void setOdd(Odd odd) {
		odds.add(odd);
	}

}
