package com.epam.training.sportsbetting.ui;

import java.io.Console;
import java.time.LocalDate;

import com.epam.training.sportsbetting.domain.betting.AssignedBet;
import com.epam.training.sportsbetting.domain.betting.BetPool;
import com.epam.training.sportsbetting.domain.users.Player;
import com.epam.training.sportsbetting.domain.users.Player.Currency;

public class Repl {

	public static void repl() throws Exception {

		Player player = new Player("Adam", 1337, 5000, Currency.HUF, LocalDate.of(1990, 12, 23));

		System.out.println("Your balance is: " + player.getBalance() + " " + player.getCurrency());

		Console console = System.console();

		boolean keepGoing = true;
		while (keepGoing) {

			System.out.println("> Enter the number associated with an event to make a bet.\n");
			BetPool.printBets();
			int response = Integer.parseInt(console.readLine());

			System.out.println("> How much do you want to bet on it?");
			long wager;
			while (true) {

				wager = Long.parseLong(console.readLine());

				if (wager > player.getBalance()) {
					System.out.println(
							"You don't have enough money (" + player.getBalance() + " " + player.getCurrency() + ")");
					System.out.print("> Enter less money: ");
				} else {
					break;
				}
			}

			AssignedBet assignetBet = new AssignedBet(BetPool.getBets().get(response - 1), LocalDate.now(), wager);

			player.addBet(assignetBet);

			player.evaluateBets();
			System.out.println("\n> Your new balance is: " + player.getBalance() + " " + player.getCurrency());

			if (player.getBalance() <= 0) {
				System.out.println("You have no more money. The program terminates.");
				break;
			}

			keepGoing = getYesOrNoResponse();
		}

	}

	private static boolean getYesOrNoResponse() {

		System.out.println("Keep Going? Y/N");

		Console console = System.console();

		while (true) {
			String response = console.readLine();

			if (response.equalsIgnoreCase("Y")) {
				return true;
			} else if (response.equalsIgnoreCase("N")) {
				return false;
			} else {
				System.out.println("Enter either \"Y\" or \"N\"");
			}
		}

	}

}
