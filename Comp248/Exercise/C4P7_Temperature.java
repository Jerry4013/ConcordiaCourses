
public class C4P7_Temperature {
	
	private double temperature;
	private char scale;
	
	public C4P7_Temperature(double temperature)
	{
		setValue(temperature);
		scale = 'C';
	}
	
	public C4P7_Temperature(char scale)
	{
		setScale(scale);
		temperature = 0;
	}
	
	public C4P7_Temperature(double temperature, char scale)
	{
		setBoth(temperature, scale);
	}
	
	public C4P7_Temperature()
	{
		temperature = 0;
		scale = 'C';
	}
	
	public double getTemperatureInCelsius()
	{
		double temp;
		if(scale == 'C')
			return (Math.round(temperature * 10.0) / 10.0);
		else
		{
			temp = 5 * ( temperature - 32 )/9;
			return (Math.round(temp * 10.0) / 10.0);
		}
	}
	
	public double getTemperatureInFahrenheit()
	{
		double temp;
		if(scale == 'F')
			return (Math.round(temperature * 10.0) / 10.0);
		else
		{
			temp = 9 * temperature / 5 + 32;
			return (Math.round(temp * 10.0) / 10.0);
		}
	}
	
	public void setValue(double value)
	{
		this.temperature = value;
	}
	
	public void setScale(char scale)
	{
		if (scale=='c'||scale=='C')
			this.scale = 'C';
		else if (scale=='f'||scale=='F')
			this.scale = 'F';
		else
		{
			System.out.print("Invalid scale!");
			System.exit(0);
		}
	}
	
	public void setBoth(double value, char scale)
	{
		setValue(value);
		setScale(scale);
	}
	
	public boolean equals(C4P7_Temperature anotherValue)
	{
		return (this.getTemperatureInCelsius() == anotherValue.getTemperatureInCelsius());
	}
	
	public boolean isGreaterThan(C4P7_Temperature anotherValue)
	{
		return (this.getTemperatureInCelsius() > anotherValue.getTemperatureInCelsius());
	}
	
	public boolean isLessThan(C4P7_Temperature anotherValue)
	{
		return (this.getTemperatureInCelsius() < anotherValue.getTemperatureInCelsius());
	}
	
	public String toString()
	{
		return (temperature + " degrees " + scale);
	}
	
}
