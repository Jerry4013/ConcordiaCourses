package lab;

public class Dog extends Pet{
	private String breed;
	private boolean trained;
	
	public Dog(){}
	public Dog(double weight, int age, double price, String breed, boolean trained){
		super(weight, age, price);
		this.breed = breed;
		this.trained = trained;
	}
	
	public String toString(){
		return super.toString() + "\nBreed: " + breed + trainedString();
	}
	
	public double computeFeedingCost(){
		return (trained)? (15 + getWeight() * getPrice() / 25) : (getWeight() * getPrice() / 25);
	}
	
	public void greeting(){
		String trainString;
		if(trained)
			trainString = "trained";
		else
			trainString = "not trained";
		System.out.println("I am a " + trainString + " dog of breed " + breed + 
				". \nMy weight: " + getWeight() + ", age: " + getAge() + " months, price: " + getPrice() + 
				".\nMy feeding cost is " + computeFeedingCost());
	}
		
	private String trainedString(){
		if(trained)
			return " Trained: Yes.";
		else
			return " Trained: No.";
	}
}
