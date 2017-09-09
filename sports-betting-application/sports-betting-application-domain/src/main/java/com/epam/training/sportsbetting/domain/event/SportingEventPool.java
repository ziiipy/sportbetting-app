package com.epam.training.sportsbetting.domain.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SportingEventPool {

	private static List<SportingEvent> events = new ArrayList<>();

	public static void addEvent(SportingEvent event) {
		events.add(event);
	}

	public static List<SportingEvent> getEvents() {
		return Collections.unmodifiableList(events);
	}

	public static void generateRandomResults() {
		for (SportingEvent event : events) {

			if (!event.isFinished)

				event.generateRandomResults();

			event.isFinished = true;
		}
	}

}
