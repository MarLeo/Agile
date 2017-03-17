package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import pattern.PersonAdapter;

public class Club implements PersonAdapter {

	private String name;
	private LocalDate birthdate;
	private Integer titres;
	private Integer age;
	private String country;
	private List<Employee> employees;
	private List<Player> players;
	private List<Object> employees_list;
	
	
	public Club(final String name, final Integer year, final Integer month, final Integer day, final Integer titres, final String country) {
		this.name = name;
		this.birthdate = new LocalDate(new Integer(year), new Integer(month), new Integer(day));
		this.titres = titres;
		this.age = age(birthdate, LocalDate.now());
		this.country = country;
		employees = new ArrayList<>();
		players = new ArrayList<>();
		employees_list = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void addPlayers(Player player) {
		players.add(player);
	}
	
	public void addCollaborators(Object employee) {
		if(employee instanceof Player || employee instanceof Employee) {
			employees_list.add(employee);
		}
	}
	
	public int getTotal() {
		return employees_list.size();
	}
	
	public int[] getMaxs(){
		int max_employee = Integer.MIN_VALUE;
		Integer max_player = Integer.MIN_VALUE;
		int max = 0;
		int[] maxs = new int[3];
		for(Object emp : employees_list) {
			if(emp instanceof Employee) {
			if(((Employee) emp).getSalary() > max_employee) {
				max_employee = ((Employee) emp).getSalary();
			}
		}
		}
		for(Object player : players) {
			if(player instanceof Player) {
			if(((Player) player).getSalary() > max_player) {
				max_player = ((Player) player).getSalary();
			}
		  }
		}
		
		max = (max_employee > max_player) ? max_employee : max_player;
		
		maxs[0] = max;
		maxs[1] = max_player;
		maxs[2] = max_employee;
		
		return maxs;
	}
	
	public int totalEmployees() {
		return employees.size() + players.size();
	}
	
	

	public int[] MaxsSalary() {
		int max_employee = Integer.MIN_VALUE;
		Integer max_player = Integer.MIN_VALUE;
		int max = 0;
		int[] maxs = new int[3];
		for(Employee emp : employees) {
			if(emp.getSalary() > max_employee) {
				max_employee = emp.getSalary();
			}
		}
		
		for(Player p : players) {
			if(p.getSalary() > max_player) {
				max_player = p.getSalary();
			}
		}
		
		max = (max_employee > max_player) ? max_employee : max_player;
		
		maxs[0] = max;
		maxs[1] = max_player;
		maxs[2] = max_employee;
		
		return maxs;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getTitres() {
		return titres;
	}



	public void setTitres(Integer titres) {
		this.titres = titres;
	}

	


	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}

	


	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public int age(LocalDate birthdate, LocalDate now) {
		return Years.yearsBetween(birthdate, now).getYears();
	}



	@Override
	public String toString() {
		return "Club [name=" + name + ", titres=" + titres + ", age=" + age + ", country=" + country + "]";
	}
		
}

	