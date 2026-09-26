import java.util.Scanner;

/**
 * Practical 13: Write a program to find s = 1^2/1! + 2^2/2! + ... + n^2/n!
 *
 * Description:
 * Evaluates the mathematical series:
 * s = \sum_{i=1}^{n} \frac{i^2}{i!}
 *
 * Mathematical Insight:
 * As n -> infinity, the infinite sum converges to 2 * e ≈ 5.4365636569...
 */
public class SeriesSumFactorial {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 13: Series s = 1^2/1! + 2^2/2! + ...   ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of terms (n >= 1): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
                return;
            }

            double sum = 0.0;
            double factorial = 1.0;

            System.out.println("\n----------------- Step-by-Step Terms -----------------");
            System.out.printf("%-6s %-18s %-16s %-16s%n", "Term", "Expression", "Term Value", "Cumulative Sum");
            System.out.println("------------------------------------------------------");

            for (int i = 1; i <= n; i++) {
                factorial *= i; // Maintain running factorial: i!
                double numerator = (double) i * i;
                double term = numerator / factorial;
                sum += term;

                String expr = i + "^2 / " + i + "!";
                System.out.printf("%-6d %-18s %-16.6f %-16.6f%n", i, expr, term, sum);
            }

            System.out.println("------------------------------------------------------");
            System.out.println("\n----------------- Final Results ----------------------");
            System.out.println("Number of terms (n)   : " + n);
            System.out.printf("Total Sum (s)         : %.8f%n", sum);
            System.out.printf("Theoretical Limit (2e): %.8f%n", 2 * Math.E);
            System.out.println("------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter an integer number.");
        } finally {
            scanner.close();
        }
    }
}
