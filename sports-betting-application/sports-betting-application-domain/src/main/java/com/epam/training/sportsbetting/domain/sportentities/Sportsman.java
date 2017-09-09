package com.epam.training.sportsbetting.domain.sportentities;

public class Sportsman {

	private String name;
	private SportTeam team;

	public Sportsman(String name) {
		super();
		this.name = name;
	}

	public SportTeam getTeam() {
		return team;
	}

	public String getName() {
		return name;
	}

	public void setTeam(SportTeam team) {
		this.team = team;
	}

}
