package com.epam.training.sportsbetting.domain.betting.formula1;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.event.Formula1Event;
import com.epam.training.sportsbetting.domain.sportentities.Sportsman;

public class Formula1RacerPlacingBet extends Formula1RaceBet {

	protected int placing;
	protected Sportsman sportsman;

	public Formula1RacerPlacingBet(Odd odd, Formula1Event event, Sportsman sportsman, int placing) {
		super(odd, event);
		this.sportsman = sportsman;
		this.placing = placing;
	}

	@Override
	public boolean evaulateBet() {
		return event.getRacerPlacings().get(sportsman).intValue() == placing;
	}

	@Override
	public void printBet() {
		Odd odd = getOdd();

		System.out.println(String.format(
				"Bet on %s at the %s, he will finish %dst/nd/rd/th, the odd of this is %.1f and valid from %s until %s",
				sportsman, event, placing, odd.getValue(), odd.getValidityStart().format(formatter),
				odd.getValidityEnd().format(formatter)));

	}
}