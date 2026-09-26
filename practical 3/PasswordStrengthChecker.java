import java.util.Scanner;

/**
 * Practical 3 - Question 3(b):
 * Check whether a password is strong using StringBuilder and Character validation.
 *
 * Example:
 *   Enter Password: Java@123 -> Strong Password
 *
 * Criteria for a Strong Password:
 *   1. At least 8 characters long
 *   2. At least one uppercase letter (A-Z)
 *   3. At least one lowercase letter (a-z)
 *   4. At least one digit (0-9)
 *   5. At least one special character (!@#$%^&*()_+-=[]{}|;:,.<>?)
 */
public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.3(b): Password Strength Checker     ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter Password: ");
            String input = sc.nextLine();

            // Store password in StringBuilder
            StringBuilder password = new StringBuilder(input);

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            StringBuilder feedback = new StringBuilder();

            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                } else if (Character.isLowerCase(ch)) {
                    hasLower = true;
                } else if (Character.isDigit(ch)) {
                    hasDigit = true;
                } else if (!Character.isWhitespace(ch)) {
                    hasSpecial = true;
                }
            }

            if (password.length() < 8) {
                feedback.append("- Must be at least 8 characters long\n");
            }
            if (!hasUpper) {
                feedback.append("- Must contain at least one uppercase letter\n");
            }
            if (!hasLower) {
                feedback.append("- Must contain at least one lowercase letter\n");
            }
            if (!hasDigit) {
                feedback.append("- Must contain at least one digit (0-9)\n");
            }
            if (!hasSpecial) {
                feedback.append("- Must contain at least one special character (@, #, $, etc.)\n");
            }

            boolean isStrong = (password.length() >= 8) && hasUpper && hasLower && hasDigit && hasSpecial;

            System.out.println("\n----------------- Evaluation -----------------");
            System.out.println("Password Entered : " + password.toString());
            System.out.println("Password Length  : " + password.length());

            if (isStrong) {
                System.out.println("Status           : Strong Password");
            } else {
                System.out.println("Status           : Weak / Moderate Password");
                System.out.println("Suggestions for improvement:\n" + feedback.toString());
            }
            System.out.println("----------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
