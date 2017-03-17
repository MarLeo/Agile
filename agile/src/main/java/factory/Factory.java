package factory;

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
		if(clazz.equalsIgnoreCase("EMPLOYEE")) {
			//return new Employee(name, surname, year, month, day, sex, country);
		}
		else if(clazz.equalsIgnoreCase("PLAYER")) {
			return (T) new Player(name, surname, year, month, day, sex, country);
		}
		else if(clazz.equalsIgnoreCase("CLUB")) {
			//return (T) new Club(name, year, month, day, titres, country);
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
		if(clazz.equalsIgnoreCase("CLUB")) {
			return (T) new Club(name, year, month, day, titres, country);
		}
		return null;
	}
	
}
