package lab;

public class Cat extends Pet{
	
	private String type;
	
	public Cat(){}
	public Cat(double weight, int age, double price, String type){
		super(weight, age, price);
		this.type = type;
	}
	
	public String toString(){
		return super.toString() + "\nType: " + type;
	}
	
	public double computeFeedingCost(){
		return getWeight() * getPrice() / 25;
	}
	
	public void greeting(){
		System.out.println("I am a cat of type " + type + 
				". \nMy weight: " + getWeight() + ", age: " + getAge() + " months, price: " + getPrice() + 
				".\nMy feeding cost is " + computeFeedingCost());
	}
	
}
