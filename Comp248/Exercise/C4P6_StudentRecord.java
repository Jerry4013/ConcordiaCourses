import java.util.Scanner;
import java.text.DecimalFormat;
public class C4P6_StudentRecord {
	private double quiz1;
	private double quiz2;
	private double quiz3;
	private double midterm;
	private double finalScore;
	private double numericScore;
	private char letterGrade;
	Scanner kb = new Scanner(System.in);
	
	public C4P6_StudentRecord()
	{
		quiz1 = 0;
		quiz2 = 0;
		quiz3 = 0;
		midterm = 0;
		finalScore = 0;
		numericScore = 0;
		letterGrade = 'F';
	}
	
	
	
	public void computeGrade()
	{
		numericScore = ( quiz1 + quiz2 + quiz3 ) / 30 * 0.25 + midterm * 0.35 + finalScore * 0.4;
		if (numericScore>=90)
			letterGrade = 'A';
		else if (numericScore>=80)
			letterGrade = 'B';
		else if (numericScore>=70)
			letterGrade = 'C';
		else if (numericScore>=60)
			letterGrade = 'D';
		else
			letterGrade = 'F';
	}
	
	public void setRecord(double quiz1, double quiz2, double quiz3, double midterm, double finalScore)
	{
		if (quiz1>=0 && quiz1<=10 && quiz2>=0 && quiz2<=10 && quiz3>=0 && quiz3<=10 )
		{
			this.quiz1 = quiz1;
			this.quiz2 = quiz2;
			this.quiz3 = quiz3;
		}
		else
		{
			System.out.print("Invalid quiz score.");
			System.exit(0);
		}
		if (midterm>=0 && midterm<=100 && finalScore>=0 && finalScore<=100)
		{
			this.midterm = midterm;
			this.finalScore = finalScore;
		}
		else
		{
			System.out.print("Invalid score.");
			System.exit(0);
		}
	}
	
	
	public void setQuiz1()
	{
		double quiz1 = 0;
		do
		{
			System.out.print("Input score of quiz 1: ");
			quiz1 = kb.nextDouble();
		}while(quiz1<0 || quiz1>10);
		this.quiz1 = quiz1;
	}
	
	public void setQuiz2(double quiz2)
	{
		if(quiz2>=0 && quiz2<=10)
			this.quiz2 = quiz2;
		else
		{
			System.out.println("Invalid score.");
			System.exit(0);
		}
	}
	
	public void setQuiz3(double quiz3)
	{
		if(quiz3>=0 && quiz3<=10)
			this.quiz3 = quiz3;
		else
		{
			System.out.println("Invalid score.");
			System.exit(0);
		}
	}
	
	public void setMidterm(double midterm)
	{
		if(midterm>=0 && midterm<=100)
			this.midterm = midterm;
		else
		{
			System.out.println("Invalid score.");
			System.exit(0);
		}
	}
	
	public void setFinalScore(double finalScore)
	{
		if(finalScore>=0 && finalScore<=100)
			this.finalScore = finalScore;
		else
		{
			System.out.println("Invalid score.");
			System.exit(0);
		}
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.0");
		return ("Quiz1: " + df.format(quiz1) + "\nQuiz2: " + df.format(quiz2) + "\nQuiz3: " + df.format(quiz3) +
				"\nMidterm: " + df.format(midterm) + "\nFinal: " + df.format(finalScore) + 
				"\nNumeric Score: " + df.format(numericScore) + "\nLetter Grade: " + df.format(letterGrade));
	}
	
	
}
