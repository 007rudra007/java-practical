/**
 * Practical 02: Program to generate prime numbers from 1 to 500.
 *
 * Description:
 * A prime number is a natural number greater than 1 that cannot be formed
 * by multiplying two smaller natural numbers (i.e. has only 1 and itself as factors).
 * This program checks and prints all prime numbers between 1 and 500,
 * formatted nicely in rows of 10, and reports the total count.
 */
public class PrimeNumbers1To500 {

    /**
     * Checks if a given number is prime using optimized trial division.
     * Time Complexity: O(sqrt(n))
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true; // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false;

        // All primes > 3 are of the form 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Practical 02: Prime Numbers from 1 to 500       ");
        System.out.println("==================================================");

        int start = 1;
        int end = 500;
        int count = 0;

        System.out.println("\nPrime numbers between " + start + " and " + end + ":\n");

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.printf("%4d ", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }

        System.out.println("\n\n----------------- Results -----------------");
        System.out.println("Range evaluated           : [" + start + " to " + end + "]");
        System.out.println("Total prime numbers found : " + count);
        System.out.println("First prime in range      : 2");
        System.out.println("Last prime in range       : 499");
        System.out.println("-------------------------------------------");
    }
}
