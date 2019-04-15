
public class C2P4_travel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int distance = 55;
		int speed = 15;
		int hours = distance / speed;
		int minutes = (int)(distance % speed / (double) speed * 60);
		
		System.out.println("The total time is: "+ hours + " hours and " + minutes + " minutes.");
	}

}
