/**
 * Practical 4 - Program 7: Digital Payment Gateway (Abstract Classes & Inheritance)
 *
 * Requirements:
 * 1. Abstract Class: Payment
 *    - Data member: double amount
 *    - Parameterized Constructor: initializes payment amount
 *    - Concrete Method: displayReceipt() prints basic transaction total
 *    - Abstract Method: void processPayment()
 * 2. Subclass: CryptoPayment (extends Payment)
 *    - Data member: String walletAddress
 *    - Parameterized Constructor: initializes amount and wallet address (using super)
 *    - Method Implementation: overrides processPayment() confirming secure blockchain transfer
 * 3. Main Method:
 *    - Create CryptoPayment object
 *    - Call displayReceipt()
 *    - Call processPayment()
 */

// 1. Abstract Base Class
abstract class Payment {
    protected double amount;

    // Parameterized constructor
    public Payment(double amount) {
        this.amount = amount;
    }

    // Concrete method to print receipt
    public void displayReceipt() {
        System.out.println("========== PAYMENT RECEIPT ==========");
        System.out.printf("Total Transaction Amount : ₹%.2f%n", amount);
        System.out.println("Status                   : Pending Processing");
        System.out.println("=====================================");
    }

    // Abstract method to be implemented by payment types
    public abstract void processPayment();
}

// 2. Concrete Subclass extending Payment
class CryptoPayment extends Payment {
    private String walletAddress;

    // Parameterized constructor initializing both amount and walletAddress
    public CryptoPayment(double amount, String walletAddress) {
        super(amount); // Call abstract superclass constructor
        this.walletAddress = walletAddress;
    }

    // Override abstract method processPayment()
    @Override
    public void processPayment() {
        System.out.println("\n[BLOCKCHAIN GATEWAY]: Processing cryptocurrency transfer...");
        System.out.printf(">> Transferred ₹%.2f securely to Wallet Address: %s%n", amount, walletAddress);
        System.out.println(">> Network Confirmation : 12 Confirmations [SUCCESS]");
        System.out.println(">> Blockchain Transaction ID: 0x7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069");
    }

    public String getWalletAddress() {
        return walletAddress;
    }
}

public class DigitalPaymentGateway {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 4.7: Digital Payment Gateway (Abstract)");
        System.out.println("==================================================");

        // 3. Create a CryptoPayment object
        double paymentAmount = 24999.50;
        String wallet = "0x71C...B29fA";

        CryptoPayment cryptoTx = new CryptoPayment(paymentAmount, wallet);

        // Call displayReceipt() to view the payment amount
        System.out.println("\nStep 1: Generating Transaction Receipt");
        cryptoTx.displayReceipt();

        // Call processPayment() to execute the transaction
        System.out.println("\nStep 2: Executing Payment Processing");
        cryptoTx.processPayment();
    }
}
