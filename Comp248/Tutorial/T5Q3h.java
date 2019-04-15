
public class T5Q3h {

	public static void main(String[] args) {
		boolean sign = true;
		int sum = 0;
		int n = 0;
		while (sum < 30)
		{
			if (sign)
				sum = sum + n;
			else
				sum = sum - n;
			System.out.print(sum);
			sign = !sign;
			n = n + 10;
		}
	}

}
