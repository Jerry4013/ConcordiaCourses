package textbook.ProjectsChapter7;

public class Person {
	private String firstName;
	private String lastName;
	
	public Person(){}
	
	public Person(String first, String last){
		firstName= first;
		lastName = last;
	}
	
	public Person(Person anotherPerson){
		firstName = anotherPerson.firstName;
		lastName = anotherPerson.lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setFirst(String newFirst){
		firstName = newFirst;
	}
	
	public void setLast(String newLast){
		lastName = newLast;
	}
	
	public void displayDetails(){
		System.out.println("First Name: " + firstName + "\tLast Name: " + lastName);
	}
}
