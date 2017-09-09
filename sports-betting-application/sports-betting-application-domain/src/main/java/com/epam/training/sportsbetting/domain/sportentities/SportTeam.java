package com.epam.training.sportsbetting.domain.sportentities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SportTeam {

	private String name;
	private Set<Sportsman> members = new HashSet<>();

	public SportTeam(String name, Sportsman... sportsmans) {
		super();
		this.name = name;
		this.members = new HashSet<>(members);
		members.stream().forEach(player -> player.setTeam(this));
	}

	public SportTeam(String name) {
		super();
		this.name = name;
	}

	public void addPlayers(Sportsman ...players) {
		for (Sportsman player : players) {
			members.add(player);
			player.setTeam(this);
		}
	}

	public Set<Sportsman> getPlayers() {
		return Collections.unmodifiableSet(members);
	}

	public String getName() {
		return name;
	}

}
