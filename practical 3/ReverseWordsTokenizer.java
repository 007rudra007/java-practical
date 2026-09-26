import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Practical 3 - Question 4:
 * Takes a sentence as input and uses StringTokenizer to reverse each word
 * individually while keeping the word order the same.
 *
 * Example:
 *   Input:  "Java is fun to learn"
 *   Output: "avaJ si nuf ot nrael"
 */
public class ReverseWordsTokenizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.4: Reverse Words via StringTokenizer ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter a sentence: ");
            String sentence = sc.nextLine();

            // Using StringTokenizer to break sentence into words
            StringTokenizer tokenizer = new StringTokenizer(sentence);

            StringBuilder result = new StringBuilder();

            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                // Reverse the individual word using StringBuilder
                String reversedWord = new StringBuilder(word).reverse().toString();
                result.append(reversedWord);

                if (tokenizer.hasMoreTokens()) {
                    result.append(" ");
                }
            }

            System.out.println("\n----------------- Results -----------------");
            System.out.println("Input  : \"" + sentence + "\"");
            System.out.println("Output : \"" + result.toString() + "\"");
            System.out.println("-------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
