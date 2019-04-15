
public class C3T_SelfTest3_2 {

	public static void main(String[] args) {
		//Q17
		int exam = 78, programsDone = 13;
		if ((exam >= 60) && (programsDone>=10))
			System.out.println("Passed");
		else
			System.out.println("Failed");
		
		//Q18
		int pressure = 103, temperature = 200;
		if( (pressure>100) || (temperature>=212) )
			System.out.println("Emergency");
		else
			System.out.println("OK");
		
	}

}
