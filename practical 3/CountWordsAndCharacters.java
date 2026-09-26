import java.util.Scanner;

/**
 * Practical 3 - Question 2(b):
 * Program using String class to count the total number of words and characters.
 */
public class CountWordsAndCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.2(b): Count Words and Characters     ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter a line or paragraph of text: ");
            String text = sc.nextLine();

            int totalCharactersWithSpaces = text.length();

            // Characters excluding whitespace
            int totalCharactersWithoutSpaces = 0;
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isWhitespace(text.charAt(i))) {
                    totalCharactersWithoutSpaces++;
                }
            }

            // Word count
            String trimmed = text.trim();
            int wordCount = 0;
            if (!trimmed.isEmpty()) {
                String[] words = trimmed.split("\\s+");
                wordCount = words.length;
            }

            System.out.println("\n----------------- Analysis Results -----------------");
            System.out.println("Input Text                       : \"" + text + "\"");
            System.out.println("Total Words                      : " + wordCount);
            System.out.println("Total Characters (with spaces)   : " + totalCharactersWithSpaces);
            System.out.println("Total Characters (without spaces): " + totalCharactersWithoutSpaces);
            System.out.println("Total Whitespaces                : " + (totalCharactersWithSpaces - totalCharactersWithoutSpaces));
            System.out.println("----------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
