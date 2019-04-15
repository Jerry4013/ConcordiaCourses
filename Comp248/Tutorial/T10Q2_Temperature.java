
public class T10Q2_Temperature {
	private double value;
	private char scale;
	
	
	public T10Q2_Temperature()
	{
		value = 0;
		scale = 'C';
	}
	
	public T10Q2_Temperature(double value, char scale)
	{
		setBoth(value, scale);
	}
	
	public double getTempInCelsius()
	{
		double temp;
		if(scale == 'C')
			return value;
		else
		{
			temp = (5.0 / 9.0) * ( value - 32 );
			return (Math.round(temp * 10.0) / 10.0);
		}
	}
	
	public void setBoth(double value, char scale)
	{
		setValue(value);
		setScale(scale);
	}
	
	public boolean isHotter(T10Q2_Temperature anotherValue)
	{
		return (getTempInCelsius() > anotherValue.getTempInCelsius());
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public void setScale(char scale)
	{
		if (scale=='F')
			this.scale = 'F';
		else 
			this.scale = 'C';
	}
	
	public String toString()
	{
		return (value + " degrees " + scale);
	}
	
	public double add(T10Q2_Temperature anotherTemperature)
	{
		double sum;
		sum = getTempInCelsius() + anotherTemperature.getTempInCelsius();
		return sum;
	}
	
}
