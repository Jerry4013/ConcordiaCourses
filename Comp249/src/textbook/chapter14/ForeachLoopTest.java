package textbook.chapter14;

import java.util.ArrayList;

public class ForeachLoopTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(20);
		for(int i=0; i<20; i++){
			list.add(i);
		}
		
		for(Integer element: list){
			System.out.println(element);
		}
		
		ArrayList<Double> numberList = new ArrayList<>();
		for(Double element: numberList){
			System.out.println(element);
		}
		
	}

}
