package com.epam.training.sportsbetting.domain.users;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.betting.formula1.Formula1RaceBet;

public class Formula1Admin extends Admin {
	
	
	public void modifyFormula1EventBetOdd(Formula1RaceBet bet, Odd odd) {
		bet.setOdd(odd);
	}

}
