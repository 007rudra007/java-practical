/**
 * Practical 4 - Program 2: Bank Account Management System
 *
 * Requirements:
 * Class: BankAccount
 * Data Members:
 *   - Account Number (long)
 *   - Account Holder Name (String)
 *   - Balance (double)
 * Constructors:
 *   - Default Constructor: Account Number = 0, Name = "Unknown", Balance = 0.0
 *   - Parameterized Constructor: Account Number, Holder Name, Opening Balance
 * Methods:
 *   - deposit(double amount)
 *   - withdraw(double amount)
 *   - displayBalance()
 *   - displayAccountDetails()
 */
class BankAccount {
    private long accountNumber;
    private String accountHolderName;
    private double balance;

    // 1. Default Constructor
    public BankAccount() {
        this.accountNumber = 0L;
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
    }

    // 2. Parameterized Constructor
    public BankAccount(long accountNumber, String accountHolderName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = (openingBalance >= 0) ? openingBalance : 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited ₹%.2f. New Balance: ₹%.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance! Withdrawal failed. Current Balance: ₹%.2f, Requested: ₹%.2f%n",
                    balance, amount);
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew ₹%.2f. Remaining Balance: ₹%.2f%n", amount, balance);
        }
    }

    // Display current balance
    public void displayBalance() {
        System.out.printf("Account #%d [%s] Current Balance: ₹%.2f%n",
                accountNumber, accountHolderName, balance);
    }

    // Display full account details
    public void displayAccountDetails() {
        System.out.println("----------------------------------------------");
        System.out.println("Account Number       : " + accountNumber);
        System.out.println("Account Holder Name  : " + accountHolderName);
        System.out.printf("Current Balance      : ₹%.2f%n", balance);
        System.out.println("----------------------------------------------");
    }

    // Getters and Setters for general use
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.2: Bank Account Management System    ");
        System.out.println("==================================================");

        // 1. Create one BankAccount object using default constructor
        System.out.println("\n--- Account 1: Created with Default Constructor ---");
        BankAccount acc1 = new BankAccount();
        acc1.displayAccountDetails();

        // 2. Create another BankAccount object using parameterized constructor
        System.out.println("\n--- Account 2: Created with Parameterized Constructor ---");
        BankAccount acc2 = new BankAccount(1001234567L, "Priya Sharma", 5000.0);
        acc2.displayAccountDetails();

        // 3. Perform deposit and withdrawal operations on acc2
        System.out.println("\n--- Performing Transactions on Account 2 ---");
        System.out.println("Action: Depositing ₹2500.00");
        acc2.deposit(2500.0);

        System.out.println("\nAction: Withdrawing ₹1200.00");
        acc2.withdraw(1200.0);

        System.out.println("\nAction: Attempting to withdraw ₹10,000.00 (Exceeding balance)");
        acc2.withdraw(10000.0);

        // 4. Display updated account details and current balance
        System.out.println("\n--- Updated Account 2 Details ---");
        acc2.displayAccountDetails();
        acc2.displayBalance();
    }
}
