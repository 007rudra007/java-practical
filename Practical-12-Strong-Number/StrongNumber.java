import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Practical 12: Program to accept any number from command prompt & check whether
 * it is a Strong number.
 *
 * Description:
 * A Strong number (also known as a Krishnamurthy or Peterson number) is a number
 * where the sum of factorials of each individual digit is equal to the number itself.
 * Example:
 *   145 = 1! + 4! + 5! = 1 + 24 + 120 = 145 --> Strong Number
 *   40585 = 4! + 0! + 5! + 8! + 5! = 24 + 1 + 120 + 40320 + 120 = 40585 --> Strong Number
 *
 * Input:
 * Accepts number directly from Command Prompt arguments (args[0]).
 * If no argument is provided on CLI, prompts interactively via Scanner.
 */
public class StrongNumber {

    /**
     * Precomputed factorials for digits 0 through 9:
     * 0! = 1, 1! = 1, 2! = 2, 3! = 6, 4! = 24, 5! = 120, 6! = 720, 7! = 5040, 8! = 40320, 9! = 362880
     */
    private static final long[] FACTORIALS = {
        1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880
    };

    public static long factorial(int d) {
        if (d >= 0 && d <= 9) return FACTORIALS[d];
        long f = 1;
        for (int i = 2; i <= d; i++) f *= i;
        return f;
    }

    public static void checkAndDisplay(long number) {
        if (number <= 0) {
            System.out.println("Strong numbers are positive integers. Input: " + number);
            return;
        }

        long temp = number;
        List<Long> digits = new ArrayList<>();
        while (temp > 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(digits);

        long sumOfFactorials = 0;
        StringBuilder factorialExp = new StringBuilder();
        StringBuilder valuesExp = new StringBuilder();

        for (int i = 0; i < digits.size(); i++) {
            int d = digits.get(i).intValue();
            long fact = factorial(d);
            sumOfFactorials += fact;

            factorialExp.append(d).append("!");
            valuesExp.append(fact);

            if (i < digits.size() - 1) {
                factorialExp.append(" + ");
                valuesExp.append(" + ");
            }
        }

        System.out.println("\n----------------- Analysis Results -----------------");
        System.out.println("Input Number           : " + number);
        System.out.println("Factorial Expression   : " + factorialExp.toString());
        System.out.println("Calculation            : " + valuesExp.toString() + " = " + sumOfFactorials);

        if (sumOfFactorials == number) {
            System.out.println("Conclusion             : " + number + " IS A STRONG NUMBER! [Yes]");
        } else {
            System.out.println("Conclusion             : " + number + " is NOT a strong number. [No]");
        }
        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     Practical 12: Strong Number Checker (CLI)    ");
        System.out.println("==================================================");

        long number;

        if (args.length > 0) {
            // Read from command prompt argument
            try {
                number = Long.parseLong(args[0].trim());
                System.out.println("Number received from Command Prompt argument: " + number);
                checkAndDisplay(number);
            } catch (NumberFormatException e) {
                System.out.println("Error: Command line argument '" + args[0] + "' is not a valid integer.");
                System.out.println("Usage: java StrongNumber <number>");
            }
        } else {
            // Fallback to interactive console input if no CLI argument passed
            System.out.println("Note: You can pass a number directly from the command prompt:");
            System.out.println("      Example: java StrongNumber 145\n");

            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter a number to check: ");
                number = scanner.nextLong();
                checkAndDisplay(number);
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer number.");
            } finally {
                scanner.close();
            }
        }
    }
}
