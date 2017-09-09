package com.epam.training.sportsbetting.domain.users;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.betting.football.FootballBet;

public class FootballAdmin extends Admin {

	
	public void modifyFootallEventBetOdd(FootballBet bet, Odd odd) {
		bet.setOdd(odd);
	}
	
}
