import java.util.Scanner;

/**
 * Practical 05: Swap Two Numbers without using a third argument (temporary variable).
 *
 * Description:
 * Demonstrates two standard approaches:
 * 1. Arithmetic Method (Addition & Subtraction):
 *      a = a + b;
 *      b = a - b;
 *      a = a - b;
 * 2. Bitwise XOR Method:
 *      a = a ^ b;
 *      b = a ^ b;
 *      a = a ^ b;
 */
public class SwapTwoNumbers {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 05: Swap Two Numbers Without 3rd Var   ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number (a): ");
            int a = scanner.nextInt();

            System.out.print("Enter second number (b): ");
            int b = scanner.nextInt();

            System.out.println("\n----------------- Initial State -----------------");
            System.out.println("Before Swap : a = " + a + ", b = " + b);
            System.out.println("-------------------------------------------------");

            // Method 1: Using Arithmetic Operators
            int a1 = a;
            int b1 = b;
            System.out.println("\n--- [Method 1: Using Arithmetic (+, -)] ---");
            System.out.println("Step 1: a = a + b  => " + a1 + " + " + b1 + " = " + (a1 + b1));
            a1 = a1 + b1;
            System.out.println("Step 2: b = a - b  => " + a1 + " - " + b1 + " = " + (a1 - b1));
            b1 = a1 - b1;
            System.out.println("Step 3: a = a - b  => " + a1 + " - " + b1 + " = " + (a1 - b1));
            a1 = a1 - b1;
            System.out.println("Result after Method 1: a = " + a1 + ", b = " + b1);

            // Method 2: Using Bitwise XOR Operators
            int a2 = a;
            int b2 = b;
            System.out.println("\n--- [Method 2: Using Bitwise XOR (^)] ---");
            System.out.println("Step 1: a = a ^ b  => " + a2 + " ^ " + b2 + " = " + (a2 ^ b2));
            a2 = a2 ^ b2;
            System.out.println("Step 2: b = a ^ b  => " + a2 + " ^ " + b2 + " = " + (a2 ^ b2));
            b2 = a2 ^ b2;
            System.out.println("Step 3: a = a ^ b  => " + a2 + " ^ " + b2 + " = " + (a2 ^ b2));
            a2 = a2 ^ b2;
            System.out.println("Result after Method 2: a = " + a2 + ", b = " + b2);

            System.out.println("\n----------------- Final Summary -----------------");
            System.out.println("Original values : a = " + a + ", b = " + b);
            System.out.println("Swapped values  : a = " + a1 + ", b = " + b1);
            System.out.println("-------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter integer values.");
        } finally {
            scanner.close();
        }
    }
}
