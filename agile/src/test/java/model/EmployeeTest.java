package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import exceptions.BadAgumentsException;

public class EmployeeTest {
	
	private Employee employee1;
	private Employee employee2;
	
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
	private String job;
	private String _job;
	private Integer salary; 
	private Integer _salary;
	
	
	private Integer start_year;
	private Integer start_month;
	private Integer start_day;
	
	private Integer end_year;
	private Integer end_month;
	private Integer end_day;
	
	
	@Before
	public void setUp() {
		name = "Charly";
		surname = "Tchokonthe";
		year = new Integer(1994);
		_year = new Integer(-1994);
		month = new Integer(10);
		_month = new Integer(0);
		day = new Integer(12);
		_day = new Integer(0);
		sex = 'M';
		country = "Cameroun";
		job = "coach";
		_job = "gardener";
		salary = new Integer(10000);
		_salary = new Integer(2500);
		
		start_year = new Integer(2012);
		start_month = new Integer(10);
		start_day = new Integer(30);
		
		end_year = new Integer(2016);
		end_month = new Integer(8);
		end_day = new Integer(21);
		
	}
	
	@Test
	public void employeeTestNull() throws IllegalFieldValueException, BadAgumentsException {
		employee1 = new Employee();
		assertThat(employee1.getJob(), is(equalTo(null)));
	}
	
	@Test
	public void employeeTestSuccess() throws IllegalFieldValueException, BadAgumentsException {
		employee1 = new Employee(name, surname, year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
		extracted(name, surname, year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary, employee1);
	}
	
	
	@Test
	public void employeeTestSuccessSetters() throws IllegalFieldValueException, BadAgumentsException{
		employee1 = new Employee(name, surname, year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
		employee1.setJob(_job);
		employee1.setSalary(_salary);
		extracted1(name, surname, year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, _job, _salary, employee1);
	}
	
	@Test
	public void employeeTestFailBecauseYearIsNegativeOrNull() {
		try {
			employee1 = new Employee(name, surname, _year, month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
			fail("Expected Exception");
		} catch (BadAgumentsException e) {
			assertThat(e.getMessage(), is("year is negative or null"));
		}
	}
	
	@Test(expected=IllegalFieldValueException.class)
	public void employeeTestFailBecauseOfIncorrectMonth() throws IllegalFieldValueException, BadAgumentsException{
		employee1 = new Employee(name, surname, year, _month, day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
	}
	
	@Test(expected=IllegalFieldValueException.class)
	public void employeeFailBecauseOfIncorrectDay() throws IllegalFieldValueException, BadAgumentsException{
		employee1 = new Employee(name, surname, year, month, _day, sex, country, start_year, start_month, start_day, end_year, end_month, end_day, job, salary);
	}
	
	//===========================================================> private methods <=========================================================================
		private void extracted(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final String job, final Integer salary, final Employee employee) {
			assertThat(name, is(employee.getName()));
			assertThat(surname, is(employee.getSurname()));
			LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
			LocalDate start = new LocalDate(new Integer(start_year), new Integer(start_month), new Integer(start_day));
			LocalDate end = new LocalDate(new Integer(end_year), new Integer(end_month), new Integer(end_day));
			assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(employee.getAge())));
			assertThat(Years.yearsBetween(start, end).getYears(), is(equalTo(employee.getContract_time())));
			assertThat(sex, is(employee.getSex()));
			assertThat(country, is(employee.getCountry()));
			assertThat(job, is(employee.getJob()));
			assertThat(salary, is(employee.getSalary()));
			assertThat(employee, instanceOf(Employee.class));
			assertThat(employee.toString(), hasToString(employee.toString()));
		}

		private void extracted1(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final String _job, final Integer _salary, final Employee employee) {
			assertThat(name, is(employee.getName()));
			assertThat(surname, is(employee.getSurname()));
			LocalDate birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
			LocalDate start = new LocalDate(new Integer(start_year), new Integer(start_month), new Integer(start_day));
			LocalDate end = new LocalDate(new Integer(end_year), new Integer(end_month), new Integer(end_day));
			assertThat(Years.yearsBetween(birthdate, LocalDate.now()).getYears(), is(equalTo(employee.getAge())));
			assertThat(Years.yearsBetween(start, end).getYears(), is(equalTo(employee.getContract_time())));
			assertThat(sex, is(employee.getSex()));
			assertThat(country, is(employee.getCountry()));
			assertThat(_job, is(employee.getJob()));
			assertThat(_salary, is(employee.getSalary()));
			assertThat(employee, instanceOf(Employee.class));
			assertThat(employee.toString(), hasToString(employee.toString()));
		}

}
