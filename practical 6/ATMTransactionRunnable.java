/**
 * Practical 6 - Program 5:
 * Simulate ATM Transaction using two threads via the Runnable interface and Thread.sleep().
 *
 * Thread 1: ATM Transaction Steps: Card Inserted → PIN Verified → Transaction Processing.
 * Thread 2: Account Notifications: Checking Balance → Amount Debited → SMS Sent.
 */

// Thread 1: Simulating ATM hardware steps
class ATMTransactionStep implements Runnable {
    @Override
    public void run() {
        String[] steps = {
            "Card Inserted",
            "PIN Verified",
            "Transaction Processing"
        };

        for (String step : steps) {
            System.out.println("[ATM Thread]        : " + step);
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                System.out.println("ATM Thread interrupted: " + e.getMessage());
            }
        }
    }
}

// Thread 2: Simulating backend notification and account update steps
class AccountNotificationStep implements Runnable {
    @Override
    public void run() {
        String[] notifications = {
            "Checking Balance",
            "Amount Debited",
            "SMS Sent"
        };

        for (String notif : notifications) {
            System.out.println("[Notification Thread]: " + notif);
            try {
                Thread.sleep(1200); // 1.2 second delay
            } catch (InterruptedException e) {
                System.out.println("Notification Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class ATMTransactionRunnable {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.5: ATM Simulation (Runnable Threads) ");
        System.out.println("==================================================");

        // Instantiate Runnable tasks
        ATMTransactionStep atmTask = new ATMTransactionStep();
        AccountNotificationStep notifTask = new AccountNotificationStep();

        // Create Thread objects
        Thread thread1 = new Thread(atmTask, "ATM-Process-Thread");
        Thread thread2 = new Thread(notifTask, "Notification-Thread");

        System.out.println("Starting concurrent ATM simulation...\n");

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\nAll ATM transaction and notification steps completed successfully.");
    }
}
