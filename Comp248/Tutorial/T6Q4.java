
public class T6Q4 {

	public static void main(String[] args) {
		int prevprev = 2;
		int prev = 2;
		int sum = 0;
		for (int i = 1; i < 4; ++i)
		{
		sum = prevprev + prev;
		System.out.println(prevprev + " " + prev + " " + sum);
		prevprev = prev;
		prev = sum;
		}
	}

}
