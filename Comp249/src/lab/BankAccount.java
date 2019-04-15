package lab;

public class BankAccount {
	
	private int number;
	private String name;
	private double balance;
	
	/**
	 * default constructor
	 */
	public BankAccount(){
	
	}
	
	/**
	 * Account number cannot be negative
	 * @param number  account number of this account.
	 * @param name  name of this account
	 * @param balance balance of this account.
	 */
	public BankAccount(int number, String name, double balance){
		if(number<=0){
			System.out.println("Fatal error! Account number cannot be negative!");
			System.exit(0);
		}
		this.number = number;
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * Copy constructor
	 * @param anotherAccount the object we want to copy
	 */
	public BankAccount(BankAccount anotherAccount){
		if (anotherAccount==null){
			System.out.println("Fail to creat a account.");
			System.exit(0);
		}
		number = anotherAccount.number;
		name = anotherAccount.name;
		balance = anotherAccount.balance;
	}
	
	/**
	 * toString
	 */
	public String toString(){
		return ("Account number: " + number + "\nAccount name: " + name + "\nAccount balance: $" + balance);
	}
	
	/**
	 * equals
	 */
	public boolean equals(Object anotherObject){
		if (anotherObject==null || getClass()!=anotherObject.getClass())
			return false;
		BankAccount anotherAccount = (BankAccount)anotherObject;
		return number == anotherAccount.number && name.equals(anotherAccount.name) && balance == anotherAccount.balance;
	}
	
	
	
}
