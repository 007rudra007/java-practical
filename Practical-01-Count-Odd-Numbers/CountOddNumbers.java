import java.util.Scanner;

/**
 * Practical 01: Count Total number of odd numbers between 1 - 500.
 *
 * Description:
 * An odd number is an integer that is not divisible by 2 (i.e., n % 2 != 0).
 * This program counts all odd numbers in the range [1, 500], displays sample
 * numbers in tabular format, and provides an option to check a custom range.
 */
public class CountOddNumbers {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 01: Count Odd Numbers Between 1 - 500 ");
        System.out.println("==================================================");

        int start = 1;
        int end = 500;
        int count = 0;

        System.out.println("\nListing first few odd numbers (sample):");
        int printed = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                count++;
                if (printed < 20) {
                    System.out.print(i + (printed == 19 ? " ... " : ", "));
                    printed++;
                }
            }
        }

        System.out.println("\n\n----------------- Results -----------------");
        System.out.println("Range evaluated           : [" + start + " to " + end + "]");
        System.out.println("Total odd numbers count   : " + count);
        System.out.println("Mathematical verification : (500 - 1) / 2 + 1 = " + ((end - start) / 2 + 1));
        System.out.println("-------------------------------------------");

        // Optional interactive custom range check
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to check a custom range? (y/n): ");
        if (scanner.hasNextLine()) {
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter start of range: ");
                int customStart = scanner.nextInt();
                System.out.print("Enter end of range: ");
                int customEnd = scanner.nextInt();

                int customCount = 0;
                for (int i = customStart; i <= customEnd; i++) {
                    if (i % 2 != 0) {
                        customCount++;
                    }
                }
                System.out.println("Total odd numbers between " + customStart + " and " + customEnd + ": " + customCount);
            }
        }
        scanner.close();
        System.out.println("\nProgram executed successfully.");
    }
}
