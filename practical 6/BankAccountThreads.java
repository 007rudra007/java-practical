/**
 * Practical 6 - Program 6:
 * Simple Bank Account Application using the Thread class:
 * - Account
 * - Deposit thread
 * - Withdraw thread
 */

// Shared Account class
class ThreadAccount {
    private double balance;

    public ThreadAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        System.out.printf("[%s] Attempting to deposit: ₹%.2f%n", Thread.currentThread().getName(), amount);
        balance += amount;
        System.out.printf("[%s] Deposit complete. Current Balance: ₹%.2f%n", Thread.currentThread().getName(), balance);
    }

    public void withdraw(double amount) {
        System.out.printf("[%s] Attempting to withdraw: ₹%.2f%n", Thread.currentThread().getName(), amount);
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("[%s] Withdrawal successful. Remaining Balance: ₹%.2f%n", Thread.currentThread().getName(), balance);
        } else {
            System.out.printf("[%s] Insufficient funds! Current: ₹%.2f, Requested: ₹%.2f%n",
                    Thread.currentThread().getName(), balance, amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Deposit Thread extending Thread
class DepositThread extends Thread {
    private ThreadAccount account;
    private double amount;

    public DepositThread(ThreadAccount account, double amount) {
        super("Deposit-Thread");
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500); // Simulate processing time
            account.deposit(amount);
        } catch (InterruptedException e) {
            System.out.println("Deposit thread interrupted: " + e.getMessage());
        }
    }
}

// Withdraw Thread extending Thread
class WithdrawThread extends Thread {
    private ThreadAccount account;
    private double amount;

    public WithdrawThread(ThreadAccount account, double amount) {
        super("Withdraw-Thread");
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500); // Simulate processing time
            account.withdraw(amount);
        } catch (InterruptedException e) {
            System.out.println("Withdraw thread interrupted: " + e.getMessage());
        }
    }
}

public class BankAccountThreads {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.6: Bank Account using Thread Class   ");
        System.out.println("==================================================");

        ThreadAccount account = new ThreadAccount(10000.0);
        System.out.printf("Initial Account Balance: ₹%.2f%n%n", account.getBalance());

        // Create threads
        DepositThread depThread = new DepositThread(account, 5000.0);
        WithdrawThread withThread = new WithdrawThread(account, 3000.0);

        // Start threads
        depThread.start();
        withThread.start();

        try {
            depThread.join();
            withThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.printf("%nFinal Account Balance: ₹%.2f%n", account.getBalance());
    }
}
