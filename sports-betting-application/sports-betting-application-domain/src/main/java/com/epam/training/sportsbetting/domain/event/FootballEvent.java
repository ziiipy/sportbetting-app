package com.epam.training.sportsbetting.domain.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.sportsbetting.domain.sportentities.SportTeam;
import com.epam.training.sportsbetting.domain.sportentities.Sportsman;

public class FootballEvent extends SportingEvent {

	private SportTeam teamA;
	private SportTeam teamB;
	private int teamSize = 11;
	private List<Sportsman> players = new ArrayList<>(teamSize);

	private int goalSum;
	private Map<SportTeam, Integer> teamGoals = new HashMap<>(2);
	private Map<Sportsman, Integer> playerGoals = new HashMap<>(teamSize);

	// TODO make a real random result generator
	@Override
	public void generateRandomResults() {

		for (Sportsman player : players) {

			int goals = 1;
			playerGoals.put(player, goals);

			SportTeam team = player.getTeam();
			
			teamGoals.put(team, teamGoals.get(team) + 1);
		}

	}

	public FootballEvent(LocalDate start, LocalDate end, SportTeam teamA, SportTeam teamB) {
		super(teamA.getName() + " vs " + teamB.getName() + " football match", start, end);
		this.teamA = teamA;
		this.teamB = teamB;
		
		teamGoals.put(teamA, 0);
		teamGoals.put(teamB, 0);

		addPlayersFromTeams(teamA, teamB);
	}

	private void addPlayersFromTeams(SportTeam... teams) {

		for (SportTeam team : teams) {
			for (Sportsman player : team.getPlayers()) {
				players.add(player);
			}
		}
	}

	public SportTeam getTeamA() {
		return teamA;
	}

	public SportTeam getTeamB() {
		return teamB;
	}

	public int getGoalSum() {
		return goalSum;
	}

	public Map<SportTeam, Integer> getTeamGoals() {
		return Collections.unmodifiableMap(teamGoals);
	}

	public Map<Sportsman, Integer> getPlayerGoals() {
		return Collections.unmodifiableMap(playerGoals);
	}

}
