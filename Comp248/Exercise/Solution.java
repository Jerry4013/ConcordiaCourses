
public class Solution {
	public static int reverse(int x) {
		int newX = 0;
		if (x>=0)
		{
			int digitsNumber = String.valueOf(x).length();
			int[] digits = new int[digitsNumber];
			int power = digitsNumber;
			for(int i=0; i<digitsNumber; i++)
			{
				digits[i] = x % 10;
				x /= 10; 
				newX += (int) (digits[i] * Math.pow(10, power-1));
				if (power!=0 && newX==2147483647)
					return 0;
				power--;
			}
			return newX;
		}
		else
		{
			if(x == -2147483648)
				return 0;
			else
			{
				int y = x * (-1);
				int digitsNumber = String.valueOf(y).length();
				int[] digits = new int[digitsNumber];
				int power = digitsNumber;
				for(int i=0; i<digitsNumber; i++)
				{
					digits[i] = y % 10;
					y /= 10; 
					newX += (int) (digits[i] * Math.pow(10, power-1));
					if (power!=0 && newX==2147483647)
						return 0;
					power--;
				}
				return newX * (-1);
			}
		}
	}

	public static void main(String[] args){
		int x = 1563847412;
		System.out.println(reverse(x));
	}
}


