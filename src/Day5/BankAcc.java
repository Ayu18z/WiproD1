package Day5;

import java.util.Scanner;

public class BankAcc {
//Create a BankAccount class with private fields for account holder's name, account number, and balance.
//Implement methods to deposit and withdraw money with proper validation (e.g., no overdraft, positive amounts only).
//Provide getters and setters for the account holder's name and account number, but encapsulate the balance to be modified only through deposit and withdraw methods.
//Include a method to display account details.

	
	static class BankAccountDetails{
		public long accountNo ;
		private String Name;
		private double Balance;
	

	public BankAccountDetails() {
		this.accountNo = accountNo;
		this.Balance = 0.0;
		this.Name = Name;
	}
			
				public long getAccountNo() {
					return accountNo;
				}

				public void setAccountNo(long accountNo) {
					this.accountNo = accountNo;
				}

				public String getName() {
					return Name;
				}

				public void setName(String name) {
					Name = name;
				}
				
				
		public void deposit(double Amount) {	//		<------ //new amount 
			if(Amount>0) {
				Balance += Amount;
			}else {
				System.out.println("enter a +ve number");
			}
		}
		
		public void Withdraw(double Amount) {	//		<------ //new amount 
			if(Amount>0 && Amount<= Balance) {
				Balance -= Amount;
			}else {
				System.out.println("enter a valid Amount");
			}
		}
		
		
		
				
				

		static void input(long accountNo, String Name) {
			Scanner s = new Scanner(System.in);
			accountNo = s.nextInt();
			Name = s.nextLine();
				
					
			}
			
			
	
	}
	
public static void main(String[] args) {
	
	
	
}
}
