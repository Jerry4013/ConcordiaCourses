package textbook.ProjectsChapter7;

public class Teacher extends Person{
	private String subject;
	private double salary;
	
	public Teacher(){}
	public Teacher(String first, String last, String subject, double salary){
		super(first,last);
		this.subject = subject;
		this.salary = salary;
	}
	
	public Teacher(Teacher anotherTeacher){
		super(anotherTeacher);
		subject = anotherTeacher.subject;
		salary = anotherTeacher.salary;
	}
	
	public void displayDetails(){
		super.displayDetails();
		System.out.println("Subject: " + subject + "\tSalary: " + salary);
	}
}
