
public class T6Q8B {

	public static void main(String[] args) {
		
		int[] data = {1,3,5,8,11,15};
		int sum = 0;
		for(int i = 1; i < data.length; ++i)
		{
			sum = sum + data[i] - data[i-1];
			System.out.println("sum = " + sum);
		}
	}
}
