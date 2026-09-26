import java.util.Scanner;

/**
 * Practical 5 - Program 4: Interface for Bank Account
 *
 * Requirements:
 * Interface Account with methods:
 *   - deposit()
 *   - withdraw()
 *   - checkBalance()
 * Class SavingsAccount implements Account:
 *   - Accepts initial balance from user
 *   - Allows deposit, withdrawal, and balance enquiry operations
 */

// Interface Account
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// SavingsAccount Class implementing Account
class SavingsAccount implements Account {
    private long accountNumber;
    private String holderName;
    private double balance;

    // Minimum balance requirement for Savings Account
    private static final double MINIMUM_BALANCE = 500.0;

    public SavingsAccount(long accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(initialBalance, 0.0);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited ₹%.2f.%n", amount);
            checkBalance();
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.printf("Transaction Failed: Insufficient funds. Available: ₹%.2f, Requested: ₹%.2f%n",
                    balance, amount);
        } else if ((balance - amount) < MINIMUM_BALANCE) {
            System.out.printf("Warning: Maintaining a minimum balance of ₹%.2f is required. Current balance: ₹%.2f%n",
                    MINIMUM_BALANCE, balance);
            balance -= amount;
            System.out.printf("Successfully withdrew ₹%.2f (Account below minimum balance).%n", amount);
            checkBalance();
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew ₹%.2f.%n", amount);
            checkBalance();
        }
    }

    @Override
    public void checkBalance() {
        System.out.printf(">> Account #%d [%s] Available Balance: ₹%.2f%n",
                accountNumber, holderName, balance);
    }

    public void displayAccountInfo() {
        System.out.println("----------------------------------------------");
        System.out.println("Account Type   : Savings Account");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.printf("Current Balance: ₹%.2f%n", balance);
        System.out.println("----------------------------------------------");
    }
}

public class BankAccountInterfaceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 5.4: Bank Account Interface Demo       ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter Account Number: ");
            long accNum = sc.nextLong();
            sc.nextLine(); // consume newline

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Deposit Balance (₹): ");
            double initialBalance = sc.nextDouble();

            // Create SavingsAccount referenced through Account interface
            Account myAccount = new SavingsAccount(accNum, name, initialBalance);
            System.out.println("\nAccount initialized successfully!");
            myAccount.checkBalance();

            int choice;
            do {
                System.out.println("\n========== BANKING MENU ==========");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance Enquiry");
                System.out.println("4. Exit");
                System.out.print("Enter choice (1-4): ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit (₹): ");
                        double depAmt = sc.nextDouble();
                        myAccount.deposit(depAmt);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw (₹): ");
                        double withAmt = sc.nextDouble();
                        myAccount.withdraw(withAmt);
                        break;

                    case 3:
                        myAccount.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for banking with us. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter between 1 and 4.");
                        break;
                }
            } while (choice != 4);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
