package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CheckingAccount extends BankAccount{
	
	public void withdrawlLimited() {
		System.out.println("Enter account holder name for new Checking Accoount");
		String name =Main.sc.next();
		setAccountHolderName(name);
		
		System.out.println("Enter Account Number:");
		String accNumEntry = Main.sc.next();
		try {
			long accountNumber = Long.parseLong(accNumEntry);
			setAccountNumber(accountNumber);
		}
		catch (Exception e) {
			System.out.println("Enter valid number for Checking Account NUmber");
			return;
		}
		boolean repeatSubMenu = true;
		while(repeatSubMenu) {
		System.out.println("[1] Deposit");
		System.out.println("[2] Withdrawl limit");
		System.out.println("[3] Back");
		
		String action = Main.sc.next();
		switch(action) {
		case "1" :
			deposit();
			break;
		case "2" :
			System.out.println("Enter the Withdrawl Amount");
			String withdrawlAmountEntry = Main.sc.next();
			System.out.println("enter the limit fot withdrawl");
			String limitAmountEntry = Main.sc.next();
			try {
				double withdrawlAmountHolder1 = Double.parseDouble(withdrawlAmountEntry);
				setWithdrawAmount(withdrawlAmountHolder1);
				double limitAmount = Double.parseDouble(limitAmountEntry);
				if(withdrawlAmountHolder1 >= limitAmount || withdrawlAmountHolder1 > getBalance()) {
					System.out.println("You have no Balance or you just cross the limit ; Try Again");
				}
				else {
					double balanceUpdate1 = getBalance() - withdrawlAmountHolder1;
					setBalance(balanceUpdate1);
					setDepositedAmount(0);
			}
			}
			catch (Exception e) {
				System.out.println("Enter valid numder for Withdrawl Amount");
			}
			try {
				File file = new File("BankAccount.txt");
				FileWriter wr = new FileWriter(file,true);
				wr.write("Withdrawl limited update-------------------------------------------------------------------- \n");
				wr.write(String.format("%17s %17s %17s %17s %17s\n","Account Number","Account Holder Name","Balance","Deposite Amount","Withdraw Amount"));
				wr.write(String.format("%17s %17s %17s %17s %17s\n",getAccountNumber(),getAccountHolderName(),getBalance(),getDeposit(),getWithdraw()));
				wr.close();
			}
			catch (IOException e) {
				System.out.println("Error While Creating File.");
				e.getStackTrace();
			}
			break;
		case "3" :
			repeatSubMenu = false;
			break;
		}
		}
		
	}
}
