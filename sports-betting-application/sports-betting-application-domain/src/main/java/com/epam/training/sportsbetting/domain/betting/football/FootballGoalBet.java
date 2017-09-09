package com.epam.training.sportsbetting.domain.betting.football;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.FootballEvent;

public abstract class FootballGoalBet extends FootballBet {

	protected int goals;

	public FootballGoalBet(Odd odd, FootballEvent event, int goals) {
		super(odd, event);
		this.goals = goals;
	}

	public int getGoals() {
		return goals;
	}

}
