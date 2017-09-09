package com.epam.training.sportsbetting.domain.betting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetPool {

	private static List<Bet> bets = new ArrayList<>();

	public static void addBets(Bet... bets) {

		for (Bet bet : bets) {
			BetPool.bets.add(bet);
		}

	}

	public static void removeBet(Bet bet) {
		bets.remove(bet);
	}

	public static List<Bet> getBets() {
		return Collections.unmodifiableList(bets);
	}

	public static void printBets() throws Exception {

		for (int i = 0; i < bets.size(); i++) {

			System.out.print("> " + i + ": ");
			Bet bet = bets.get(i);
			bet.printBet();
		}

		System.out.println("");

	}

}
