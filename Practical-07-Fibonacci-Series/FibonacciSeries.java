import java.util.Scanner;

/**
 * Practical 07: Display Fibonacci Series up to 'n' terms.
 *
 * Description:
 * The Fibonacci sequence is a sequence where each number is the sum of the
 * two preceding ones, usually starting with 0 and 1:
 * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n >= 2.
 *
 * Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         Practical 07: Fibonacci Series          ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of terms (n >= 1): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
                return;
            }

            long[] fib = new long[n];
            long sum = 0;

            if (n >= 1) fib[0] = 0;
            if (n >= 2) fib[1] = 1;

            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }

            System.out.println("\n----------------- Fibonacci Series -----------------");
            System.out.println("Displaying first " + n + " terms:\n");

            for (int i = 0; i < n; i++) {
                System.out.print(fib[i] + (i == n - 1 ? "" : ", "));
                sum += fib[i];
                if ((i + 1) % 10 == 0 && i != n - 1) {
                    System.out.println();
                }
            }

            System.out.println("\n\n----------------- Summary --------------------------");
            System.out.println("Total terms displayed : " + n);
            System.out.println("First term (F0)       : " + fib[0]);
            System.out.println("Last term (F" + (n - 1) + ")      : " + fib[n - 1]);
            System.out.println("Sum of series terms   : " + sum);
            System.out.println("----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid positive integer.");
        } finally {
            scanner.close();
        }
    }
}
