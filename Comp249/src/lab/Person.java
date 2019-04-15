package lab;

public class Person {
	private String name;
	private int age;
	private char gender;
	
	public Person ()
	{
		name = null;
		age = 0;
		gender = '-';
	}
	
	public Person(Person anotherPerson)
	{
		if(anotherPerson==null)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		name = anotherPerson.name;
		age = anotherPerson.age;
		gender = anotherPerson.gender;
		format();
	}
	
	public Person(String theName, int theAge, char theGender)
	{
		
		name = theName;
		if (theAge<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		age = theAge;
		
		if (theGender!='M' && theGender!='F')
		{
			System.out.println("Fatal error! The gender could only be M or F.");
			System.exit(0);
		}
		gender = theGender;
		format();
	}
	
	public void setName(String newName)
	{
		
		name = newName;
		format();
	}
	
	public void setAge(int newAge)
	{
		if (newAge<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		age = newAge;
	}
	
	public void setGender(char newGender)
	{
		if (newGender!='M' && newGender!='F')
		{
			System.out.println("Fatal error! The gender could only be M or F.");
			System.exit(0);
		}
		gender = newGender;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public char getGender()
	{
		return gender;
	}
	
	public boolean equals(Object anotherObject)
	{
		if (anotherObject == null)
			return false;
		if(anotherObject.getClass()!=getClass())
			return false;
		Person anotherPerson = (Person)anotherObject;
		return name.equals(anotherPerson.name) && age == anotherPerson.age && gender == anotherPerson.gender;
	}
	
	public String toString()
	{
		return "Name: " + name + "\tAge: "+age+"\nGender: " + gender;
	}
	
	private void format()
	{
		String firstLetter = name.substring(0, 1).toUpperCase();
		String remainingName = name.substring(1, name.length()).toLowerCase();
		name = firstLetter + remainingName;
	}
	
}
