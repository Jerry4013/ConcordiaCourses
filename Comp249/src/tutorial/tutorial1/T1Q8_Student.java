package tutorial.tutorial1;


/**
 * 
 * @author z_jingc
 * @version 1.5
 */
public class T1Q8_Student {
	private int[] quiz;
	private int midterm;
	private int final_score;
	private double overall_score;
	private char letter_grade;
	
	public T1Q8_Student()
	{
		quiz = new int[3];
		overall_score = 0.0;
		letter_grade = '-';
	}
	
	public T1Q8_Student(int[] theQuiz, int theMidtermScore, int theFinalScore,
			double theOverallScore, char theLetterGrade)
	{
		for(int i=0; i<3; i++)
			if(theQuiz[i]>=0 && theQuiz[i]<=20)
				quiz[i] = theQuiz[i];
			else
			{
				System.out.println("Fatal error!");
				System.exit(0);
			}
		if(theMidtermScore>=0 && theMidtermScore<=50)
			midterm = theMidtermScore;
	}
	
	public int getQuiz(int QuizNumber)
	{
		return quiz[QuizNumber-1];
	}
	
	/**
	 * 
	 * this stores a quiz mark
	 * 
	 * @param quiz_number which quiz we want to edit
	 * @param score the score for the given quiz
	 * 
	 * @see #setMidterm(int)
	 */
	public void setQuiz(int quiz_number, int score)
	{
		//Out of array bounds
		if(quiz_number <0 || quiz_number>2)
			return;
		
		//Invalid score
		if(score <0||score>20)
			return;
		
		quiz[quiz_number] = score;
	}
	
	public void setMidterm(int score)
	{
		//Invalid score
		if(score < 0 || score >50)
			return;
		midterm = score;
	}
	
	public void setFinal(int score)
	{
		//Invalid score
		if(score < 0 || score >100)
			return;
		final_score = score;
	}
	
	public void calculate_overall()
	{
		overall_score = (double)(quiz[0] + quiz[1] + quiz[2])*15.0/60 +
				(double)midterm * 35/50 + 
				(double)final_score * 50 / 100;
	}
	
	public void calculate_letter_grade()
	{
		if (final_score<=100 && final_score>=90)
		{
			letter_grade = 'A';
			return;
		}
		if (final_score<90 && final_score>=80)
		{
			letter_grade = 'B';
			return;
		}
		if (final_score<80 && final_score>=70)
		{
			letter_grade = 'C';
			return;
		}
		if (final_score<70 && final_score>=60)
		{
			letter_grade = 'D';
			return;
		}
		if (final_score<=60 && final_score>=0)
		{
			letter_grade = 'F';
			return;
		}
	}
	
	public String toString()
	{
		return "Quiz [1,2,3] --> "+quiz[0]+" "+quiz[1]+" "+quiz[2]+
				" Midterm "+ midterm + " Final "+ final_score + " Overall score " + overall_score + 
				" Grade " + letter_grade;
	}
	
	
}
