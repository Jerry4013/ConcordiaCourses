
import java.util.Scanner;

public class A2Q2 {

    public static void main(String[] args) {

        final int SPEED_LIMIT = 100;

        // 	Header
        System.out.print("---------------------------------------------------------\n"
                + "            SpeedyFines Calculator\n"
                + "---------------------------------------------------------\n\n");

        Scanner keyIn = new Scanner(System.in); // keyboard input

        System.out.print("How fast was the driver going? ");
        int speed = keyIn.nextInt();

        int kmOver = speed - SPEED_LIMIT;
        int demeritPointsAdded = 0;

        boolean speeding = true; // boolean to keep track if driver was speeding
        boolean lostLicense = false; // boolean to keep track if driver loses license

        // determine the speeding fine and demerit points based on how fast driver was going
        if (kmOver > 0 && kmOver < 10)
            System.out.println("The fine is $65 but you didn't lose any demerit points!");
        else if (kmOver >= 10 && kmOver < 20) {
            System.out.println("The fine is $120 and the driver gets 2 demerit points!");
            demeritPointsAdded = 2;
        } else if (kmOver >= 20 && kmOver < 40) {
            System.out.println("The fine is $240 and the driver gets 5 demerit points!");
            demeritPointsAdded = 5;
        } else if (kmOver >= 40 && kmOver < 60) {
            System.out.println("The fine is $360 and the driver gets 7 demerit points!");
            demeritPointsAdded = 7;
        } else if (kmOver >= 60) {
            System.out.println("The fine is $520 and the driver loses his license.");
            lostLicense = true;
        } else {
            System.out.println("The driver was not speeding.");
            speeding = false;
        }

        if (speeding && !lostLicense) { // only calculate demerit points if speeding and didn't lose license yet
            System.out.print("How many demerit points did the driver have prior to being stopped? ");
            int demeritPoints = keyIn.nextInt();

            demeritPoints = demeritPoints + demeritPointsAdded;

            if (demeritPoints >= 12)
                System.out.printf("The driver has %d demerit points and loses his license.", demeritPoints);
            else
                System.out.printf("The driver now has %d demerit points.", demeritPoints);

        }
        keyIn.close();
    }
}
