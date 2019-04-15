
public class C4P3_Vehicle {
	private double tankSize;
	private double efficiency;
	private double fuelInTank = 0;
	
	public void setTanksize(double iniTankSize)
	{
		tankSize = iniTankSize;
	}
	
	public void setEfficiency(double initEfficiency)
	{
		efficiency = initEfficiency;
	}
	
	public void setFuelInTank (double fuelInTank)
	{
		this.fuelInTank = fuelInTank;
	}
	
	public double addPetrol()
	{
		return ( tankSize - fuelInTank );
	}
	
	public double driveTo()
	{
		return fuelInTank / efficiency;
	}
}
