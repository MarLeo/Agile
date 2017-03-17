package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.Before;
import org.junit.Test;

import exceptions.BadAgumentsException;

public class BankTest {
	
	Bank bank;
	Player player;
	Manager manager;
	Club club;
	
	// dummy variables
	private String name;
	private Integer year;
	private Integer month;
	private Integer day;
	private String origin_country;
	
	// player
	private String player_name;
	private String player_surname;
	private Integer player_year;
	private Integer player_month;
	private Integer player_day;
	private char sex;
	private String player_country;
	private Integer player_salary;
	
	// manager
	private String manager_name;
	private String manager_surname;
	private Integer manager_year;
	private Integer manager_month;
	private Integer manager_day;
	private char manager_sex;
	private String manager_country;
	
	
	@Before
	public void setUp() {
		name = "BNP Paribas";
		year = new Integer(1979);
		month = new Integer(12);
		day = new Integer(30);
		origin_country = "France";
		
		// player value
		player_name = "Charly";
		player_surname = "Tchokonthe";
		player_year = new Integer(1994);
		player_month = new Integer(10);
		player_day = new Integer(12);
		sex = 'M';
		player_country = "Cameroun";
		
		// manager value
				manager_name = "Emma";
				manager_surname = "Tchokonthe";
				manager_year = new Integer(1988);
				manager_month = new Integer(10);
				manager_day = new Integer(12);
				manager_sex = 'F';
				manager_country = "Cameroun";	
	}
	
	
	@Test
	public void bankTestConstructor() {
		bank = new Bank(name, year, month, day, origin_country);
		extracted(name, year, month, day, origin_country, bank);
	}
	
	@Test
	public void bankTestClients() throws BadAgumentsException {
		bank = new Bank(name, year, month, day, origin_country);
		player = new Player(player_name, player_surname, player_year, player_month, player_day, sex, player_country);
		manager = new Manager(manager_name, manager_surname, manager_year, manager_month, manager_day, manager_sex, manager_country);
		bank.addClient(player);
		bank.addClient(manager);
		assertThat(2, is(bank.getClients().size()));
	}
	
	
	// ===========================================> Private Methods <============================================================
	private void extracted(final String name, final Integer year, final Integer month, final Integer day, final String country, Bank bank){
		assertThat(name, is(bank.getName()));
		LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(bank.getAge())));
		assertThat(country, is(bank.getOrigin_country()));
	}
	

}
