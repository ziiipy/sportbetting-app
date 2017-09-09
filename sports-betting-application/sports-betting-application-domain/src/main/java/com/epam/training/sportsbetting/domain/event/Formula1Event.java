package com.epam.training.sportsbetting.domain.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.training.sportsbetting.domain.sportentities.SportTeam;
import com.epam.training.sportsbetting.domain.sportentities.Sportsman;

public class Formula1Event extends SportingEvent {

	protected List<SportTeam> teams;
	protected List<Sportsman> racers;
	protected F1Location location;

	Map<Sportsman, Integer> racerPlacings;
	Map<SportTeam, Integer> teamPoints;

	private void setRacersBasedOnTeams(List<SportTeam> teams) {
		for (SportTeam team : teams) {
			for (Sportsman man : team.getPlayers()) {
				racers.add(man);
			}
		}
	}

	// TODO make a real random generation
	@Override
	public void generateRandomResults() {
		for (Entry<Sportsman, Integer> racerEntry : racerPlacings.entrySet()) {

			int placing = 1;
			int earnedPoints = 20;
			
			racerEntry.setValue(placing);

			SportTeam racerTeam = racerEntry.getKey().getTeam();

			teamPoints.put(racerTeam, teamPoints.get(racerTeam) + earnedPoints);

		}

	}

	public Formula1Event( LocalDate start, LocalDate end, List<SportTeam> teams,
			F1Location location) {
		super("F1 Grand Prix of" + location, start, end);
		this.teams = new ArrayList<>(teams);
		setRacersBasedOnTeams(this.teams);
		this.location = location;

	}

	public List<SportTeam> getTeams() {
		return teams;
	}

	public List<Sportsman> getRacers() {
		return racers;
	}

	public F1Location getLocation() {
		return location;
	}

	public Map<Sportsman, Integer> getRacerPlacings() {
		return Collections.unmodifiableMap(racerPlacings);
	}

	public Map<SportTeam, Integer> getTeamPoints() {
		return Collections.unmodifiableMap(teamPoints);
	}

	public enum F1Location {

		HUNGARY, AUSTRIA, SPA
	}

}
