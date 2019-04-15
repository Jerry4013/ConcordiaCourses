package lab;

public class SavingAccount extends BankAccount{
	private int rate;
	
	public SavingAccount(){
		super();
	}
	
	public SavingAccount(int number, String name, double balance, int rate){
		super(number, name, balance);
		this.rate = rate;
	}
	
	public SavingAccount(SavingAccount anotherSavingAccount){
		super(anotherSavingAccount);
		rate = anotherSavingAccount.rate;
	}
	
	public String toString(){
		return super.toString() + "\nInterest Rate: " + rate + "\n";
	}
	
}
