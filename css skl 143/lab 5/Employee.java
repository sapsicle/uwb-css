/*
 * Employee.java - Abstract
 * This is the superclass of all workers in this company
 *   All employees must have a name and social security number. 
 */

//notice the abstract keyword? That prevents us from making objects of this type!
public abstract class Employee {
	private String name;
	private int social;
	
	public Employee() {

	}
	
	public Employee(String newName, int newSocial) {
		name = newName;
		social = newSocial;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	
	public abstract double calculateWeeklyPay();
	
}

/* Question answers
 * 
 * calculateWeeklyPay is polymorphic as it has multiple different implementations in each subclass
 * 
 * getRandEmp would randomize a number and use switch cases to generate a default no-args employee subclass object depending on which number it rolled
 * 
 * Employee emp;
 * switch (getRandInt()) {
 *      case 0: emp = new HourlyEmployee();
 *          break;
 *      case 1: emp = new SalariedEmployee();
 *          break;
 * etc....
 * }
 */