package com.epam.training.sportsbetting.domain.betting;

import java.time.LocalDate;

public class Odd {

	private float value;
	private LocalDate validityStart;
	private LocalDate validityEnd;

	public Odd(float value, LocalDate validityStart, LocalDate validityEnd) {
		super();
		this.value = value;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
	}
	
	public Odd copy() {
		return new Odd(value, validityStart, validityEnd);
	}

	public float getValue() {
		return value;
	}

	public LocalDate getValidityStart() {
		return validityStart;
	}

	public LocalDate getValidityEnd() {
		return validityEnd;
	}

}
