package driver;

import exceptions.BadAgumentsException;
import factory.Factory;
import model.Bank;
import model.Club;
import model.Manager;
import model.Player;

public class Driver {

	public static void main(String[] args) throws BadAgumentsException {
		
		Factory factory = new Factory();
		
		// instantiate players
		Player charly = (Player) factory.instance("Player", "Charly", "Tchokonthe", new Integer(1996), new Integer(10), new Integer(12), 'M', "Cameroun");
		Player willy = (Player) factory.instance("PLAYER", "Charly", "Tchokonthe", new Integer(1992), new Integer(10), new Integer(12), 'M', "Cameroun");
		
		// instantiate club
		Club barcelone =  (Club) factory.instance("CLUB", "FC Barcelone",new Integer(1979), new Integer(12), new Integer(30), "SPAIN", 50);
		Club inter = (Club) factory.instance("CLUB", "INTER Milan", new Integer(1980), new Integer(12), new Integer(30), "Italy", 18);
		
		// instantiate manager
		Manager emma = (Manager) factory.instance("MANAGER", "Emma", "Tchokonthe", new Integer(1989), new Integer(10), new Integer(12), 'F', "Cameroun");
		
		// Instantiate Bank
		Bank bnp = (Bank) factory.instance("CLUB", "BNP Paribas", new Integer(1979), new Integer(12), new Integer(30), "France");
		
		
		// players sign contracts
		charly.signContract(emma, 300000, new Integer(2006), new Integer(7), new Integer(10), new Integer(2010), new Integer(7), new Integer(10), barcelone);
		willy.signContract(emma, 700000, new Integer(2006), new Integer(7), new Integer(10), new Integer(2010), new Integer(7), new Integer(10), barcelone);
		
		
		// add list of players for a manager
		emma.addPlayer(willy);
		emma.addPlayer(charly);
		System.out.println("average age of players of manager :" + emma.getName() + " : " + emma.averagePlayerAge(emma.getPlayers()));
		System.out.println("average salary of players of manager :" + emma.getName() + " : " + emma.averagePlayerSalary(emma.getPlayers()));
		
		// add list of players for a club
		barcelone.addCollaborators(willy);
		barcelone.addCollaborators(charly);
		System.out.println("Total players: " + barcelone.getTotal());
		//System.out.println("Max salary:" + barcelone.getMaxs()[0]);
		
		
	}
}
