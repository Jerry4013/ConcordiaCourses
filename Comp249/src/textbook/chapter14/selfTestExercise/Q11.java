package textbook.chapter14.selfTestExercise;

import java.util.ArrayList;

public class Q11 {

	public static void main(String[] args) {
		ArrayList<Double> score = new ArrayList<Double> ();
		double average = 70.33;
		for (int i=0; i<score.size(); i++){
			System.out.println(score.get(i) + " differs from average by "+ (score.get(i) - average));
		}
	}

}
