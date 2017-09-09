package com.epam.training.sportsbetting.domain.betting.football;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.FootballEvent;

public class FooballSumGoalBet extends FootballGoalBet {

	public FooballSumGoalBet(Odd odd, FootballEvent event, int goals) {
		super(odd, event, goals);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean evaulateBet() {
		return event.getGoalSum() == goals;
	}

	@Override
	public void printBet() {
		Odd odd = getOdd();
		System.out.println(String.format(
				"Bet on the %s, the sum of goals will be %d, the odd of this is %.1f and valid from %s until %s",
				event.getTitle(), goals, odd.getValue(), odd.getValidityStart().format(formatter),
				odd.getValidityEnd().format(formatter)));

	}

}
