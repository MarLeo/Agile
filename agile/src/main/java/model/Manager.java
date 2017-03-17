package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.BadAgumentsException;
import pattern.Person;
import pattern.Adapter;

public class Manager extends Person {

	List<Player> players;
	
	public Manager(){ super();}
	
	public Manager(String name, String surname, Integer year, Integer month, Integer day, char sex, String country) throws BadAgumentsException {
		super(name, surname, year, month, day, sex, country);
		players = new ArrayList<Player>();
	}
	
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public int averagePlayerSalary(List<Player> players) {
		int avg = 0;
		for (Player player : players) {
			avg += player.getSalary()/players.size();
		}
		return avg;
	}
	
	public int averagePlayerAge(List<Player> players) {
		int avg = 0;
		for (Player player : players) {
			avg += player.getAge()/players.size();
		}
		return avg;
	}

}
