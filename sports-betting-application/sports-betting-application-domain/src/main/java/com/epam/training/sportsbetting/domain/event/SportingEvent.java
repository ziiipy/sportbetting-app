package com.epam.training.sportsbetting.domain.event;

import java.time.LocalDate;

public abstract class SportingEvent {

	protected String title;
	protected LocalDate start;
	protected LocalDate end;
	protected boolean isFinished = false;

	public SportingEvent(String title, LocalDate start, LocalDate end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		SportingEventPool.addEvent(this);
	}

	public abstract void generateRandomResults();

	public String getTitle() {
		return title;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

}
