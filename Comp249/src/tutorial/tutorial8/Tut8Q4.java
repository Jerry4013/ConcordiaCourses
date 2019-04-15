package tutorial.tutorial8;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

class Address2 implements Serializable {
		
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	class Country implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String country;
		
		Country(String c)
		{
			country = c;
		}
		
		public String toString()
		{
			return country;
		}
	
	}
	
	class Street implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String street;
		
		Street(String s)
		{
			street = s;
		}
		
		public String toString()
		{
			return street;
		}
	}
	
	Country country;
	Street street;
	
	Address2()
	{
		country = null;
		street = null;
	}
	
	public void setCountry(String c)
	{
		country = new Country(c);
	}
	
	public void setStreet(String s)
	{
		street = new Street(s);
	}
	
	public String toString()
	{
		return "COUNTRY" + country + "STREET" + street;
	}
	
}

public class Tut8Q4 {
	
	public static void outputAddress(Address2 a)
	{
		ObjectOutputStream obj_out = null;
		
		try
		{
			obj_out = new ObjectOutputStream(new FileOutputStream("address.dat"));
			
			obj_out.writeObject(a);
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		finally 
		{
			if (obj_out != null)
			{
				try
				{
					obj_out.close();
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
	
	public static Address2 openAddress()
	{
		ObjectInputStream obj_in = null;
		Address2 address_out = null;
		try
		{
			obj_in = new ObjectInputStream(new FileInputStream("address.dat"));
			address_out = (Address2)obj_in.readObject();
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return address_out;
	}

	public static void main(String[] args) 
	{
		Address2 a = new Address2();
		
		a.setCountry("CANADA");
		a.setStreet("MapleView");
		
		outputAddress(a);
		
		System.out.println(a);

		Address2 a1 = openAddress();
		
		System.out.println(a1);
	}

}
