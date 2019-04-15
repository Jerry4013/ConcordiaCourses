
public class C4P4_JournalDemo {

	public static void main(String[] args) {
		C4P8_Date date = new C4P8_Date(11, 6, 2011);
		C4P4_Journal paper = new C4P4_Journal("Kenneth H. Rosen", "Discrete mathematics and its applications", date);
		paper.displayDetails();
		System.out.println(paper.getSubmissionDetails());
	}

}
