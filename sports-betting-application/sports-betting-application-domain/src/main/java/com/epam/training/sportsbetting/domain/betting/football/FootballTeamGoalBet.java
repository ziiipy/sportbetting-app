package com.epam.training.sportsbetting.domain.betting.football;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.FootballEvent;
import com.epam.training.sportsbetting.domain.sportentities.SportTeam;

public class FootballTeamGoalBet extends FootballGoalBet {

	protected SportTeam team;

	public FootballTeamGoalBet(Odd odd, FootballEvent event, int goals, SportTeam team) {
		super(odd, event, goals);
		this.team = team;
	}

	@Override
	public boolean evaulateBet() {

		return event.getTeamGoals().get(team).intValue() == goals;

	}

	@Override
	public void printBet() {
		Odd odd = getOdd();

		System.out.println(String.format(
				"Bet on the %s, %s will score %d goal(s), the odd of this is %.1f and valid from %s until %s",
				event.getTitle(), team, goals, odd.getValue(), odd.getValidityStart().format(formatter),
				odd.getValidityEnd().format(formatter)));

	}

}
