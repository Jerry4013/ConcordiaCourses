package textbook.chapter14.selfTestExercise;

import java.util.ArrayList;

public class StringSelectionSort {

	public static void sort(ArrayList<String> b){
		
		for(int i=0; i<b.size(); i++){
			for(int j=i+1; j<b.size(); j++){
				String min = b.get(i);
				if(b.get(j).compareTo(min)<0){
					String temp;
					temp = min;
					min = b.get(j);
					b.set(j, temp);
					b.set(i, min);
				}
			}
		}
//		b.sort(null);
	}
	
	public static void main(String[] args) {
		ArrayList<String> b = new ArrayList<String>();
		b.add("time");
		b.add("tide");
		b.add("clouds");
		b.add("rain");
		b.add("aesf");
		b.add("xkls");
		System.out.println("ArrayList values before sorting:");
		for (String e : b)
			System.out.print(e + " ");
		System.out.println();
		StringSelectionSort.sort(b);
		System.out.println("ArrayList values after sorting:");
		for (String e : b)
			System.out.print(e + " ");
		System.out.println();
	}

}
