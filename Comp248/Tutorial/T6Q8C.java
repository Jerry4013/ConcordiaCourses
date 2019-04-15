
public class T6Q8C {

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7};
		boolean[] filter = {true, false, true, true, false, true, true};
		int sum = 0;
		for (int i = 0; i < data.length; ++i)
			if (filter[i])
				sum = sum + data[i];
		System.out.println("data:" + sum);
		
		for(int i = 0; i < filter.length; ++i)
			filter[i] = !filter[i];
		sum =0;
	
		for (int i = 0; i < data.length; ++i)
			if (filter[i])
				sum = sum + data[i];
		System.out.println("data:" + sum);
	}

}
