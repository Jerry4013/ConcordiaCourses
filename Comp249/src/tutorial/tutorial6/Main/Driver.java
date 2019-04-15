package tutorial.tutorial6.Main;

import tutorial.tutorial6.Exception.*;

public class Driver {

	public static void main(String[] args) {
		BankAccount b = new BankAccount("deposit",1000);
		
		try{
			b.deposit(-1);
			b.deposit(501);
		}catch(InvalidAmountException e){
			System.out.println("Invalid Amount");
		}catch(DepositLimitException e){
			System.out.println("Deposit limit Exception");
		}finally{
			System.out.println("Executed\"finally\" ");
		}
	}

}
