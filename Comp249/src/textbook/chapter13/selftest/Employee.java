package textbook.chapter13.selftest;

public class Employee implements Cloneable{
	private String name;
	private Date hireDate;

	public Employee() {
		name = "No name";
		hireDate = new Date("January", 1, 1000); // Just a placeholder.
	}

	public Employee(String theName, Date theDate) {
		if (theName == null || theDate == null) {
			System.out.println("Fatal error creating Employee.");
			System.exit(0);
		}
		name = theName;
		hireDate = new Date(theDate);
	}

	public Employee(Employee originalObject) {
		name = originalObject.name;
		hireDate = new Date(originalObject.hireDate);
	}

	public String getName() {
		return name;
	}

	public Date getHireDate() {
		return new Date(hireDate);
	}

	public void setName(String newName) {
		if (newName == null) {
			System.out.println("Fatal Error setting employee name.");
			System.exit(0);
		}
		name = newName;
	}

	public void setHireDate(Date newDate) {
		if (newDate == null) {
			System.out.println("Fatal Error setting employee hire " + "date.");
			System.exit(0);
		} else
			hireDate = new Date(newDate);
	}

	
	public Object clone(){
		try{
			Employee copy = (Employee) super.clone();
			copy.hireDate = (Date) hireDate.clone();
			return copy;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}


	public String toString() {
		return name + " " + hireDate.toString();
	}

	public boolean equals(Employee anotherEmployee) {
		return name.equals(anotherEmployee.name) && hireDate.equals(anotherEmployee.hireDate);
	}

	


	
}
