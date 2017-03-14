package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.BadAgumentsException;
import pattern.Person;
import pattern.PersonAdapter;

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

}
