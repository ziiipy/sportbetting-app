package com.epam.training.sportsbetting;

import java.time.LocalDate;

import com.epam.training.sportsbetting.domain.betting.Odd;
import com.epam.training.sportsbetting.domain.betting.football.FootballPlayerGoalBet;
import com.epam.training.sportsbetting.domain.betting.football.FootballTeamGoalBet;
import com.epam.training.sportsbetting.domain.event.FootballEvent;
import com.epam.training.sportsbetting.domain.event.SportingEventPool;
import com.epam.training.sportsbetting.domain.sportentities.SportTeam;
import com.epam.training.sportsbetting.domain.sportentities.Sportsman;
import com.epam.training.sportsbetting.ui.Repl;

public class App {

	public static void main(String[] args) throws Exception {

		setupMatches();

		Repl.repl();

	}

	private static void setupMatches() {
		SportTeam realMadrid = new SportTeam("Real Madrid");
		Sportsman ronaldo = new Sportsman("Ronaldo");
		Sportsman ramos = new Sportsman("Ramos");
		realMadrid.addPlayers(ronaldo, ramos);

		SportTeam barcelona = new SportTeam("Barcelona");
		Sportsman neymar = new Sportsman("Neymar");
		Sportsman messi = new Sportsman("Messi");
		barcelona.addPlayers(neymar, messi);

		LocalDate start = LocalDate.now().plusDays(1);
		LocalDate end = start.plusDays(2);

		FootballEvent madridVbarc = new FootballEvent(start, end, realMadrid, barcelona);

		Odd odd1 = new Odd(2, start, end);

		new FootballPlayerGoalBet(odd1, madridVbarc, 1, ramos);
		new FootballTeamGoalBet(odd1, madridVbarc, 2, realMadrid);

		SportingEventPool.generateRandomResults();
	}

}
