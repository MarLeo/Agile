package pattern;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import exceptions.BadAgumentsException;

public  class Person implements PersonAdapter {
	private String name;
	private String surname;
	LocalDate birthdate;
	private char sex;
	private String country;
	private Integer age;
	
	private PersonStrategy personStrategy;
	private PlayerStrategy playerStrategy;
	private ManagerStrategy managerStrategy;
	
	private PersonAdapter personAdapter;
	
	
	public Person() {}
	
	public Person(final PersonStrategy personStrategy, final PlayerStrategy playerStrategy, final ManagerStrategy managerStrategy){
		this.personStrategy = personStrategy;
		this.playerStrategy = playerStrategy;
		this.managerStrategy = managerStrategy;
	}
	
	public Person(final PersonAdapter personAdapter) {
		this.personAdapter = personAdapter;
	}
	
	public Person(final String name, final String surname, final Integer year, final Integer month, final Integer day, final char sex, final String country) throws BadAgumentsException, IllegalFieldValueException {
		if(year <= 0 ) throw new BadAgumentsException("year is negative or null");
		else if (12 <= month && month <=0) throw new IllegalFieldValueException("", ""); 
		else if(31 <= day && day <= 0) throw new IllegalFieldValueException("", ""); 
		else {
		this.name = name;
		this.surname = surname;
		this.birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		this.sex = sex;
		this.country = country;	
		this.age = age(birthdate, LocalDate.now());
		} 		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) {
		this.sex = sex;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int age(LocalDate birthdate, LocalDate now) {
		
		//return Period.fieldDifference(birthdate, now).getYears();
		return Years.yearsBetween(birthdate, now).getYears();
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", sex=" + sex
				+ ", country=" + country + ", age=" + age + "]";
	}

}
