import java.util.Scanner;

public class A2Q1 {

    public static void main(String[] args) {

        boolean ifStatement = false;

        Scanner keyIn = new Scanner(System.in); // keyboard input

        System.out.print("Please enter the day of the week as an number 1-7: "); // get input
        int dayOfWeek = keyIn.nextInt();

        if (ifStatement) {
            // use if statements to print which day
            if (dayOfWeek == 1)
                System.out.print("It's Monday!");
            else if (dayOfWeek == 2)
                System.out.print("It's Tuesday!");
            else if (dayOfWeek == 3)
                System.out.print("It's Wednesday!");
            else if (dayOfWeek == 4)
                System.out.print("It's Thursday!");
            else if (dayOfWeek == 5)
                System.out.print("It's Friday!");
            else if (dayOfWeek == 6)
                System.out.print("It's Saturday!");
            else if (dayOfWeek == 7)
                System.out.print("It's Sunday!");
            else
                System.out.println("That's not a valid day!");

            // check if weekend or weekday
            if (dayOfWeek == 6 || dayOfWeek == 7)
                System.out.println(" It's the weekend!");
            else if (dayOfWeek > 1 && dayOfWeek <6)
                System.out.println(" It's a weekday!");

        }
        else {
            // use a switch statement to print which day
            switch (dayOfWeek) {
                case 1:
                    System.out.print("It's Monday! ");
                    System.out.println("It's a weekday!");
                    break;
                case 2:
                    System.out.print("It's Tuesday! ");
                    System.out.println("It's a weekday!");
                    break;
                case 3:
                    System.out.print("It's Wednesday! ");
                    System.out.println("It's a weekday!");
                    break;
                case 4:
                    System.out.print("It's Thursday! ");
                    System.out.println("It's a weekday!");
                    break;
                case 5:
                    System.out.print("It's Friday! ");
                    System.out.println("It's a weekday!");
                    break;
                case 6:
                    System.out.print("It's Saturday! ");
                    System.out.println("It's the weekend!");
                    break;
                case 7:
                    System.out.print("It's Sunday! ");
                    System.out.println("It's the weekend!");
                    break;
                default:
                    System.out.println("That's not a valid day!");
            }
        }
        keyIn.close();
    }
}
