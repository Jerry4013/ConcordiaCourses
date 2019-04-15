package lab;

public class CheckingAccount extends BankAccount{
	private int maxFreeTransaction;
	private final int TransactionFee = 2;
	
	public CheckingAccount(){}
	public CheckingAccount(int number, String name, double balance, int maxFreeTransaction){
		super(number, name, balance);
		if(maxFreeTransaction<0)
		{
			System.out.println("Fatal error: Negative number of Free Transactions.");
			System.exit(0);
		}
		this.maxFreeTransaction = maxFreeTransaction;
	}
	
	public CheckingAccount(CheckingAccount originalObject){
		super(originalObject);
		maxFreeTransaction = originalObject.maxFreeTransaction;
	}
	
	public String toString(){
		return super.toString() + "\nMaximum number of free transactions: " + 
				maxFreeTransaction + "\nThe transaction fee: $" + TransactionFee + "\n";
	}
	
}
