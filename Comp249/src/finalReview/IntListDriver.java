package finalReview;

public class IntListDriver {

	public static void main(String[] args) {
		IntList l1= new IntList();
		l1.addToStart(5);
		l1.addToStart(4);
		l1.addToStart(8);
		l1.addToStart(8);
		l1.addToStart(6);
		l1.addToStart(8);
		l1.addToStart(4);
		l1.addToStart(8);
		l1.outputList();
		l1.swap(6, 4);
		System.out.println();
		l1.outputList();
		l1.removeAll(8);
		System.out.println();
		l1.outputList();
	}

}
