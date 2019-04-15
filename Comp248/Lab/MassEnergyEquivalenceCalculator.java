
import java.util.Scanner;
public class MassEnergyEquivalenceCalculator {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//variable declaration
		int mass, speed, remainder, energy, testRemainder;
		//prompt the user to input the three needed variable values
		System.out.print("Input mass: ");
		mass = keyboard.nextInt();
		System.out.print("Input speed: ");
		speed = keyboard.nextInt();
		System.out.print("Input remainder: ");
		remainder = keyboard.nextInt();
		System.out.println();
		
		//calculate
		energy = mass * speed * speed;
		testRemainder = mass % remainder;
		
		//output
		System.out.println("The energy produced is: " + energy + 
				", and the test remainder is: " + testRemainder);
		keyboard.close();
		
	}

}
