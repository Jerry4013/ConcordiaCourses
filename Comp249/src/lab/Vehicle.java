package lab;

public abstract class Vehicle {
	private int seats;
	private int year;
	
	
	public Vehicle(){	}
	
	public Vehicle(int seats, int year){
		if(seats<0 || year<0){
			System.out.println("Fail to creat a vehicle.");
			System.exit(0);
		}
		this.seats = seats; 
		this.year = year;
	}
	
	public int getSeats()
	{
		return seats;
	}
	public int getYear(){
		return year;
	}
	
	public void setSeats(int seats){
		if(seats<0){
			System.out.println("Fail to set seats.");
			System.exit(0);
		}
		this.seats = seats; 
	}
	
	public void setYear(int year){
		if(year<0){
			System.out.println("Fail to set year.");
			System.exit(0);
		}
		this.year = year;
	}
	
	public String toString(){
		return "Manufactured year: " + year + "\nNumber of seats: " + seats;
	}

	public abstract void greeting();
	
}
