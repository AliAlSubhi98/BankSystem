package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
static Scanner sc = new Scanner(System.in);
static SavingsAccount newBankAccount = new SavingsAccount();
static CheckingAccount newObj = new CheckingAccount();

	public static void main(String[] args) throws IOException {
		boolean repeat =true;
		while(repeat) {
			
			System.out.println("_______Menu________");
			System.out.println("[1] New Saving Account.");
			System.out.println("[2] Deposit.");
			System.out.println("[3] Withdrawl.");
			System.out.println("[4] New Checking Account - withdrawl  limited.");
			System.out.println("[5] Calculate Interest of Saving Account.");
			System.out.println("[6] Exit.");
			System.out.println("___________________");
			System.out.println("choose:");
			String choose = sc.next();
			switch(choose) {
			case "1" :
				boolean case1Loop =true;
				while(case1Loop) {
					System.out.println("Enter the account Hodler name:");
					String name = sc.next();
					newBankAccount.setAccountHolderName(name);
					
					System.out.println("Enter Account Number:");
					String accNumberEntry = sc.next();
					try {
						long accountNumber = Long.parseLong(accNumberEntry);
						newBankAccount.setAccountNumber(accountNumber);
					}
					catch (Exception e) {
						System.out.println("enter valid account number.");
					}
					try {
						File file = new File("BankAccount.txt");
						FileWriter wr = new FileWriter(file,true);
						wr.write(String.format("%17s %17s %17s %17s %17s\n","Account Number","Account Holder Name","Balance","Deposite Amount","Withdraw Amount"));
						wr.write(String.format("%17s %17s %17s %17s %17s\n",newBankAccount.getAccountNumber(),newBankAccount.getAccountHolderName(),newBankAccount.getBalance(),newBankAccount.getDeposit(),newBankAccount.getWithdraw()));
						wr.close();
					}
					catch (IOException e) {
						System.out.println("Error While Creating File.");
						e.getStackTrace();
					}
					case1Loop=false;
				}
				break;
			case "2" :
				newBankAccount.deposit();
				break;
			case "3" :
				newBankAccount.withdraw();
				break;
			case "4" :
				newObj.withdrawlLimited();
				break;
			case "5" :
				
				System.out.println(newBankAccount.CalculateInterest());
				break;
			case "6" :
				System.out.println("GoodBye.");
				repeat=false;
				break;
			default: System.out.println("Choose Valid Number From MENU. ");
			}
		}
	}
}
