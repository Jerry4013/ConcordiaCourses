import java.util.Scanner;
public class C3P2_ThreeColors {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter your color selection: (with no space) ");
		String stripePattern = kb.next();
		String characterCheck = null, firstcharacter = null, nextCharacter = null;
		
		int i=0, errorCounter1 = 0, errorCounter2 = 0;
		for (i=0; i<5; i++)
		{
			characterCheck = stripePattern.substring(i,i+1);
			if(characterCheck.equalsIgnoreCase("R")==false && characterCheck.equalsIgnoreCase("G")==false && characterCheck.equalsIgnoreCase("B")==false)
			{
				System.out.println("Your color selection of number " + (i+1) +
						" is not available. Please use colors from R,G,B. ");
				errorCounter1 = errorCounter1 + 1;
			}
		}
		if (errorCounter1 == 0)
			System.out.println("Your color selection is available! ");
		
		for(i=0;i<4;i++)
		{
			firstcharacter = stripePattern.substring(i, i+1);
			nextCharacter = stripePattern.substring(i+1, i+2);
			if (firstcharacter.equalsIgnoreCase(nextCharacter))
			{	
				System.out.println("Your color of number " + (i+1) + " and color of number "+ (i+2) + " are the same. " + 
					"Please do not use the same color for adjacent stripes. ");
				errorCounter2 = errorCounter2 + 1;
			}
		}
		if (errorCounter2 == 0 && errorCounter1 == 0)
			System.out.println("Good choice!");
		
		kb.close();
		
	}

}
