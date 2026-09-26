import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Practical 6 - Program 1:
 * Demonstrate exception handling using separate try-catch blocks for 7 distinct exceptions:
 * 1. ArithmeticException: Cannot divide by zero.
 * 2. ArrayIndexOutOfBoundsException: Invalid array index.
 * 3. NumberFormatException: Marks must be numeric.
 * 4. InputMismatchException: Please enter an integer.
 * 5. NullPointerException: Student name is null.
 * 6. StringIndexOutOfBoundsException: Invalid character index.
 * 7. IllegalArgumentException: Marks must be between 0 and 100.
 */
public class SevenExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 6.1: Demonstration of 7 Java Exceptions ");
        System.out.println("==================================================");

        // 1. ArithmeticException
        System.out.println("\n--- 1. Handling ArithmeticException ---");
        try {
            int numerator = 50;
            int denominator = 0;
            System.out.println("Attempting division: " + numerator + " / " + denominator);
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Cannot divide by zero. [" + e.getMessage() + "]");
        }

        // 2. ArrayIndexOutOfBoundsException
        System.out.println("\n--- 2. Handling ArrayIndexOutOfBoundsException ---");
        try {
            int[] marks = {85, 90, 78};
            System.out.println("Array size is: " + marks.length);
            System.out.println("Attempting to access marks[5]...");
            int val = marks[5];
            System.out.println("Value: " + val);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Invalid array index. [" + e.getMessage() + "]");
        }

        // 3. NumberFormatException
        System.out.println("\n--- 3. Handling NumberFormatException ---");
        try {
            String rollString = "abc";
            System.out.println("Attempting Integer.parseInt(\"" + rollString + "\")...");
            int rollNo = Integer.parseInt(rollString);
            System.out.println("Roll Number: " + rollNo);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Marks must be numeric. Enter your roll number: abc [" + e.getMessage() + "]");
        }

        // 4. InputMismatchException
        System.out.println("\n--- 4. Handling InputMismatchException ---");
        try {
            String simulatedInput = "notAnInt";
            Scanner mockScanner = new Scanner(simulatedInput);
            System.out.println("Reading integer from input containing: \"" + simulatedInput + "\"...");
            int num = mockScanner.nextInt();
            System.out.println("Integer entered: " + num);
            mockScanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: Please enter an integer.");
        }

        // 5. NullPointerException
        System.out.println("\n--- 5. Handling NullPointerException ---");
        try {
            String studentName = null;
            System.out.println("Student name is null. Attempting studentName.length()...");
            int length = studentName.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Student name is null.");
        }

        // 6. StringIndexOutOfBoundsException
        System.out.println("\n--- 6. Handling StringIndexOutOfBoundsException ---");
        try {
            String text = "Java";
            System.out.println("String is: \"" + text + "\" (length " + text.length() + ")");
            System.out.println("Attempting text.charAt(10)...");
            char ch = text.charAt(10);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: Invalid character index. [" + e.getMessage() + "]");
        }

        // 7. IllegalArgumentException
        System.out.println("\n--- 7. Handling IllegalArgumentException ---");
        try {
            int enteredMarks = 125;
            System.out.println("Validating marks: " + enteredMarks);
            if (enteredMarks < 0 || enteredMarks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100. Entered: " + enteredMarks);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println(" All 7 exceptions handled successfully with try-catch.");
        System.out.println("==================================================");
    }
}
