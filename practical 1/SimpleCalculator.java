import java.util.Scanner;

/**
 * Practical 08: Simple Calculator Using switch case.
 *
 * Description:
 * Implements basic arithmetic operations (+, -, *, /, %, ^) using a
 * Java switch statement with input validation (including divide-by-zero checking).
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     Practical 08: Simple Calculator (switch)     ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first operand (number): ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /, %, ^): ");
            char op = scanner.next().charAt(0);

            System.out.print("Enter second operand (number): ");
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;
            String errorMessage = "";

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0) {
                        validOperation = false;
                        errorMessage = "Error: Division by zero is undefined!";
                    } else {
                        result = num1 / num2;
                    }
                    break;

                case '%':
                    if (num2 == 0) {
                        validOperation = false;
                        errorMessage = "Error: Modulo by zero is undefined!";
                    } else {
                        result = num1 % num2;
                    }
                    break;

                case '^':
                    result = Math.pow(num1, num2);
                    break;

                default:
                    validOperation = false;
                    errorMessage = "Error: Unsupported operator '" + op + "'. Supported operators: +, -, *, /, %, ^";
                    break;
            }

            System.out.println("\n----------------- Calculation -----------------");
            if (validOperation) {
                // If result is integer, display without decimal trailing zero
                if (result == (long) result && num1 == (long) num1 && num2 == (long) num2) {
                    System.out.println((long) num1 + " " + op + " " + (long) num2 + " = " + (long) result);
                } else {
                    System.out.printf("%.4f %c %.4f = %.4f%n", num1, op, num2, result);
                }
            } else {
                System.out.println(errorMessage);
            }
            System.out.println("-----------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error: Invalid numerical input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }
}
