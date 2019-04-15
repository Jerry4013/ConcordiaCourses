package lab;

public class PetsDemo {

	public static void main(String[] args) {
		Pet[] petArray = new Pet[4];
		petArray[0] = new Cat(6, 15, 50, "persian");
		petArray[1] = new Cat(6, 9, 100, "British shorthair");
		petArray[2] = new Dog(20, 18, 75, "pitbull", true);
		petArray[3] = new Dog(18, 19, 40, "Labrador", false);
		
		for(int i=0; i<petArray.length; i++){
			petArray[i].greeting();
			System.out.println();
		}
		
		double totalCatFeedingcost=0;
		double totalDogFeedingcost=0;
		for (int i=0; i<petArray.length; i++){
			String petClass = petArray[i].getClass().toString();
			petClass = petClass.substring(6);
			if(petClass.equals("Cat"))
				totalCatFeedingcost += petArray[i].computeFeedingCost();
			else
				totalDogFeedingcost += petArray[i].computeFeedingCost();
		}
		
		System.out.println("Total Cat Feeding cost: " + totalCatFeedingcost);
		System.out.println("Total Dog Feeding cost: " + totalDogFeedingcost);
	}
	
	

}
