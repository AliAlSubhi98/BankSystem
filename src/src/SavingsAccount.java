package src;

public class SavingsAccount extends BankAccount {
	double time;
	double rate;
	public double CalculateInterest() {//functionality
		try {
			System.out.println("Enter The Rate to calculate the interest");
			this.rate=Main.sc.nextDouble();
			System.out.println("Enter The Time to calculate the interest");
			this.time=Main.sc.nextDouble();
		}
		catch (Exception e) {
		}
		double interest = getBalance() * rate * time;
		return interest;
	}
	public void printInterest() {
		System.out.println(CalculateInterest());
	}
}
