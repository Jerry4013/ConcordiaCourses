
public class T11Q4_AirplaneDemo {

	public static void main(String[] args) {
		T11Q4_Airplane airplane1 = new T11Q4_Airplane(125, 641.2, 156);
		System.out.println(airplane1);
		T11Q4_Airplane[] fleet  = new T11Q4_Airplane[5];
		for(int i=0; i<fleet.length; i++)
			fleet[i] = new T11Q4_Airplane(airplane1);
		double averageWeight = T11Q4_Airplane.getAverageWeight(fleet);
		System.out.println("The average weight of the fleet is " + averageWeight);
		
		fleet[1].setPlane(128, 548, 264);
		fleet[2].setPlane(256, 452, 238);
		T11Q4_Airplane fastestPlane = new T11Q4_Airplane(T11Q4_Airplane.findFasterAirplane(fleet));
		System.out.println(fastestPlane);
	}

}
