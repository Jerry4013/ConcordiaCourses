
public class T11Q4_Airplane {
	
	private int nbOfPassengers;
	private double weight;
	private int maxSpeed;
	
	public T11Q4_Airplane(int initialNumberOfPassengers, double initialWeight, int initialMaxSpeed)
	{
		setPlane(initialNumberOfPassengers, initialWeight, initialMaxSpeed);
	}
	
	public T11Q4_Airplane()
	{
		
	}
	
	public T11Q4_Airplane(T11Q4_Airplane anAirplane)
	{
		nbOfPassengers = anAirplane.nbOfPassengers;
		weight = anAirplane.weight;
		maxSpeed = anAirplane.maxSpeed;
	}
	
	public double getWeight() {
		return weight;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setPlane(int newNumberOfPassengers, double newWeight, int newMaxSpeed)
	{
		if(newNumberOfPassengers<0||newWeight<0||newMaxSpeed<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		nbOfPassengers = newNumberOfPassengers;
		weight = newWeight;
		maxSpeed = newMaxSpeed;
	}
	
	public static double getAverageWeight(T11Q4_Airplane[] someAirplanes)
	{
		double sum = 0;
		double averageWeight = 0;
		for (int i=0; i<someAirplanes.length; i++)
			sum += someAirplanes[i].weight;
		averageWeight = sum / someAirplanes.length;
		return averageWeight;
	}
	
	public static T11Q4_Airplane findFasterAirplane(T11Q4_Airplane[] fleet)
	{
		int maxSpeed = 0, indexOfMax = 0;
		for (int i = 0 ; i<fleet.length; i++)
			if(fleet[i].maxSpeed > maxSpeed)
			{
				maxSpeed = fleet[i].maxSpeed;
				indexOfMax = i;
			}
		for (int i = 0 ; i<fleet.length; i++)
			if(fleet[i].maxSpeed == maxSpeed && indexOfMax!=i)
			{
				System.out.println("null");
				System.exit(0);
			}
		return fleet[indexOfMax];
	}
	
	public String toString()
	{
		return ("This plane has " + nbOfPassengers + " passengers, and its weight is " + weight  +", max speed is " + maxSpeed);
	}
}
