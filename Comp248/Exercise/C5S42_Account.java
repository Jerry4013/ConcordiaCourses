
public class C5S42_Account {
	private String name;
	private double balance;
	private int acctNumber;
	
	public C5S42_Account(String newName, double newBalance, int newAccountNumber)
	{
		name = newName;
		balance = newBalance;
		acctNumber = newAccountNumber;
	}
	
	public String toString()
	{
		return ("Account name: " + name + "  Account number: " + acctNumber + "\nBalance: " + balance + "\n\n");
	}
}
