package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.BadAgumentsException;
import factory.Factory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joda.time.LocalDate;
import org.joda.time.Years;

public class ClubTest {
	
	Club club;
	Player player;
	Employee employee;
	Manager manager;
	
	Factory factory;
	
	
	// dummy variables
	private String name;
	private String _name;
	private Integer year;
	private Integer _year;
	private Integer month;
	private Integer _month;
	private Integer day;
	private Integer _day;
	private String country;
	private String _country;
	private Integer titres;
	private Integer _titres;
	
	private String player_name;
	private String player_surname;
	private Integer player_year;
	private Integer player_month;
	private Integer player_day;
	private char sex;
	private String player_country;
	private Integer player_salary;
	
	private String manager_name;
	private String manager_surname;
	private Integer manager_year;
	private Integer manager_month;
	private Integer manager_day;
	private char manager_sex;
	private String manager_country;
	
	
	// dummy variables
		private String employee_name;
		private String employee_surname;
		private Integer employee_year;
		private Integer employee_month;
		private Integer employee_day;
		private char employee_sex;
		private String employee_country;
		private String employee_job;
		private Integer employee_salary; 
		
		private Integer employee_start_year;
		private Integer employee_start_month;
		private Integer employee_start_day;
		
		private Integer employee_end_year;
		private Integer employee_end_month;
		private Integer employee_end_day;
	
	
	
	
	@Before
	public void setUp() {
		name = "FC Barcelone";
		_name = "Inter Milan";
		year = new Integer(1979);
		_year = new Integer(1980);
		month = new Integer(12);
		_month = new Integer(10);
		day = new Integer(30);
		_day = new Integer(12);
		country = "Spain";
		_country = "Italy";
		titres = 25;
		_titres = 12;
		
		// player value
		player_name = "Charly";
		player_surname = "Tchokonthe";
		player_year = new Integer(1994);
		player_month = new Integer(10);
		player_day = new Integer(12);
		sex = 'M';
		player_country = "Cameroun";
		player_salary = new Integer(30000);
		
		// manager value
		manager_name = "Emma";
		manager_surname = "Tchokonthe";
		manager_year = new Integer(1988);
		manager_month = new Integer(10);
		manager_day = new Integer(12);
		manager_sex = 'F';
		manager_country = "Cameroun";	
		
		// employee value
		employee_name = "Charly";
		employee_surname = "Tchokonthe";
		employee_year = new Integer(1994);
		employee_month = new Integer(10);
		employee_day = new Integer(12);
		employee_sex = 'M';
		employee_country = "Cameroun";
		employee_job = "coach";
		employee_salary = new Integer(10000);
		
		employee_start_year = new Integer(2012);
		employee_start_month = new Integer(10);
		employee_start_day = new Integer(30);
		
		employee_end_year = new Integer(2016);
		employee_end_month = new Integer(8);
		employee_end_day = new Integer(21);
		
		factory = new Factory();
		
	}
	
	
	@Test
	public void clubTestSuccess() {
		club = new Club(name, year, month, day, titres, country);
		extracted(name, year, month, day, country, titres, club);
	}
	
	@Test
	public void clubTestSettersAndGetters() {
		club = new Club(name, year, month, day, titres, country);
		club.setName(_name);
		club.setCountry(_country);
		club.setTitres(_titres);
		LocalDate birthdate = new LocalDate(new Integer(_year), new Integer(_month), new Integer(_day));
		club.setAge(club.age(birthdate, LocalDate.now()));
		extracted1(_name, _year, _month, _day, _country, _titres, club);
	}
	
	@Test
	public void clubTestEmployeesAndPlayers() throws BadAgumentsException {
		club = new Club(name, year, month, day, titres, country);
		player = new Player(player_name, player_surname, player_year, player_month, player_day, sex, country);
		manager = new Manager(manager_name, manager_surname, manager_year, manager_month, manager_day, manager_sex, manager_country);
		player.signContract(manager, player_salary, new Integer(2006), new Integer(7), new Integer(10), new Integer(2010), new Integer(7), new Integer(10), club);
		employee = (Employee) factory.instance("EMPLOYEE", employee_name, employee_surname, employee_year, employee_month, employee_day, employee_sex, employee_country, employee_start_year, employee_start_month, employee_start_day, employee_end_year, employee_end_month, employee_end_day, employee_job, employee_salary);
		club.addPlayers(player);
		//assertThat(1, is(club.totalEmployees()));
		//assertThat(30000, is(club.MaxsSalary()[0]));
		//assertThat(30000, is(club.MaxsSalary()[1]));
		club.addCollaborators(employee);
		club.addCollaborators(player);
		assertThat(2, is(club.getTotal()));
		assertThat(30000, is(club.getMaxs()[0]));
		assertThat(30000, is(club.getMaxs()[1]));
		assertThat(10000, is(club.getMaxs()[2]));
	}
	
	
	
	@After
	public void tearDown() {
		
	}
	
	//==============================================> private methods <============================================================
	private void extracted(final String name, final Integer year, final Integer month, final Integer day, final String country, final Integer titres, Club club){
		assertThat(name, is(club.getName()));
		LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(club.getAge())));
		assertThat(country, is(club.getCountry()));
		assertThat(titres, is(club.getTitres()));
	}
	
	private void extracted1(final String _name, final Integer _year, final Integer _month, final Integer _day, final String _country, final Integer _titres, Club club){
		assertThat(_name, is(club.getName()));
		LocalDate birthdate = new LocalDate(new Integer(_year), new Integer(_month), new Integer(_day));
		assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(club.getAge())));
		assertThat(_country, is(club.getCountry()));
		assertThat(_titres, is(club.getTitres()));
	}

}
