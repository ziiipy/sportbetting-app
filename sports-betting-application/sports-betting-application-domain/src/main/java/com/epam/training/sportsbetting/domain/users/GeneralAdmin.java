package com.epam.training.sportsbetting.domain.users;

import com.epam.training.sportsbetting.domain.betting.Bet;
import com.epam.training.sportsbetting.domain.betting.Odd;

public class GeneralAdmin extends Admin {
	
	
	public void modifyBetOdd(Bet bet, Odd odd) {
		bet.setOdd(odd);
	}

}
