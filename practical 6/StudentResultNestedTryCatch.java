import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Practical 6 - Program 3:
 * Student Result System using Nested try-catch blocks:
 * - Outer try-catch: Handles InputMismatchException if user enters text instead of marks.
 * - Inner try-catch 1: Handles ArithmeticException while calculating average if number of subjects is zero.
 * - Inner try-catch 2: Handles ArrayIndexOutOfBoundsException if an invalid subject index is accessed.
 */
public class StudentResultNestedTryCatch {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.3: Nested Try-Catch in Student System");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        // Outer try block: Handles user input issues (InputMismatchException)
        try {
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();

            int numSubjects = 3;
            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            System.out.println("Enter marks for 3 subjects:");
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt(); // May throw InputMismatchException caught by outer catch
                totalMarks += marks[i];
            }

            // Inner try-catch Block 1: Calculation and ArithmeticException
            try {
                int divisor = numSubjects; // Test with 0 to trigger inner ArithmeticException
                int average = totalMarks / divisor;
                System.out.println("\n[Calculation]: Average marks calculated = " + average);
            } catch (ArithmeticException e) {
                System.out.println("[INNER CATCH 1 - ArithmeticException]: Number of subjects is zero! Cannot divide by zero.");
            }

            // Inner try-catch Block 2: Array access and ArrayIndexOutOfBoundsException
            try {
                System.out.print("\nEnter index to verify a specific subject (0 to 2, enter 5 to trigger exception): ");
                int verifyIndex = scanner.nextInt();
                System.out.println("Verified Subject Marks at index [" + verifyIndex + "] = " + marks[verifyIndex]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[INNER CATCH 2 - ArrayIndexOutOfBoundsException]: Invalid subject index accessed! Valid range is 0 to " + (numSubjects - 1));
            }

            System.out.println("\n----------------- Summary Report -----------------");
            System.out.println("Student Name     : " + studentName);
            System.out.println("Total Marks      : " + totalMarks + " / 300");
            System.out.printf("Average Marks    : %.2f%n", (double) totalMarks / numSubjects);
            System.out.println("--------------------------------------------------");

        } catch (InputMismatchException e) {
            System.out.println("\n[OUTER CATCH - InputMismatchException]: Invalid input type! Please enter numerical values for marks.");
        } finally {
            scanner.close();
            System.out.println("Program execution finished.");
        }
    }
}
