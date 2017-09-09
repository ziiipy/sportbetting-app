package com.epam.training.sportsbetting.domain.betting.football;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.FootballEvent;
import com.epam.training.sportsbetting.domain.sportentities.Sportsman;

public class FootballPlayerGoalBet extends FootballGoalBet {

	protected Sportsman sportsMan;

	public FootballPlayerGoalBet(Odd odd, FootballEvent event, int goals, Sportsman sportsMan) {
		super(odd, event, goals);
		this.sportsMan = sportsMan;
	}

	@Override
	public boolean evaulateBet() {

		return event.getPlayerGoals().get(sportsMan).intValue() == goals;
	}

	@Override
	public void printBet() {
		Odd odd = getOdd();

		System.out.println(String.format(
				"Bet on the %s, %s will score %d goal(s), the odd of this is %.1f and valid from %s until %s",
				event.getTitle(), sportsMan, goals, odd.getValue(), odd.getValidityStart().format(formatter),
				odd.getValidityEnd().format(formatter)));

	}

}
