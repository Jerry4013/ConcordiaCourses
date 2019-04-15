package tutorial.tutorial8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private class Country implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String country;

		/**
		 * @param country
		 */
		public Country(String country) {
			super();
			this.country = country;
		}
		public Country(Country other){
			country = other.country;
		}
		
		public String toString(){
			return country;
		}
		
	}
	
	private class Street implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String street;

		/**
		 * @param street
		 */
		public Street(String street) {
			super();
			this.street = street;
		}
		public Street(Street other){
			street = other.street;
		}
		
		public String toString(){
			return street;
		}
	}
	
	private Country country;
	private Street street;
	/**
	 * @param country
	 * @param street
	 */
	public Address(){}
	public Address(String country, String street) {
		super();
		this.country = new Country(country);
		this.street = new Street(street);
	}
	
	
	public Country getCountry() {
		return new Country(country);
	}
	public void setCountry(Country country) {
		this.country = new Country(country);
	}
	public Street getStreet() {
		return new Street(street);
	}
	public void setStreet(Street street) {
		this.street = new Street(street);
	}
	
	public String toString(){
		return country.country + " " + street.street;
	}
}

public class Q4 {

	public static void main(String[] args) {
		Address a = new Address("CANADA", "MapleView");
		System.out.println(a);
		
		try{
			ObjectOutputStream binOut = new ObjectOutputStream(new FileOutputStream("IOfiles/tutorial/tut8/address.dat"));
			binOut.writeObject(a);
			binOut.close();
			ObjectInputStream binIn = new ObjectInputStream(new FileInputStream("IOfiles/tutorial/tut8/address.dat"));
			Address b = (Address)binIn.readObject();
			System.out.println(b);
			binIn.close();
		}catch(FileNotFoundException e){
			System.out.println("Cannot find the file.");
		}catch(IOException e){
			System.out.println("Error in file reading or writing");
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
			System.out.println("Cannot find this class.");
		}
	}

}
