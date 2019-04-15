package lab;

public class BankAcountDemo {

	public static void main(String[] args) {
		BankAccount[] accounts = new BankAccount[2];
		accounts[0] = new SavingAccount(061, "person1", 100.5, 2);
		accounts[1] = new CheckingAccount(456, "person2", 200.5, 5);
		for(int i =0; i<accounts.length; i++){
			System.out.println(accounts[i]);
		}
	}

}
