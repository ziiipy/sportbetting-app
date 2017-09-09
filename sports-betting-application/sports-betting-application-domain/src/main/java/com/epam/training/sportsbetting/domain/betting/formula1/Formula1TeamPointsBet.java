package com.epam.training.sportsbetting.domain.betting.formula1;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.Formula1Event;
import com.epam.training.sportsbetting.domain.sportentities.SportTeam;

public class Formula1TeamPointsBet extends Formula1RaceBet {

	protected int teamPoints;
	protected SportTeam team;

	public Formula1TeamPointsBet(Odd odd, Formula1Event event, int teamPoints, SportTeam team) {
		super(odd, event);
		this.teamPoints = teamPoints;
		this.team = team;
	}

	@Override
	public boolean evaulateBet() {
		return event.getTeamPoints().get(team).intValue() == teamPoints;
	}

	@Override
	public void printBet() {

		Odd odd = getOdd();

		System.out.println(String.format(
				"> %d: Bet on %s at the %s, they will score %d, the odd of this is %.1f and valid from %s until %s",
				team, event, teamPoints, odd.getValue(), odd.getValidityStart().format(formatter),
				odd.getValidityEnd().format(formatter)));

	}

	public SportTeam getTeam() {
		return team;
	}

	public int getTeamPoints() {
		return teamPoints;
	}

}
