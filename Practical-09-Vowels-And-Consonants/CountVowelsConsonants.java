import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * Practical 09: To Count the Number of Vowels and Consonants in a Sentence.
 *
 * Description:
 * Analyzes an input string or sentence character-by-character,
 * classifying characters into Vowels (a, e, i, o, u), Consonants (other letters),
 * Digits, Whitespace, and Special Characters.
 */
public class CountVowelsConsonants {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Practical 09: Count Vowels and Consonants       ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            int vowelCount = 0;
            int consonantCount = 0;
            int digitCount = 0;
            int spaceCount = 0;
            int specialCount = 0;

            Map<Character, Integer> vowelFreq = new HashMap<>();
            vowelFreq.put('a', 0);
            vowelFreq.put('e', 0);
            vowelFreq.put('i', 0);
            vowelFreq.put('o', 0);
            vowelFreq.put('u', 0);

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                char lower = Character.toLowerCase(ch);

                if (lower >= 'a' && lower <= 'z') {
                    if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                        vowelCount++;
                        vowelFreq.put(lower, vowelFreq.get(lower) + 1);
                    } else {
                        consonantCount++;
                    }
                } else if (Character.isDigit(ch)) {
                    digitCount++;
                } else if (Character.isWhitespace(ch)) {
                    spaceCount++;
                } else {
                    specialCount++;
                }
            }

            System.out.println("\n----------------- Analysis Results -----------------");
            System.out.println("Original Sentence    : \"" + sentence + "\"");
            System.out.println("Total Characters     : " + sentence.length());
            System.out.println("Vowels Count         : " + vowelCount);
            System.out.println("Consonants Count     : " + consonantCount);
            System.out.println("Digits Count         : " + digitCount);
            System.out.println("Spaces / Tabs Count  : " + spaceCount);
            System.out.println("Special Symbols      : " + specialCount);
            System.out.println("\n--- Vowel Breakdown ---");
            for (Map.Entry<Character, Integer> entry : vowelFreq.entrySet()) {
                System.out.println("  '" + entry.getKey() + "' : " + entry.getValue());
            }
            System.out.println("----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred during text processing: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
