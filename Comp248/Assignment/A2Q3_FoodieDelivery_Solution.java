import java.util.Scanner;

public class A2Q3_FoodieDelivery_Solution {

    public static void main(String[] args) {
        // 	Header
        System.out.print("---------------------------------------------------------\n"
                + "            FoodieDelivery Subscription Calculator\n"
                + "---------------------------------------------------------\n\n");

        Scanner keyIn = new Scanner(System.in); // keyboard input

        final double COST_OCCASSIONAL_BASE = 15.00;
        final double COST_MONTREAL_BASE = 30.00;

        final double BASE_DELIVERY_COST = 3.00;
        final double EXTRA_COST_OCCASIONAL = 2.00;
        final double EXTRA_COST_MONTREAL = 1.50;

        final int MAX_DELIVERY_OCCASIONAL = 6;
        final int MAX_DELIVERY_MONTREAL = 12;

        System.out.print("Please enter the number of times a month you use food delivery services: ");

        int userPerMonthOrders = keyIn.nextInt();

        // Compute each package
        double costPayPerDelivery = BASE_DELIVERY_COST * userPerMonthOrders;

        double costExtraDeliveriesOccassional = 0;
        if (userPerMonthOrders > MAX_DELIVERY_OCCASIONAL)
            costExtraDeliveriesOccassional = (userPerMonthOrders - MAX_DELIVERY_OCCASIONAL) * EXTRA_COST_OCCASIONAL;

        double costOccasionalFoodie = COST_OCCASSIONAL_BASE + costExtraDeliveriesOccassional;

        double costExtraDeliveriesMontreal = 0;
        if (userPerMonthOrders > MAX_DELIVERY_MONTREAL)
            costExtraDeliveriesMontreal = (userPerMonthOrders - MAX_DELIVERY_MONTREAL) * EXTRA_COST_MONTREAL;

        double costMontrealFoodie = COST_MONTREAL_BASE + costExtraDeliveriesMontreal;


        // determine the package with minimum cost
        int minPackage = 1;
        double minCost = costPayPerDelivery;

        if (minCost >= costOccasionalFoodie) {
            minCost = costOccasionalFoodie;
            minPackage = 2;
        }

        if (minCost >= costMontrealFoodie) {
            minCost = costMontrealFoodie;
            minPackage = 3;
        }

        double saveFromPPD;
        double saveFromOccassional;
        double saveFromMontreal;

        switch (minPackage) {
            case 1: // recommend pay per delivery
                saveFromOccassional = costOccasionalFoodie - costPayPerDelivery; 			    // how much they save from ppd
                saveFromMontreal = costMontrealFoodie - costPayPerDelivery;
                System.out.printf("\nThe cost of PayPerDelivery would be: $%.2f/month \n", costPayPerDelivery);
                System.out.printf("You would save $ %.2f from OccasionalFoodie and $ %.2f from MontrealFoodie.\n", saveFromOccassional, saveFromMontreal);
                System.out.printf("\n**We recommend getting the PayPerDelivery subscription.**\n");
                break;

            case 2: // recommend OccassionalFoodie
                saveFromPPD = costPayPerDelivery - costOccasionalFoodie; 			    // how much they save from ppd
                saveFromMontreal = costMontrealFoodie - costOccasionalFoodie;
                System.out.printf("\nThe cost of pay per delivery would be: $%.2f/month \n", costPayPerDelivery);
                System.out.printf("Based on your food deliveries, the cost of the OccasionalFoodie subscription would be: $%.2f/month\n\n", costOccasionalFoodie);
                System.out.printf("You would save $ %.2f from PayPerDelivery and $ %.2f from MontrealFoodie.\n", saveFromPPD, saveFromMontreal);
                System.out.print("**We recommend getting the OccasionalFoodie subscription.**\n");
                break;

            case 3: // recommend MontrealFoodie
                saveFromPPD = costPayPerDelivery - costOccasionalFoodie; 			// how much they save from ppd
                saveFromOccassional = costOccasionalFoodie - costMontrealFoodie; 		// how much they save from occasional
                System.out.printf("\nThe cost of pay per delivery would be: $%.2f/month \n", costPayPerDelivery);
                System.out.printf("The cost of pay OccassionalFoodie would be: $%.2f/month \n", costOccasionalFoodie);
                System.out.printf("Based on your food ordering, the cost of the MontrealFoodie subscription would be: $%.2f/month\n\n", costMontrealFoodie);
                System.out.printf("You would save $%.2f from the OccasionalFoodie subscription and $%.2f from PayPerDelivery.\n"
                        , saveFromOccassional, saveFromPPD);
                System.out.print("**We recommend getting the MontrealFoodie subscription.**\n");
                break;
        }

        System.out.println("\nThank you for using FoodieDelivery Subscription Calculator. Good Eats :-)!");
        keyIn.close();

    }
}

