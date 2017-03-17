package factory;

import org.joda.time.IllegalFieldValueException;

import exceptions.BadAgumentsException;
import model.Bank;
import model.Club;
import model.Employee;
import model.Manager;
import model.Player;

public class Factory<T> {
	
	
	@SuppressWarnings("unchecked")
	public T instance(String clazz, String name, String surname, Integer year, Integer month, Integer day, char sex, String country) throws BadAgumentsException {
		if(clazz == null){
			return null;
		}
		else if(clazz.equalsIgnoreCase("PLAYER")) {
			return (T) new Player(name, surname, year, month, day, sex, country);
		}
		else if(clazz.equalsIgnoreCase("BANK")) {
			return (T) new Bank(name, year, month, day, country);
		}
		else if(clazz.equals("MANAGER")) {
			return (T) new Manager(name, surname, year, month, day, sex, country);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public T instance(String clazz, String name, Integer year, Integer month, Integer day, String country, Integer titres) throws BadAgumentsException {
		if(clazz == null){
			return null;
		}
		else if(clazz.equalsIgnoreCase("CLUB")) {
			return (T) new Club(name, year, month, day, titres, country);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T instance(String clazz, final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final String job, final Integer salary) throws IllegalFieldValueException, BadAgumentsException {
		if(clazz == null) {
			return null;
		}
		else if(clazz.equalsIgnoreCase("EMPLOYEE")) {
			return (T) new Employee(name, surname, year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
		}
		return null;
	}
	
	public T instance(String clazz, final String name, final Integer year, final Integer month, final Integer day, final String country) {
		if(clazz == null) {
			return null;
		}
		else if(clazz.equalsIgnoreCase("BANK")) {
			return (T) new Bank(name, year, month, day, country);
		}
		return null;
	}
	
	
}
