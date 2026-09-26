import java.util.Scanner;

/**
 * Practical 15: Program to accept a number and convert it to words using switch.
 * Example: 123 -> one two three (or One Two Three)
 *
 * Description:
 * Extracts or iterates through each digit of the input number and translates
 * each digit into its corresponding word using a Java switch statement.
 */
public class NumberToWords {

    /**
     * Converts a single digit character to its corresponding word using switch.
     */
    public static String digitToWord(char digit) {
        switch (digit) {
            case '0': return "Zero";
            case '1': return "One";
            case '2': return "Two";
            case '3': return "Three";
            case '4': return "Four";
            case '5': return "Five";
            case '6': return "Six";
            case '7': return "Seven";
            case '8': return "Eight";
            case '9': return "Nine";
            default:  return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Practical 15: Convert Number to Words (switch)  ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer number (e.g., 123): ");
            String inputStr = scanner.next().trim();

            StringBuilder wordsResult = new StringBuilder();
            int startIndex = 0;

            if (inputStr.charAt(0) == '-') {
                wordsResult.append("Minus ");
                startIndex = 1;
            } else if (inputStr.charAt(0) == '+') {
                startIndex = 1;
            }

            boolean valid = true;
            for (int i = startIndex; i < inputStr.length(); i++) {
                char ch = inputStr.charAt(i);
                if (Character.isDigit(ch)) {
                    wordsResult.append(digitToWord(ch)).append(" ");
                } else {
                    valid = false;
                    break;
                }
            }

            System.out.println("\n----------------- Results -----------------");
            if (valid && inputStr.length() > startIndex) {
                System.out.println("Input Number  : " + inputStr);
                System.out.println("In Words      : " + wordsResult.toString().trim());
                System.out.println("Lowercase     : " + wordsResult.toString().trim().toLowerCase());
            } else {
                System.out.println("Error: Please enter a valid integer (digits only).");
            }
            System.out.println("-------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
