package textbook.ProjectsChapter7;

public class Student extends Person{
	private int ID;
	private String course;
	private String teacher;
	
	public Student(){}
	public Student(String first, String last, int theID, String theCourse, String theTeacher){
		super(first, last);
		ID = theID;
		course = theCourse;
		teacher = theTeacher;
	}
	
	public Student(Student anotherStudent){
		super(anotherStudent);
		ID = anotherStudent.ID;
		course = anotherStudent.course;
		teacher = anotherStudent.teacher;
	}
	
	public void displayDetails(){
		super.displayDetails();
		System.out.println("ID: " + ID + "\tCourse: " + course + "\tTeacher: " + teacher);
	}
	
}
