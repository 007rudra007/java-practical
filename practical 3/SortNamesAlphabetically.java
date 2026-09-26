import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 3 - Question 2(a):
 * Accept a Set of names from the Keyboard and Sort them alphabetically.
 */
public class SortNamesAlphabetically {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println(" Practical 3.2(a): Sort Names Alphabetically      ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of names: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume trailing newline

            if (n <= 0) {
                System.out.println("Please enter a positive count.");
                return;
            }

            String[] names = new String[n];
            System.out.println("Enter " + n + " names (one per line):");
            for (int i = 0; i < n; i++) {
                System.out.print("Name " + (i + 1) + ": ");
                names[i] = sc.nextLine().trim();
            }

            System.out.println("\nOriginal List of Names:");
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ". " + names[i]);
            }

            // Alphabetical sort using String's compareToIgnoreCase
            Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);

            System.out.println("\nAlphabetically Sorted Names:");
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + ". " + names[i]);
            }
            System.out.println("--------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
