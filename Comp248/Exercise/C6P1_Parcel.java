import java.util.Scanner;
public class C6P1_Parcel {
	private double[] weight = new double[5];//weight in kilometer
	private String[] deliveryLocation = new String[5];
	private double[] cost = new double[5];
	private double totalCost;
	
	public C6P1_Parcel()
	{
		Scanner kb = new Scanner(System.in);
		for(int i=0; i<5; i++)
		{
			System.out.println("Enter the weight of parcel number "+(i+1));
			weight[i] = kb.nextDouble();
			System.out.println("Enter the delivery location of parcel number "+(i+1) + " (In/Out)");
			String temp = kb.next();
			if (temp.equalsIgnoreCase("In"))
				deliveryLocation[i] = "WITHIN_CITY";
			else if (temp.equalsIgnoreCase("Out"))
				deliveryLocation[i] = "OUTSIDE_CITY";
			else
			{
				System.out.println("Invalid location");
				System.exit(0);
			}
		}
		calculateCost();
		kb.close();
	}
	
	public void calculateCost()
	{
		for(int i=0; i<5; i++)
		{
			if(deliveryLocation[i].equals("WITHIN_CITY"))
				cost[i] = Math.ceil(weight[i]) * 2 + 20;
			else
				cost[i] = Math.ceil(weight[i]) * 2 + 40;
			totalCost += cost[i];
		}
	}
	
	public void display()
	{
		for (int i=0; i<5; i++)
			System.out.println("Cost of parcel number "+(i+1)+": " + cost[i]);
		System.out.println("Total cost: " + totalCost);
	}
}
