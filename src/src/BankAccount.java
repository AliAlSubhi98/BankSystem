package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BankAccount {
	private long accountNumber;
	private String accountHolderName;
	private double balance ;
	private double depositedAmount=0;
	private double withdrawAmount=0;
	double amount;
	public BankAccount() { // this called constructor
		System.out.println("WELCOME TO ALSUBHI BANK");
	}
	//---------------------------------------------------------------------
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	//---------------------------------------------------------------------

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}
	//---------------------------------------------------------------------

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	//---------------------------------------------------------------------
	public void setDepositedAmount(double depositedAmount) {
		this.depositedAmount = depositedAmount;
}
	public double getDeposit() {
		return depositedAmount;
	}
	//---------------------------------------------------------------------
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	public double getWithdraw() {
		return withdrawAmount;
	}
	
	//---------------------------------------------------------------------
	public void deposit() {
		System.out.println("Enter the Deposit Amount:");
		String depositAmountEntry = Main.sc.next();
		try {
		double depositeAmountHolder1 = Double.parseDouble(depositAmountEntry);
		setDepositedAmount(depositeAmountHolder1);
		double balanceUpdate = getBalance()+ depositeAmountHolder1;
		setBalance(balanceUpdate);
		setWithdrawAmount(0);
		}
		catch (Exception e) {
			System.out.println("Deposite Holder : Enter valid number");
		}
		try {
			File file = new File("BankAccount.txt");
			FileWriter wr = new FileWriter(file,true);
			wr.write("Deposite update----------------------------------------------------------------------------- \n");
			wr.write(String.format("%17s %17s %17s %17s %17s\n","Account Number","Account Holder Name","Balance","Deposite Amount","Withdraw Amount"));
			wr.write(String.format("%17s %17s %17s %17s %17s\n",getAccountNumber(),getAccountHolderName(),getBalance(),getDeposit(),getWithdraw()));
			wr.close();
		}
		catch (IOException e) {
			System.out.println("Error While Creating File.");
			e.getStackTrace();
		}
	}
	//-----------------------------------------------------------------------
	public void withdraw() {
		System.out.println("Enter the Withdrawl Amount");
		String withdrawlAmountEntry = Main.sc.next();
		try {
			double withdrawlAmountHolder1 = Double.parseDouble(withdrawlAmountEntry);
			setWithdrawAmount(withdrawlAmountHolder1);
			double balanceUpdate1 = getBalance() - withdrawlAmountHolder1;
			setBalance(balanceUpdate1);
			setDepositedAmount(0);
		}
		catch (Exception e) {
			System.out.println("Enter valid numder for Withdrawl Amount");
		}
		try {
			File file = new File("BankAccount.txt");
			FileWriter wr = new FileWriter(file,true);
			wr.write("Withdrawl update---------------------------------------------------------------------------- \n");
			wr.write(String.format("%17s %17s %17s %17s %17s\n","Account Number","Account Holder Name","Balance","Deposite Amount","Withdraw Amount"));
			wr.write(String.format("%17s %17s %17s %17s %17s\n",getAccountNumber(),getAccountHolderName(),getBalance(),getDeposit(),getWithdraw()));
			wr.close();
		}
		catch (IOException e) {
			System.out.println("Error While Creating File.");
			e.getStackTrace();
		}
	}
}
