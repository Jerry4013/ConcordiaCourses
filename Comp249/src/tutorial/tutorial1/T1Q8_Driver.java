package tutorial.tutorial1;

public class T1Q8_Driver {
	public static void main(String[] args){
		T1Q8_Student s1 = new T1Q8_Student();
		s1.setQuiz(0, 15);
		s1.setQuiz(1, 17);
		s1.setQuiz(2, 4);
		
		s1.setMidterm(47);
		s1.setFinal(84);
		 
		
		s1.calculate_overall();
		s1.calculate_letter_grade();
		System.out.println(s1);
	}
}
