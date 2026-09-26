import java.util.Scanner;

/**
 * Practical 10: To check if a given String is Palindrome or not.
 *
 * Description:
 * A palindrome string is a sequence of characters that reads the same backward as forward.
 * Examples: "madam", "racecar", "radar".
 *
 * This program demonstrates:
 * 1. Exact Palindrome check (Case-sensitive).
 * 2. Case-Insensitive Palindrome check.
 * 3. Phrase Palindrome check (ignoring spaces and punctuation, e.g. "A man a plan a canal Panama").
 */
public class PalindromeString {

    /**
     * Checks palindrome using two-pointer approach.
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         Practical 10: Palindrome String Check    ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a string or sentence: ");
            String input = scanner.nextLine();

            // Reversed string
            String reversed = new StringBuilder(input).reverse().toString();

            // 1. Exact match
            boolean exactMatch = input.equals(reversed);

            // 2. Case-insensitive match
            boolean caseInsensitiveMatch = input.equalsIgnoreCase(reversed);

            // 3. Alphanumeric only (ignoring spaces & punctuation)
            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String cleanReversed = new StringBuilder(clean).reverse().toString();
            boolean phraseMatch = clean.length() > 0 && clean.equals(cleanReversed);

            System.out.println("\n----------------- Analysis Results -----------------");
            System.out.println("Original String          : \"" + input + "\"");
            System.out.println("Reversed String          : \"" + reversed + "\"");
            System.out.println("Exact Case Match?        : " + (exactMatch ? "Yes" : "No"));
            System.out.println("Case-Insensitive Match?  : " + (caseInsensitiveMatch ? "Yes" : "No"));
            System.out.println("Phrase Match (clean)?    : " + (phraseMatch ? "Yes" : "No"));

            System.out.println("\n----------------- Final Conclusion -----------------");
            if (exactMatch) {
                System.out.println("Result: \"" + input + "\" is a STRICT PALINDROME!");
            } else if (caseInsensitiveMatch) {
                System.out.println("Result: \"" + input + "\" is a PALINDROME (ignoring character casing).");
            } else if (phraseMatch) {
                System.out.println("Result: \"" + input + "\" is a PALINDROME PHRASE (ignoring spaces & punctuation).");
            } else {
                System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
            }
            System.out.println("----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
