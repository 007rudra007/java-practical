import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 11: To check whether two Strings are Anagram.
 *
 * Examples from prompt:
 *   1. "Listen" -> "Silent"
 *   2. "Debit card" -> "Bad credit"
 *
 * Description:
 * Two strings are anagrams if they contain the exact same characters with the
 * exact same frequencies, ignoring whitespace, punctuation, and character casing.
 */
public class AnagramCheck {

    /**
     * Checks if two strings are anagrams.
     * Normalizes by removing non-alphanumeric characters and converting to lowercase.
     */
    public static boolean checkAnagram(String str1, String str2) {
        // Normalize: remove whitespace/punctuation, convert to lowercase
        String clean1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String clean2 = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (clean1.length() != clean2.length()) {
            return false;
        }

        char[] arr1 = clean1.toCharArray();
        char[] arr2 = clean2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    /**
     * Helper to get sorted normalized character string for display.
     */
    public static String getSortedNormalized(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = clean.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            Practical 11: Anagram Checker         ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first string (e.g., 'Debit card'): ");
            String str1 = scanner.nextLine();

            System.out.print("Enter second string (e.g., 'Bad credit'): ");
            String str2 = scanner.nextLine();

            boolean isAnagram = checkAnagram(str1, str2);

            String sorted1 = getSortedNormalized(str1);
            String sorted2 = getSortedNormalized(str2);

            System.out.println("\n----------------- Analysis Results -----------------");
            System.out.println("String 1                 : \"" + str1 + "\"");
            System.out.println("String 2                 : \"" + str2 + "\"");
            System.out.println("Normalized & Sorted (1)  : \"" + sorted1 + "\"");
            System.out.println("Normalized & Sorted (2)  : \"" + sorted2 + "\"");
            System.out.println("Characters Match?        : " + (sorted1.equals(sorted2) ? "Yes" : "No"));

            System.out.println("\n----------------- Final Conclusion -----------------");
            if (isAnagram) {
                System.out.println("Result: \"" + str1 + "\" and \"" + str2 + "\" ARE ANAGRAMS! [Yes]");
            } else {
                System.out.println("Result: \"" + str1 + "\" and \"" + str2 + "\" are NOT anagrams. [No]");
            }
            System.out.println("----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
