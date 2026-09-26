import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Practical 6 - Program 2:
 * Student Marks System using ONE try block and MULTIPLE catch blocks:
 * 1. InputMismatchException → user enters text instead of marks.
 * 2. ArithmeticException → program tries to calculate average when number of subjects is zero.
 * 3. ArrayIndexOutOfBoundsException → program accesses marks array using an invalid index.
 * 4. NumberFormatException → marks are entered as a string and converted incorrectly.
 */
public class StudentMarksMultipleCatch {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.2: One Try Block, Multiple Catch     ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        // One try block with multiple catch blocks
        try {
            System.out.print("Enter number of subjects (enter 0 to test ArithmeticException): ");
            int numSubjects = scanner.nextInt();

            if (numSubjects == 0) {
                // Testing ArithmeticException
                int average = 100 / numSubjects;
                System.out.println("Average: " + average);
            }

            int[] marks = new int[numSubjects];
            int total = 0;

            System.out.println("Enter marks for " + numSubjects + " subjects:");
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Subject " + (i + 1) + " marks: ");
                marks[i] = scanner.nextInt();
                total += marks[i];
            }

            // Testing ArrayIndexOutOfBoundsException
            System.out.print("\nEnter an index to inspect a subject's marks: ");
            int index = scanner.nextInt();
            System.out.println("Marks at index " + index + " = " + marks[index]);

            // Testing NumberFormatException
            scanner.nextLine(); // consume newline
            System.out.print("\nEnter grace marks as numeric string: ");
            String graceInput = scanner.nextLine();
            int graceMarks = Integer.parseInt(graceInput);
            total += graceMarks;

            double avg = (double) total / numSubjects;
            System.out.println("\n----------------- Results -----------------");
            System.out.println("Total Marks (incl. Grace) : " + total);
            System.out.printf("Calculated Average        : %.2f%n", avg);
            System.out.println("-------------------------------------------");

        } catch (InputMismatchException e) {
            System.out.println("\n[CAUGHT InputMismatchException]: User entered invalid text instead of an integer marks value!");
        } catch (ArithmeticException e) {
            System.out.println("\n[CAUGHT ArithmeticException]: Cannot calculate average when number of subjects is zero (division by zero)!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n[CAUGHT ArrayIndexOutOfBoundsException]: Attempted to access marks array using an invalid index!");
        } catch (NumberFormatException e) {
            System.out.println("\n[CAUGHT NumberFormatException]: Marks input could not be converted to a valid number!");
        } catch (Exception e) {
            System.out.println("\n[CAUGHT General Exception]: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Execution of Student Marks System completed.");
        }
    }
}
