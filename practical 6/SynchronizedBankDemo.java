/**
 * Practical 6 - Program 8:
 * Synchronization in Bank Account Application.
 *
 * Uses the 'synchronized' keyword on deposit() and withdraw() methods
 * to ensure mutual exclusion, preventing race conditions and inconsistent balance.
 */
class SynchronizedAccount {
    private double balance;

    public SynchronizedAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        System.out.printf("[%s] Processing deposit of ₹%.2f...%n", Thread.currentThread().getName(), amount);
        double temp = balance;
        try {
            Thread.sleep(300); // Simulate processing latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        balance = temp + amount;
        System.out.printf("[%s] Deposit complete. New Balance: ₹%.2f%n", Thread.currentThread().getName(), balance);
    }

    // Synchronized withdraw method
    public synchronized void withdraw(double amount) {
        System.out.printf("[%s] Processing withdrawal of ₹%.2f...%n", Thread.currentThread().getName(), amount);
        if (balance >= amount) {
            double temp = balance;
            try {
                Thread.sleep(300); // Simulate processing latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance = temp - amount;
            System.out.printf("[%s] Withdrawal complete. Remaining Balance: ₹%.2f%n", Thread.currentThread().getName(), balance);
        } else {
            System.out.printf("[%s] Insufficient funds! Balance: ₹%.2f, Requested: ₹%.2f%n",
                    Thread.currentThread().getName(), balance, amount);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

public class SynchronizedBankDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.8: Synchronized Bank Account Threads ");
        System.out.println("==================================================");

        SynchronizedAccount account = new SynchronizedAccount(10000.0);
        System.out.printf("Starting Account Balance: ₹%.2f%n%n", account.getBalance());

        // Thread 1: Deposit ₹5,000
        Thread t1 = new Thread(() -> {
            account.deposit(5000.0);
        }, "Depositor-1");

        // Thread 2: Withdraw ₹3,000
        Thread t2 = new Thread(() -> {
            account.withdraw(3000.0);
        }, "Withdrawer-1");

        // Thread 3: Deposit ₹2,000
        Thread t3 = new Thread(() -> {
            account.deposit(2000.0);
        }, "Depositor-2");

        // Start all threads concurrently
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n----------------- Final State -----------------");
        System.out.printf("All synchronized transactions completed safely.%n");
        System.out.printf("Consistent Final Balance: ₹%.2f%n", account.getBalance());
        System.out.println("-----------------------------------------------");
    }
}
