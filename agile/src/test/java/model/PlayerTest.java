package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import exceptions.BadAgumentsException;


public class PlayerTest {
	
	Player player1;
	Player player2;
	
	Manager manager;
	Club club;
	
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
	private Integer salary;
	private Integer _salary;
	
	
	
	@Before
	public void setUp() {
		name = "Charly";
		surname = "Tchokonthe";
		year = new Integer(1994);
		_year = new Integer(-1990);
		month = new Integer(10);
		_month = new Integer(0);
		day = new Integer(12);
		_day = new Integer(0);
		sex = 'M';
		country = "Cameroun";
		salary = new Integer(30000);
		_salary = new Integer(40000);
	}
	
	
	@Test
	public void playerTestSucess() {
		try {
			player1 = new Player(name, surname, year, month, day, sex, country);
			extracted(name, surname, year, month, day, sex, country, player1);
		} catch (BadAgumentsException e) {
			
		}		
	}

	@Test
	public void playerTestContract() {
		try {
			player1 = new Player(name, surname, year, month, day, sex, country);
			manager = new Manager(name, surname, year, month, day, sex, country);
			club = new Club("FC Barcelona", new Integer(1979), new Integer(10), new Integer(20), new Integer(30), "Spain");
			player1.signContract(manager, salary, new Integer(2006), new Integer(7), new Integer(10), new Integer(2010), new Integer(7), new Integer(10), club);
			extracted(name, surname, year, month, day, sex, country, player1);
			extracted1(2006, 7, 10, 2010, 7, 10, salary, player1);
			player1.setSalary(_salary);
			assertThat(_salary, is(player1.getSalary()));
			assertThat(1, is(player1.getContracts().size()));
		} catch (BadAgumentsException e) {
			
		}		
	}
	
	
	@Test
	public void playerTestFailBecauseYearIsNegativeOrNull() {
		try {		
			player2 = new Player(name, surname, _year, month, day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException e) {
			assertThat(e.getMessage(), is("year is negative or null"));
		}		
	}
	
	
	@Test
	public void playerTestFailBecauseOfIncorrectMonth() {
		try {
			player2 = new Player(name, surname, year, _month, day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException | IllegalFieldValueException e) {
			assertThat(e.getMessage(), is("Value "+_month+" for monthOfYear must be in the range [1,12]"));
		}		
	}
	
	@Test
	public void playerTestFailBecauseOfIncorrectDay() {
		try {
			player2 = new Player(name, surname, year, month, _day, sex, country);
			fail("Expected exception");
		} catch (BadAgumentsException | IllegalFieldValueException e) {
			assertThat(e.getMessage(), is("Value "+_day+" for dayOfMonth must be in the range [1,31]"));
		}		
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
	
	
	//===========================================================> private methods <=========================================================================
	private void extracted(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Player player) {
		assertThat(name, is(player.getName()));
		assertThat(surname, is(player.getSurname()));
		LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(player.getAge())));
		assertThat(sex, is(player.getSex()));
		assertThat(country, is(player.getCountry()));
		assertThat(player, instanceOf(Player.class));
		assertThat(player.toString(), hasToString(player.toString()));
	}
	
	
	private void extracted1(final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final Integer salary, final Player player) {
		LocalDate start = new LocalDate(new Integer(start_year), new Integer(start_month), new Integer(start_day));
		LocalDate end = new LocalDate(new Integer(end_year), new Integer(end_month), new Integer(end_day));
		assertThat(Years.yearsBetween(start, end).getYears(), is(equalTo(player1.getContract_time())));
		assertThat(salary, is(player1.getSalary()));
		assertThat(player1, instanceOf(Player.class));
		assertThat(player1.toString(), hasToString(player1.toString()));
	}

}
