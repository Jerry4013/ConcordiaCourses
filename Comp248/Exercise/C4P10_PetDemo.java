import java.util.Scanner;

public class C4P10_PetDemo {

	public static void main(String[] args) {
		C4P10_Pet P1 = new C4P10_Pet();
		System.out.println(P1);
		System.out.println();
		
		// let's create a pet object
		C4P10_Pet usersPet = new C4P10_Pet("Jane Doe");
        System.out.println("My records on your pet are incomplete.");
        System.out.println("Here is what they currently say:");
        System.out.println(usersPet); // this calls the toString method
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the pet's type:");
        String type = keyboard.nextLine( );
        System.out.println("Please enter the pet's name:");
        String name = keyboard.nextLine( );
        System.out.println("Please enter the pet's age:");
        int age = keyboard.nextInt( );
        System.out.println("Please enter the pet's weight:");
        double weight = keyboard.nextDouble( );
        usersPet.set(type, name, age, weight);
        System.out.println("My records now say:");
        System.out.println(usersPet);
        System.out.printf("Dosage in ml for the sedative acepromazine: %.5f" , usersPet.acepromazine());
        
        keyboard.close();
	}

}
