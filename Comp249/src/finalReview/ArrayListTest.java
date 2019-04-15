package finalReview;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<>();
		
		l1.add(3);
		l1.add(5);
		l1.add(8);
		l1.set(2, 9);
		l1.add(6);
		l1.add(4);
		l1.add(7);
		System.out.println(l1);
		
		for(int i=l1.size()-1; i>=0; i--){
			System.out.println(l1.get(i));
		}
		
	}
}
