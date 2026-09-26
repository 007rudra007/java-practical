import java.util.Scanner;

/**
 * Practical 06: Check whether a given year is a Leap Year.
 *
 * Description:
 * A year is a leap year if:
 * 1. It is divisible by 400, OR
 * 2. It is divisible by 4 AND NOT divisible by 100.
 *
 * Examples:
 *   2000 : Divisible by 400 -> Leap Year
 *   1900 : Divisible by 100 but not 400 -> NOT a Leap Year
 *   2024 : Divisible by 4 and not 100 -> Leap Year
 *   2023 : Not divisible by 4 -> NOT a Leap Year
 */
public class LeapYearCheck {

    /**
     * Determines whether the specified year is a leap year.
     *
     * @param year the year to check
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            Practical 06: Leap Year Check         ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a year (e.g., 2024): ");
            int year = scanner.nextInt();

            boolean leap = isLeapYear(year);

            System.out.println("\n----------------- Analysis -----------------");
            System.out.println("Input Year              : " + year);
            System.out.println("Divisible by 400?       : " + (year % 400 == 0 ? "Yes" : "No (" + (year % 400) + ")"));
            System.out.println("Divisible by 100?       : " + (year % 100 == 0 ? "Yes" : "No (" + (year % 100) + ")"));
            System.out.println("Divisible by 4?         : " + (year % 4 == 0 ? "Yes" : "No (" + (year % 4) + ")"));

            System.out.println("\n----------------- Results ------------------");
            if (leap) {
                System.out.println("Result: " + year + " IS A LEAP YEAR! (366 days)");
            } else {
                System.out.println("Result: " + year + " IS NOT A LEAP YEAR. (365 days)");
            }
            System.out.println("--------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer year.");
        } finally {
            scanner.close();
        }
    }
}
