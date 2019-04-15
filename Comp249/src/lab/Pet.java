package lab;

abstract public class Pet {
	private double weight;
	private int age;
	private double price;
	
	public Pet(){}
	public Pet(double weight, int age, double price){
		this.weight = weight;
		this.age = age;
		this.price = price;
	}
	
	public String toString(){
		return "Weight: " + weight + "\tAge: " + age + "\tPrice: " + price;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int getAge(){
		return age;
	}
	
	public double getPrice(){
		return price;
	}
	
	abstract public double computeFeedingCost();
	
	abstract public void greeting();
}
