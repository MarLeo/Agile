package service;

import org.joda.time.LocalDate;
//import org.joda.time.Period;
import org.joda.time.Years;

import pattern.PersonStrategy;

public class PersonStrategyImplement implements PersonStrategy {

	@Override
	public int Age(LocalDate birthdate, LocalDate now) {
		
		//return Period.fieldDifference(birthdate, now).getYears();
		return Years.yearsBetween(birthdate, now).getYears();
	}

}
