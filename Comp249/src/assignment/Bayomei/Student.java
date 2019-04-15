package assignment.Bayomei;

public class Student {
	
	private String name;
	private double gpa;
	
	Student(String name,double gpa) {
		this.name=name;
		this.gpa=gpa;	
}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String toString() {
		return String.format("%s\t%f", this.name,this.gpa);
	}
}