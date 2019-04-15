package tutorial.tutorial7;

import java.io.Serializable;

class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	int ID;
	String position;
	/**
	 * @param name
	 * @param iD
	 * @param position
	 */
	public Employee(String name, int iD, String position) {
		super();
		this.name = name;
		ID = iD;
		this.position = position;
	}
	
	public String toString(){
		return "Name: " + name + ", ID: " + ID + ", Position: " + position; 
	}
}
public class Q3 {

	private static final int NUM_EMPLOYEE=20;
	public static void main(String[] args) {
		String[] positions = {"Mana", "test", "SE", "DA"};
		Employee[] employees = new Employee[NUM_EMPLOYEE];
		for(int i=0; i<employees.length; i++){
			employees[i] = new Employee("Person" + i, i+100, positions[i%4]);
		}
		
	}
	public static void outputEmployee(){
		
	}

}
