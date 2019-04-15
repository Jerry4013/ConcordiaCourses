package textbook.chapter13.programmingProjects;

public class Q1_Test {

	public static void main(String[] args) {
		Double[] a = {1.25, 5.1, 6.4, 9.1, 10.3, 67.1};
		int result = Q1_ModifiedBinarySearch.search(a, 0, 5, 10.3);
		System.out.println(result);
		
		String[] s = {"a", "b", "c", "m"};
		result = Q1_ModifiedBinarySearch.search(s, 0, 3, "c");
		System.out.println(result);
	}

}
