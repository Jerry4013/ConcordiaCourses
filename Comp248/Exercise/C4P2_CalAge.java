import java.time.LocalDate;
import java.util.Scanner;
public class C4P2_CalAge {
	private int day;
	private int month;
	private int year;
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	LocalDate currentDate = LocalDate.now();
	
	public C4P2_CalAge()
	{
		day = currentDate.getDayOfMonth();
		month = currentDate.getMonthValue();
		year = currentDate.getYear();
	}
	
	public void setDateOfBirth()
	{
		int day;
		int month;
		int year;
		Scanner kb = new Scanner(System.in);
		System.out.println("Set your date of birth below with integer: \nDay: ");
		day = kb.nextInt();
		System.out.println("Month: ");
		month = kb.nextInt();
		System.out.println("Year: ");
		year = kb.nextInt();
		if(dateOfBirthOK(day, month, year))
		{
			dayOfBirth = day;
			monthOfBirth = month;
			yearOfBirth = year;
		}
		else
		{
			System.out.print("Invalid birthday!");
			System.exit(0);
		}
		kb.close();
	}
	
	public void setCurrentDate(int day, int month, int year)
	{
		if(dateOK(day, month, year))
			this.day = day;
			this.month = month;
			this.year = year;
	}
	
	public int calculateAge()
	{
		setDateOfBirth();
		if(monthOfBirth < this.month || (monthOfBirth == this.month && dayOfBirth <= this.day))
			return (this.year - yearOfBirth);
		else 
			return (this.year - yearOfBirth - 1);
	}
	
	public double calculateAgeWithDecimal ()
	{
		double age;
		age = ((this.year - yearOfBirth) * 12 + this.month - monthOfBirth) / 12.0;
		return age;
	}
	
	private boolean dateOfBirthOK(int day, int month, int year)
	{
		if(year<1900 || year>currentDate.getYear())
			return false;
		return(dateOK(day, month, year));
	}
	
	private boolean dateOK(int day, int month, int year)
	{
		switch (month)
		{
		case 1:
			return (day >= 1) && (day <= 31);
		case 2:
			if (leapYear(year))
				return (day >= 1) && (day <= 29);
			else
				return (day >= 1) && (day <= 28);
		case 3:
			return (day >= 1) && (day <= 31);
		case 4:
			return (day >= 1) && (day <= 30);
		case 5:
			return (day >= 1) && (day <= 31);
		case 6:
			return (day >= 1) && (day <= 30);
		case 7:
			return (day >= 1) && (day <= 31);
		case 8:
			return (day >= 1) && (day <= 31);
		case 9:
			return (day >= 1) && (day <= 30);
		case 10:
			return (day >= 1) && (day <= 31);
		case 11:
			return (day >= 1) && (day <= 30);
		case 12:
			return (day >= 1) && (day <= 31);
		default:
			return false;
		}
	}
	private boolean leapYear(int yearInt)
	{
		return ((yearInt % 4 == 0) && (yearInt % 100 != 0)) || (yearInt % 400 == 0);
	}
}
