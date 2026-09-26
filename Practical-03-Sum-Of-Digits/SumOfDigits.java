import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Practical 03: Find the sum of the digits of a number.
 * Example: 123 -> 1 + 2 + 3 = 6
 *
 * Description:
 * Extracts each digit from right to left using the modulo operator (number % 10)
 * and accumulates the sum until the number reduces to 0 (number / 10).
 */
public class SumOfDigits {

    /**
     * Calculates the sum of digits of a given number.
     *
     * @param num the input integer
     * @return sum of its digits
     */
    public static long calculateSumOfDigits(long num) {
        long temp = Math.abs(num);
        long sum = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += digit;
            temp /= 10;
        }

        return sum;
    }

    /**
     * Extracts digits in left-to-right order for detailed step-by-step explanation.
     */
    public static List<Long> getDigitsList(long num) {
        List<Long> digits = new ArrayList<>();
        long temp = Math.abs(num);

        if (temp == 0) {
            digits.add(0L);
            return digits;
        }

        while (temp > 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      Practical 03: Sum of Digits of a Number     ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer number (e.g., 123): ");
            long number = scanner.nextLong();

            long sum = calculateSumOfDigits(number);
            List<Long> digits = getDigitsList(number);

            System.out.println("\n----------------- Results -----------------");
            System.out.println("Input Number       : " + number);
            System.out.print("Digit Breakdown    : ");
            for (int i = 0; i < digits.size(); i++) {
                System.out.print(digits.get(i) + (i == digits.size() - 1 ? "" : " + "));
            }
            System.out.println(" = " + sum);
            System.out.println("Sum of Digits      : " + sum);
            System.out.println("-------------------------------------------");
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer number.");
        } finally {
            scanner.close();
        }
    }
}
