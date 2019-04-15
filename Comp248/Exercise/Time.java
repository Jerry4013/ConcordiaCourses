import java.util.Scanner;
public class Time {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		System.out.println("Enter a number:");
		int seconds = kb.nextInt();
		int hours=0, minutes=0, restseconds=0;
		String hourtext ="", minutetext = "", secondtext=""; 
		
		if (seconds>=3600)
		{
			hours = seconds / 3600;
			if (seconds > 3600)
				if(seconds >= 7200)
					if (seconds % 3600 == 0)
						hourtext = hours + " hours";
					else
						hourtext = hours + " hours ";
				else 
					if (seconds % 3600 == 0)
						hourtext = hours + " hour";
					else
						hourtext = hours + " hour ";
			else
				hourtext = hours + " hour";
		}
		
		if (seconds % 3600 >= 60)
		{
			minutes = seconds % 3600 / 60;
			if (seconds % 3600 > 60)
				if (seconds % 3600 >= 120)
					if (seconds % 3600 % 60 == 0)
						minutetext = minutes + " minutes";
					else
						minutetext = minutes + " minutes ";
				else
					minutetext = minutes + " minute ";
			else 
				minutetext = minutes + " minute";
		}
		
		if (seconds % 3600 % 60 > 0)
		{
			restseconds = seconds % 3600 % 60;
			if (restseconds > 1)
				secondtext = restseconds + " seconds";
			else
				secondtext = restseconds + " second";
		}
		
	
		System.out.println("\n<" + seconds + " seconds> is equal to <" + hourtext + minutetext + secondtext + ">.");
	
		
		kb.close();

	}

}
