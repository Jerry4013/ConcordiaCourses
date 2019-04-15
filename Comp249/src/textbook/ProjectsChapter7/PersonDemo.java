package textbook.ProjectsChapter7;

public class PersonDemo {

	public static void main(String[] args) {
		Student s1 = new Student("Jerry", "Zhang", 40049474, "COMP249", "Hanna");
		Student s2 = new Student("asdowi", "asdihf", 465160, "sdihfr", "asdufgi");
		Teacher t1 = new Teacher("teacher1", "ksuehf", "asdf", 56413.4);
		s1.displayDetails();
		s2.displayDetails();
		t1.displayDetails();
	}

}
