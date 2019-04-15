package tutorial.Automobile;

public class Car {
	
	private final double MAX_TIRE_PRESSURE = 5.43;
	private boolean car_on;
	private double tirePressure;
	
	Car(double p){
		if(validTirePressure(p))
			tirePressure = p;
		else
			tirePressure = MAX_TIRE_PRESSURE;
		car_on = false;
	}
	public void startCar(){
		car_on = true;
	}
	public void shutCar(){
		car_on = false;
	}
	
	public void setTirePressure(double p){
		if(validTirePressure(p))
			tirePressure = p;
	}
	public double getTirePressure(){
		return tirePressure;
	}
	
	public void fillTires(){
		tirePressure = MAX_TIRE_PRESSURE;
	}
	public boolean equals(Object anotherObject){
		if(anotherObject==null || anotherObject.getClass()!= this.getClass())
			return false;
		Car anotherCar = (Car) anotherObject;
		return car_on == anotherCar.car_on && tirePressure == anotherCar.tirePressure;
	}
	
	public String toString(){
		return (car_on ? "Car on" : "Car OFF") + "with \n\tTire Pressure " + tirePressure + " psi" ;
	}
	private boolean validTirePressure(double tire_pressure){
		return (tire_pressure>= 0 && tire_pressure<= MAX_TIRE_PRESSURE);
	}
}
