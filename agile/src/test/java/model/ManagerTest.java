package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;



import java.util.ArrayList;
import java.util.List;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.BadAgumentsException;

public class ManagerTest {
	
	
	Manager manager1;
	Manager manager2;
	
	Player player1;
	Player player2;
	
	// dummy variables
	private String name;
	private String surname;
	private Integer year;
	private Integer _year;
	private Integer month;
	private Integer _month;
	private Integer day;
	private Integer _day;
	private char sex;
	private String country;
	
	
	
	
	
	@Before
	public void setUp() {
		name = "Emma";
		surname = "Tchokonthe";
		year = new Integer(1988);
		_year = new Integer(-1990);
		month = new Integer(10);
		_month = new Integer(0);
		day = new Integer(12);
		_day = new Integer(0);
		sex = 'F';
		country = "Cameroun";	
		
		player1 = new Player();
		// player 1 variables
		player1.setName("Charly");
		player1.setSurname("Tchokonthe");
		LocalDate birthdate = new LocalDate(new Integer(1994), new Integer(month), new Integer(day));
		player1.setBirthdate(birthdate);
		player1.setSex('M');
		player1.setCountry("Cameroun");
		
		player2 = new Player();
		// player 2 variables
		player2.setName("Willy");
		player2.setSurname("Tchokonthe");
		LocalDate _birthdate = new LocalDate(new Integer(1992), new Integer(month), new Integer(day));
		player2.setBirthdate(_birthdate);
		player2.setSex('M');
		player2.setCountry("Cameroun");
		
		// add players to manager
		manager1 = new Manager();
		
	}
	
	
	@Test
	public void managerTestSucess() {
		try {
			manager1 = new Manager(name, surname, year, month, day, sex, country);
			extracted(name, surname, year, month, day, sex, country, manager1);
		} catch (BadAgumentsException e) {
			
		}		
	}

	
	@Test
	public void managerTestFailBecauseYearIsNegativeOrNull() {
		try {
			manager2 = new Manager(name, surname, _year, month, day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException e) {
			assertThat(e.getMessage(), is("year is negative or null"));
		}		
	}
	
	
	@Test
	public void managerTestFailBecauseOfIncorrectMonth() {
		try {
			manager2 = new Manager(name, surname, year, _month, day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException | IllegalFieldValueException e) {
			assertThat(e.getMessage(), is("Value "+_month+" for monthOfYear must be in the range [1,12]"));
		}		
	}
	
	@Test
	public void managerTestFailBecauseOfIncorrectDay() {
		try {
			manager2 = new Manager(name, surname, year, month, _day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException | IllegalFieldValueException e) {
			assertThat(e.getMessage(), is("Value "+_day+" for dayOfMonth must be in the range [1,31]"));
		}		
	}
	
	
	@Test
	public void addPlayerTest() throws BadAgumentsException {
		manager1 = new Manager(name, surname, year, month, day, sex, country);
		manager1.addPlayer(player1);
		manager1.addPlayer(player2);
		List<Player> players = new ArrayList<Player>(manager1.getPlayers());
		assertThat(2, is(players.size()));
	}
	
	
	@After
	public void tearDown() {
		name = null;
		surname = null;
		year = new Integer(0);
		_year = new Integer(0);
		month = new Integer(0);
		_month = new Integer(0);
		day = new Integer(0);
		_day = new Integer(0);
		sex = ' ';
		country = null;
	}
	
	
	//=================================> private methods <=========================================
	private void extracted(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Manager manager) {
		assertThat(name, is(manager.getName()));
		assertThat(surname, is(manager.getSurname()));
		LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(manager.getAge())));
		assertThat(sex, is(manager.getSex()));
		assertThat(country, is(manager.getCountry()));
		assertThat(manager, instanceOf(Manager.class));
		assertThat(manager.toString(), hasToString(manager.toString()));
	}
	

}
