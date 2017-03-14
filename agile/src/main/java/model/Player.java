package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import exceptions.BadAgumentsException;
import pattern.Person;


public class Player extends Person {
	
	private Integer salary;
	private List<Player> contracts;
	private Manager manager;
	private Club club;
	private LocalDate start;
	private LocalDate end;
	private int contract_time;
	
	
	public Player() { super();}
	
	public Player(String name, String surname, Integer year, Integer month, Integer day, char sex, String country) throws BadAgumentsException {
		super(name, surname, year, month, day, sex, country);
		contracts = new ArrayList<Player>();
	}
	
	
	public void signContract(final Manager manager, final Integer salary, final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final Club club) {
		this.manager = manager;
		this.salary = salary;
		this.club = club;
		start = new LocalDate(new Integer(start_year), new Integer(start_month), new Integer(start_day));
		end = new LocalDate(new Integer(end_year), new Integer(end_month), new Integer(end_day));
		contract_time = time(start, end);
		contracts.add(this);
	}

	
	public Integer time(final LocalDate start, final LocalDate end) {
		return new Integer(Years.yearsBetween(start, end).getYears());
	}
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public int getContract_time() {
		return contract_time;
	}

	public List<Player> getContracts() {
		return contracts;
	}
	

}
