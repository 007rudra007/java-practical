import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Practical 04: Check whether a given number is an Armstrong number.
 *
 * Description:
 * An Armstrong (or Narcissistic) number of 'n' digits is an integer such that
 * the sum of its digits raised to the power 'n' is equal to the number itself.
 * Examples:
 *   153 (3 digits)  : 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153  --> Armstrong
 *   1634 (4 digits) : 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634 --> Armstrong
 *   123 (3 digits)  : 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36 != 123 --> Not Armstrong
 */
public class ArmstrongNumber {

    /**
     * Checks if a number is an Armstrong number.
     */
    public static boolean isArmstrong(long number) {
        if (number < 0) return false;
        if (number == 0) return true;

        int numDigits = String.valueOf(number).length();
        long temp = number;
        long sum = 0;

        while (temp > 0) {
            long digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         Practical 04: Check Armstrong Number     ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a positive integer number (e.g., 153 or 1634): ");
            long number = scanner.nextLong();

            if (number < 0) {
                System.out.println("Please enter a non-negative integer.");
                return;
            }

            int numDigits = String.valueOf(number).length();
            List<Long> digits = new ArrayList<>();
            long temp = number;

            if (temp == 0) {
                digits.add(0L);
            } else {
                while (temp > 0) {
                    digits.add(temp % 10);
                    temp /= 10;
                }
                Collections.reverse(digits);
            }

            long sum = 0;
            StringBuilder formula = new StringBuilder();
            StringBuilder values = new StringBuilder();

            for (int i = 0; i < digits.size(); i++) {
                long d = digits.get(i);
                long p = (long) Math.pow(d, numDigits);
                sum += p;

                formula.append(d).append("^").append(numDigits);
                values.append(p);

                if (i < digits.size() - 1) {
                    formula.append(" + ");
                    values.append(" + ");
                }
            }

            System.out.println("\n----------------- Results -----------------");
            System.out.println("Input Number       : " + number);
            System.out.println("Number of Digits   : " + numDigits);
            System.out.println("Formula Expression : " + formula.toString());
            System.out.println("Calculation        : " + values.toString() + " = " + sum);

            if (sum == number) {
                System.out.println("Conclusion         : " + number + " is an ARMSTRONG NUMBER! [Yes]");
            } else {
                System.out.println("Conclusion         : " + number + " is NOT an Armstrong number. [No]");
            }
            System.out.println("-------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
