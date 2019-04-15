
public class C6P3_StudentDemo {

	public static void main(String[] args) {
		int[] marks = {10, -15, 25, 102, 30};
		C6P3_Student student1 = new C6P3_Student("Mike", "4101685", marks);
		System.out.println("Before check: ");
		System.out.println(student1);
		student1.validateMarks();
		System.out.println("After check: ");
		System.out.println(student1);
	}

}
