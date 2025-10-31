package Day5;

public class bacnkac2 {


    static class BankAccount {
        private String accountHolderName;
        private String accountNumber;
        private double balance;

        // Constructor
        public BankAccount(String accountHolderName, String accountNumber) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            this.balance = 0.0;
        }

        // Getters & Setters
        public String getAccountHolderName() {
            return accountHolderName;
        }

        public void setAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        // Deposit method
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Withdraw method
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
                System.out.println("Available Balance: " + balance);
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        }

        // Display account info
        public void displayAccountDetails() {
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

    // ✅ Main Method — runs the program
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Veda", "123456789");

        account.displayAccountDetails();
        System.out.println();

        account.deposit(25000);
        account.withdraw(20000);
        System.out.println();

        account.withdraw(6000);
        System.out.println();

        account.displayAccountDetails();
    }
}
