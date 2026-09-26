import java.util.Scanner;

/**
 * Practical 4 - Program 3: Bank Account Management System for 5 Customers
 * using an Array of Objects.
 *
 * Requirements:
 * Implement Bank Account Management for 5 customers using an array of objects.
 * Demonstrate creation, display, transactions, and search on the array.
 */
class CustomerAccount {
    private long accountNumber;
    private String customerName;
    private double balance;

    // Constructors
    public CustomerAccount() {
        this.accountNumber = 0L;
        this.customerName = "Unknown";
        this.balance = 0.0;
    }

    public CustomerAccount(long accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited ₹%.2f. Updated Balance: ₹%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance! Current: ₹%.2f, Requested: ₹%.2f%n", balance, amount);
        } else {
            balance -= amount;
            System.out.printf("Withdrew ₹%.2f. Updated Balance: ₹%.2f%n", amount, balance);
        }
    }

    public void displayDetails() {
        System.out.printf("%-16d %-22s ₹%-14.2f%n", accountNumber, customerName, balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankCustomersArray {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.3: Bank System for 5 Customers       ");
        System.out.println("==================================================");

        // Array of 5 CustomerAccount objects
        CustomerAccount[] customers = new CustomerAccount[5];

        // Initialize 5 customer accounts
        customers[0] = new CustomerAccount(100101L, "Rohit Sharma", 15000.00);
        customers[1] = new CustomerAccount(100102L, "Ananya Roy", 28500.50);
        customers[2] = new CustomerAccount(100103L, "Vikram Malhotra", 9200.00);
        customers[3] = new CustomerAccount(100104L, "Neha Verma", 45000.75);
        customers[4] = new CustomerAccount(100105L, "Karan Singh", 12300.00);

        // Display all 5 customer accounts
        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-16s %-22s %-15s%n", "Account Number", "Account Holder", "Balance");
        System.out.println("------------------------------------------------------------");
        for (CustomerAccount acc : customers) {
            acc.displayDetails();
        }
        System.out.println("------------------------------------------------------------");

        // Perform sample transactions on selected customers
        System.out.println("\n--- Performing Transactions ---");
        System.out.println("1. Depositing ₹5,000 into Account #100103 (Vikram Malhotra):");
        customers[2].deposit(5000.00);

        System.out.println("\n2. Withdrawing ₹3,500 from Account #100102 (Ananya Roy):");
        customers[1].withdraw(3500.00);

        System.out.println("\n3. Attempting to withdraw ₹50,000 from Account #100105 (Karan Singh):");
        customers[4].withdraw(50000.00);

        // Search customer by Account Number
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Account Number to search (e.g. 100104): ");
        if (sc.hasNextLong()) {
            long searchAcc = sc.nextLong();
            boolean found = false;

            for (CustomerAccount acc : customers) {
                if (acc.getAccountNumber() == searchAcc) {
                    System.out.println("\nCustomer Found:");
                    System.out.println("  Account Number : " + acc.getAccountNumber());
                    System.out.println("  Holder Name    : " + acc.getCustomerName());
                    System.out.printf("  Current Balance: ₹%.2f%n", acc.getBalance());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Customer with Account Number " + searchAcc + " not found.");
            }
        }
        sc.close();

        // Customer with highest balance
        CustomerAccount highest = customers[0];
        for (int i = 1; i < customers.length; i++) {
            if (customers[i].getBalance() > highest.getBalance()) {
                highest = customers[i];
            }
        }
        System.out.println("\n------------------------------------------------------------");
        System.out.printf("Customer with Highest Balance: %s (#%d) with ₹%.2f%n",
                highest.getCustomerName(), highest.getAccountNumber(), highest.getBalance());
        System.out.println("------------------------------------------------------------");
    }
}
