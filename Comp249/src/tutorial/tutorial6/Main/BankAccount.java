package tutorial.tutorial6.Main;

import tutorial.tutorial6.Exception.*;


public class BankAccount {
	private String name;
	private double balance;
	private final static double depositLimit = 500;
	private final static double withdrawLimit = 500;
	
	/**
	 * @param name
	 * @param balance
	 */
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public BankAccount(String name){
		this(name, 0);
	}
	
	public double getbalance(){
		return balance;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name:" + name + "\n" + "balance: " + balance;
	}
	
	public void deposit(double depositAmount) throws InvalidAmountException, DepositLimitException{
		if(depositAmount<0)
			throw new InvalidAmountException();
		
		if(depositAmount >depositLimit)
			throw new DepositLimitException();
		
		balance += depositAmount; 
	}
	
	public void withdraw(double withdrawAmount) 
			throws InvalidAmountException, WithdrawLimitException, NotEnoughBalanceException {
		if(withdrawAmount<0)
			throw new InvalidAmountException();
		if(withdrawAmount>withdrawLimit)
			throw new WithdrawLimitException();
		if(withdrawAmount>balance)
			throw new NotEnoughBalanceException();
		balance -= withdrawAmount;
		
	}
	
	
	
}
