import java.util.Scanner;

/**
 * Practical 6 - Program 4:
 * Bank Account System with explicit 'throw' statement.
 * If withdrawal amount > balance, throw IllegalArgumentException("Insufficient balance").
 *
 * Example:
 *   Balance = ₹10,000
 *   Withdrawal = ₹12,000
 *   Output: Insufficient balance
 */
public class BankWithdrawalThrowDemo {

    public static void withdraw(double balance, double withdrawalAmount) {
        if (withdrawalAmount > balance) {
            // Using explicit throw statement as requested
            throw new IllegalArgumentException("Insufficient balance");
        } else if (withdrawalAmount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount. Must be greater than 0.");
        } else {
            double remaining = balance - withdrawalAmount;
            System.out.printf("Withdrawal of ₹%.2f successful! Remaining balance: ₹%.2f%n", withdrawalAmount, remaining);
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.4: Bank Withdrawal with 'throw'      ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Account Holder Name: ");
            String accountHolder = scanner.nextLine();

            double currentBalance = 10000.00;
            System.out.printf("Current Available Balance : ₹%.2f%n", currentBalance);

            System.out.print("Enter Withdrawal Amount: ");
            double withdrawal = scanner.nextDouble();

            System.out.println("\nProcessing withdrawal for " + accountHolder + "...");
            // Call withdraw method which may throw IllegalArgumentException
            withdraw(currentBalance, withdrawal);

        } catch (IllegalArgumentException e) {
            // Catching and displaying the error message
            System.out.println("\nOutput: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Transaction attempt completed.");
        }
    }
}
