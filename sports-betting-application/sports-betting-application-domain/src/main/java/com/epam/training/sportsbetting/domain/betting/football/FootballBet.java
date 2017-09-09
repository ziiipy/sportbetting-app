package com.epam.training.sportsbetting.domain.betting.football;

import com.epam.training.sportsbetting.domain.betting.Bet;
import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.FootballEvent;

public abstract class FootballBet extends Bet {

	protected FootballEvent event;

	public FootballBet(Odd odd, FootballEvent event) {
		super(odd);
		this.event = event;
	}

	public FootballEvent getEvent() {
		return event;
	}

}
