import java.time.YearMonth;
import java.util.Scanner;
public class C6P3_AverageSalary {

	private double[] salary = new double[12];
	private double[] totalSalary = new double[12];
	private int[] overtimeHours = new int[12];
	private double averageSalary;
	
	public C6P3_AverageSalary()
	{
		setSalaryAndOvertimeHours();
		computeAverageSalary();
	}
	
	private void setSalaryAndOvertimeHours()
	{
		Scanner keyIn = new Scanner(System.in);
		YearMonth currentDate = YearMonth.now();
		for(int i=0; i<12; i++)
		{
			System.out.println("Enter your salary in " + currentDate.minusMonths(12-i) + ": ");
			salary[i] = keyIn.nextDouble();
			System.out.println("Enter your overtime hours in " + currentDate.minusMonths(12-i) + ": ");
			overtimeHours[i] = keyIn.nextInt();
		}
		keyIn.close();
    }
	
	private double computeAverageSalary()
	{
		double sum = 0;
		for(int i=0; i<12; i++)
		{
			if (salary[i]>=10000)
				totalSalary[i] = salary[i] + overtimeHours[i] * 25;
			else if(salary[i]>=5000)
				totalSalary[i] = salary[i] + overtimeHours[i] * 20;
			else if(salary[i]>=2000)
				totalSalary[i] = salary[i] + overtimeHours[i] * 15;
			else 
				totalSalary[i] = salary[i] + overtimeHours[i] * 10;
			sum += totalSalary[i];
		}
		averageSalary = sum / 12;
		return averageSalary;
	}
	
	public void displaySalary()
	{
		YearMonth currentDate = YearMonth.now();
		System.out.println("\tTotalSalary\t" + "compare with average\t");
		for(int i=0; i<12; i++)
			System.out.printf( "%s: %.2f\t%.2f\n\n",currentDate.minusMonths(12-i), totalSalary[i], (totalSalary[i]-averageSalary));
		
	}
}
