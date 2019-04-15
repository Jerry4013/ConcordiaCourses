
public class MedtermTest4_BicycleDriver {

	public static void main(String[] args) {
		MedtermTest4_Bicycle bike1 = new MedtermTest4_Bicycle();
		MedtermTest4_Bicycle bike2 = new MedtermTest4_Bicycle();
		bike1.printStates();
		bike1.changeCadence(50);
		bike1.printStates();
		bike1.speedUp(10);
		bike1.changeGear(2);
		bike1.printStates();
		bike2.printStates();
		bike2.speedUp(10);
		bike2.speedUp(30);
		bike2.printStates();
	}

}
