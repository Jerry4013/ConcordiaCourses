
public class T6Q1 {

	public static void main(String[] args) {
		for (int i = 1;i < 9;i++)
		{
		if (i%2 == 0) 
			System.out.println( i + 1);
		else if (i%3 == 0) 
			continue;
		else if (i%5 == 0) 
			break; 
		else System.out.println( "Not multiple of 2, 3 or 5."); 
		}
		System.out.println ("End");
		
		for (int j = 0; j <= 2; j++) //outer loop
		{
			System.out.print(j);
			for (char ch = 'A'; ch <= 'M'; ch+= (3+j)) //inner loop
				System.out.print((char)(ch + 1));
			System.out.println();
		}
	}

}
