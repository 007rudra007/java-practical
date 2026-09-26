/**
 * Practical 6 - Program 7:
 * Assign different priorities to Deposit and Withdraw threads and observe execution order.
 *
 * Priorities in Java:
 *   Thread.MIN_PRIORITY  = 1
 *   Thread.NORM_PRIORITY = 5
 *   Thread.MAX_PRIORITY  = 10
 */
class PriorityAccount {
    private double balance;

    public PriorityAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        System.out.printf("[%s | Priority: %d] Deposited ₹%.2f. New Balance: ₹%.2f%n",
                Thread.currentThread().getName(), Thread.currentThread().getPriority(), amount, (balance + amount));
        balance += amount;
    }

    public void withdraw(double amount) {
        System.out.printf("[%s | Priority: %d] Withdrew ₹%.2f. New Balance: ₹%.2f%n",
                Thread.currentThread().getName(), Thread.currentThread().getPriority(), amount, (balance - amount));
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class PriorityDepositThread extends Thread {
    private PriorityAccount account;
    private double amount;

    public PriorityDepositThread(PriorityAccount account, double amount) {
        super("Deposit-Thread-HighPriority");
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}

class PriorityWithdrawThread extends Thread {
    private PriorityAccount account;
    private double amount;

    public PriorityWithdrawThread(PriorityAccount account, double amount) {
        super("Withdraw-Thread-LowPriority");
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class ThreadPriorityBankDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.7: Thread Priority Demonstration     ");
        System.out.println("==================================================");

        PriorityAccount account = new PriorityAccount(15000.0);
        System.out.printf("Initial Balance: ₹%.2f%n%n", account.getBalance());

        // Create threads
        PriorityDepositThread depositThread = new PriorityDepositThread(account, 5000.0);
        PriorityWithdrawThread withdrawThread = new PriorityWithdrawThread(account, 4000.0);

        // Assign different priorities
        depositThread.setPriority(Thread.MAX_PRIORITY); // Priority 10
        withdrawThread.setPriority(Thread.MIN_PRIORITY); // Priority 1

        System.out.println("Assigned Priorities:");
        System.out.println("  " + depositThread.getName() + " -> Priority: " + depositThread.getPriority() + " (MAX_PRIORITY)");
        System.out.println("  " + withdrawThread.getName() + " -> Priority: " + withdrawThread.getPriority() + " (MIN_PRIORITY)");

        System.out.println("\nStarting threads simultaneously...\n");
        // Start both threads
        withdrawThread.start();
        depositThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("\n--- Observation on Thread Priorities ---");
        System.out.println("1. Thread priority provides a scheduling hint to the underlying OS Thread Scheduler.");
        System.out.println("2. While higher priority threads generally receive more CPU time, the OS scheduler");
        System.out.println("   does not guarantee deterministic execution order across operating systems.");
        System.out.printf("Final Account Balance: ₹%.2f%n", account.getBalance());
        System.out.println("--------------------------------------------------");
    }
}
