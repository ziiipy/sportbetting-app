package com.epam.training.sportsbetting.domain.betting.formula1;

import com.epam.training.sportsbetting.domain.betting.Bet;
import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.Formula1Event;

public abstract class Formula1RaceBet extends Bet {

	protected Formula1Event event;

	public Formula1RaceBet(Odd odd, Formula1Event event) {
		super(odd);
		this.event = event;
	}

	public Formula1Event getEvent() {
		return event;
	}

}
