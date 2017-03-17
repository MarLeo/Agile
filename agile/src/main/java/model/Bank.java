package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import pattern.PersonAdapter;

public class Bank implements PersonAdapter{
	
	private String name;
	private LocalDate birthdate;
	private Integer age;
	private String origin_country;
	private List<Object> clients;
	
	

	public Bank(final String name, final Integer year, final Integer month, final Integer day, final String country) {
		this.name = name;
		birthdate = new LocalDate(year, month, day);
		age = age(birthdate, LocalDate.now());
		this.origin_country = country;
		clients = new ArrayList<>();
	}
	
	
	public void addClient(Object client) {
		if (client.getClass() == Player.class || client.getClass() == Club.class || client instanceof Employee || client instanceof Manager)
			clients.add(client);
	}
	
	public List<Object> getClients() {
		return clients;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrigin_country() {
		return origin_country;
	}


	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}


	@Override
	public int age(LocalDate birthdate, LocalDate now) {
		return Years.yearsBetween(birthdate, now).getYears();
	}


	public Integer getAge() {
		return age;
	}
	
	

}
