import java.util.Scanner;
public class T6Q7 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int iResult=0, num1 = 25, num2 = 40, num4 = 5;
		double fResult=0, val1 = 17.0;
		
		System.out.println("Which answer do you want? ");
		String answer = kb.next();
		switch(answer)
		{
			case "A":
				fResult = (double) num1 / num2;
				break;
			case "B":
				fResult = num1 / (double) num2;
				break;
			case "C":
				fResult = (double) (num1 / num2);
				break;
			case "D":
				iResult = (int) (val1 / num4);
				break;
			case "E":
				fResult = (int) (val1 / num4);
				break;
			case "F":
				fResult = (int) ((double)num1 / num2);
				break;
		}
		System.out.println("iResult is: "+ iResult);
		System.out.println("fResult is: "+ fResult);
		
		kb.close();
	}

}
