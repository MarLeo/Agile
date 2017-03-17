package driver;

import exceptions.BadAgumentsException;
import factory.Factory;
import model.Club;
import model.Player;

public class Driver {

	public static void main(String[] args) throws BadAgumentsException {
		
		Factory factory = new Factory();
		
		// instantiate players
		Player charly = (Player) factory.instance("Player", "Charly", "Tchokonthe", new Integer(1996), new Integer(10), new Integer(12), 'M', "Cameroun");
		Player willy = (Player) factory.instance("PLAYER", "Charly", "Tchokonthe", new Integer(1992), new Integer(10), new Integer(12), 'M', "Cameroun");
		
		// instantiate club
		Club barcelone =  (Club) factory.instance("CLUB", "FC Barcelone",new Integer(1979), new Integer(12), new Integer(30), "SPAIN", 50);
		System.out.println(barcelone.getCountry());
		
		
	}
}
