package model;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import exceptions.BadAgumentsException;
import pattern.Person;

public class Employee extends Person {
	
	private String job;
	private Integer salary;
	private LocalDate start;
	private LocalDate end;
	private Integer contract_time;
	
	
	public Employee() { super(); }
	
	
	public Employee(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country, final Integer start_year, final Integer start_month, final Integer start_day, final Integer end_year, final Integer end_month, final Integer end_day, final String job, final Integer salary) throws IllegalFieldValueException, BadAgumentsException {
		super(name, surname, year, month, day, sex, country);
		start = new LocalDate(new Integer(start_year), new Integer(start_month), new Integer(start_day));
		end = new LocalDate(new Integer(end_year), new Integer(end_month), new Integer(end_day));
		contract_time = time(start, end);
		this.job = job;
		this.salary = salary;
	}
	
	
	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public Integer getContract_time() {
		return contract_time;
	}


	/*public void setContract_time(Integer contract_time) {
		this.contract_time = contract_time;
	}*/

	public Integer time(final LocalDate start, final LocalDate end) {
		return new Integer(Years.yearsBetween(start, end).getYears());
	}


	@Override
	public String toString() {
		return "Employee [job=" + job + ", salary=" + salary + ", start=" + start + ", end=" + end + ", contract_time="
				+ contract_time + Person.class.toString() +"]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
