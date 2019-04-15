import java.util.Scanner;
public class C3P8_Code {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter a integer: ");
		int number = kb.nextInt();
		char[] code = {'*','B','E','A','@','F','K','%','R','M'};
		String numberString = String.valueOf(number);
		int length = numberString.length();
		int firstDigit = number/(int)Math.pow(10, length-1);
		int lastDigit = number % 10;
		char firstCharacter=code[firstDigit], lastCharacter=code[lastDigit];
		
		if(firstDigit%2==1 && lastDigit%2==1)
		{
			firstCharacter ='X';
			lastCharacter = 'X';
		}
		else if (firstDigit%2==0 && lastDigit%2==0)
		{
			firstCharacter ='$';
			lastCharacter = '$';
		}
		if (lastDigit==0)
			lastCharacter = '#';
		
		System.out.print(firstCharacter);
		number = number - firstDigit * (int)Math.pow(10, length-1);
		int i,digit; 
		for(i=0; i<length-2; i++)
		{
			digit = number / (int)Math.pow(10, length-2-i);
			System.out.print(code[digit]);
			number = number - digit * (int)Math.pow(10, length-2-i);
		}
		System.out.print(lastCharacter);
		
		kb.close();	
	}

}
