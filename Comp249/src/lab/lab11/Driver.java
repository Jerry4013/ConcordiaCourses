package lab.lab11;

import java.util.ArrayList;

public class Driver {

	private static int index;
	public static void main(String[] args) {
		SerialObject<Long, String> course1 = new SerialObject<>(new Long(1111111249L), "Comp249");
		SerialObject<Long, String> course2 = new SerialObject<>(new Long(1111111248L), "Comp248");
		SerialObject<Long, String> course3 = new SerialObject<>(new Long(1111111233L), "Comp233");
		SerialObject<Long, String> course4 = new SerialObject<>(new Long(1111112213L), "Engr213");
		ArrayList<SerialObject<Long, String>> obj = new ArrayList<>(10);
		obj.add(course1);
		obj.add(course2);
		obj.add(course3);
		for(SerialObject<Long, String> element: obj){
			System.out.println(element);
		}
		System.out.println("End of Iteration\n");
		
		System.out.println(course4);		
		if(search(new Long(1111111233L), obj))
			System.out.println(obj.get(index).getObj());
		else
			System.out.println("the course requested was not taken this semester");
		
		if(search(new Long(1111112213L), obj))
			System.out.println(obj.get(index).getObj());
		else
			System.out.println("the course requested was not taken this semester");
	}
	
	@SuppressWarnings("hiding")
	public static <Long, T> boolean search(Long serialNum, ArrayList<SerialObject<Long, T>> arr){
		for(SerialObject<Long, T> element: arr){
			if(element.getSerialnumber().equals(serialNum)){
				index = arr.indexOf(element);
				return true;
			}
		}
		return false;
	}
	
	

}
