import java.util.Scanner;

/**
 * Practical 14: Write a program to find s = 1 - 3 + 5 - 7 + 9 ... + n
 *
 * Description:
 * Computes the alternating series where terms are successive odd integers
 * starting from 1 up to 'n', with alternating addition and subtraction:
 * s = +1 - 3 + 5 - 7 + 9 - 11 ... (+/- n)
 */
public class AlternatingSeries {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Practical 14: Series s = 1 - 3 + 5 - 7 + 9 ...  ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the limit n (e.g., 9): ");
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("Please enter a positive integer greater than or equal to 1.");
                return;
            }

            long sum = 0;
            int sign = 1; // 1 for +, -1 for -
            StringBuilder seriesExpr = new StringBuilder();

            int termIndex = 1;
            for (int val = 1; val <= n; val += 2) {
                long term = (long) sign * val;
                sum += term;

                if (termIndex == 1) {
                    seriesExpr.append(val);
                } else {
                    if (sign > 0) {
                        seriesExpr.append(" + ").append(val);
                    } else {
                        seriesExpr.append(" - ").append(val);
                    }
                }

                // Alternate sign for next odd number
                sign = -sign;
                termIndex++;
            }

            System.out.println("\n----------------- Results -----------------");
            System.out.println("Input Limit (n)  : " + n);
            System.out.println("Series           : " + seriesExpr.toString());
            System.out.println("Sum (s)          : " + sum);
            System.out.println("Total Terms      : " + (termIndex - 1));
            System.out.println("-------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
