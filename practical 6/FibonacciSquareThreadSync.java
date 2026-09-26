/**
 * Practical 6 - Program 9:
 * Shared Fibonacci Sequence & Square Calculation using Two Synchronized Threads.
 *
 * Requirements:
 * 1. FibonacciThread: Generates Fibonacci numbers (index 0 to 20).
 * 2. SquareThread: Calculates and displays the square of each generated number.
 * 3. Uses the 'synchronized' keyword with wait() and notify() for safe producer-consumer coordination.
 */

// Shared container coordinating the two threads
class SharedFibonacciBuffer {
    private long currentNumber;
    private int currentIndex;
    private boolean isProduced = false;
    private boolean isFinished = false;

    // Called by FibonacciThread (Producer)
    public synchronized void produce(int index, long number) {
        while (isProduced) {
            try {
                wait(); // Wait for SquareThread to consume current number
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.currentIndex = index;
        this.currentNumber = number;
        this.isProduced = true;

        System.out.printf("[FibonacciThread]: F(%2d) = %-6d", currentIndex, currentNumber);
        notify(); // Notify SquareThread to calculate square
    }

    // Called by SquareThread (Consumer)
    public synchronized void consumeAndSquare() {
        while (!isProduced && !isFinished) {
            try {
                wait(); // Wait until FibonacciThread generates a number
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (isFinished && !isProduced) {
            return;
        }

        long square = currentNumber * currentNumber;
        System.out.printf("  -->  [SquareThread]: Square = %d%n", square);

        this.isProduced = false;
        notify(); // Notify FibonacciThread to generate the next number
    }

    // Mark completion of production
    public synchronized void setFinished() {
        this.isFinished = true;
        notifyAll();
    }

    public synchronized boolean isFinished() {
        return isFinished && !isProduced;
    }
}

// Thread 1: Generates Fibonacci numbers from index 0 to 20
class FibonacciThread extends Thread {
    private SharedFibonacciBuffer buffer;
    private int maxIndex;

    public FibonacciThread(SharedFibonacciBuffer buffer, int maxIndex) {
        super("Fibonacci-Producer");
        this.buffer = buffer;
        this.maxIndex = maxIndex;
    }

    @Override
    public void run() {
        long a = 0;
        long b = 1;

        for (int i = 0; i <= maxIndex; i++) {
            long fib;
            if (i == 0) {
                fib = 0;
            } else if (i == 1) {
                fib = 1;
            } else {
                fib = a + b;
                a = b;
                b = fib;
            }

            buffer.produce(i, fib);

            try {
                Thread.sleep(150); // Small delay to clearly observe step-by-step processing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        buffer.setFinished();
    }
}

// Thread 2: Calculates and displays the square of each Fibonacci number
class SquareThread extends Thread {
    private SharedFibonacciBuffer buffer;

    public SquareThread(SharedFibonacciBuffer buffer) {
        super("Square-Consumer");
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!buffer.isFinished()) {
            buffer.consumeAndSquare();
        }
    }
}

public class FibonacciSquareThreadSync {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println(" Practical 6.9: Synchronized Fibonacci & Square Threads        ");
        System.out.println("===============================================================");
        System.out.println("Generating Fibonacci numbers from F(0) to F(20) with Squares:\n");

        SharedFibonacciBuffer sharedBuffer = new SharedFibonacciBuffer();

        FibonacciThread fibThread = new FibonacciThread(sharedBuffer, 20);
        SquareThread sqThread = new SquareThread(sharedBuffer);

        // Start both synchronized threads
        fibThread.start();
        sqThread.start();

        try {
            fibThread.join();
            sqThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("All 21 Fibonacci numbers and squares calculated consistently!");
        System.out.println("---------------------------------------------------------------");
    }
}
