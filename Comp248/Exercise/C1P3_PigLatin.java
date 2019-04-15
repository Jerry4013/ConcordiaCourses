import java.util.Scanner;

public class C1P3_PigLatin {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please type your first and last name in lowercase:");
		String firstname = kb.next();
		String lastname = kb.next();
		
		
		char first1 = firstname.charAt(0);
		char last1 = lastname.charAt(0);
		String first2 = firstname.substring(1,2);
		String last2 = lastname.substring(1,2);
		String restOfFirst = firstname.substring(2);
		String restOfLast = lastname.substring(2);
		
		System.out.println("Your new name is: " + first2.toUpperCase() + restOfFirst + first1 + "ay " 
							+ last2.toUpperCase() + restOfLast + last1 + "ay");
		
		kb.close();
		

	}

}
