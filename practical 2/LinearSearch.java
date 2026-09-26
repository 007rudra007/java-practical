import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Practical 2 - Program 5: Linear Search Algorithm
 *
 * Description:
 * Sequentially checks each element of the array until a match is found or
 * the entire list has been searched.
 * Time Complexity: O(n)
 */
public class LinearSearch {

    /**
     * Performs linear search and returns all indices where target appears.
     */
    public static List<Integer> linearSearch(int[] arr, int target) {
        List<Integer> foundIndices = new ArrayList<>();
        int comparisons = 0;

        System.out.println("\n--- Step-by-Step Linear Search Comparisons ---");
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.printf("Index %d: arr[%d] = %d (MATCH FOUND)%n", i, i, arr[i]);
                foundIndices.add(i);
            } else {
                System.out.printf("Index %d: arr[%d] = %d != %d%n", i, i, arr[i], target);
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("Total sequential comparisons made: " + comparisons);
        return foundIndices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("           Practical 2.5: Linear Search           ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("\nArray: " + Arrays.toString(arr));

            System.out.print("Enter element to search for: ");
            int target = scanner.nextInt();

            List<Integer> occurrences = linearSearch(arr, target);

            System.out.println("\n----------------- Search Result -----------------");
            if (!occurrences.isEmpty()) {
                System.out.println("SUCCESS: Element " + target + " was found at index / indices: " + occurrences);
                System.out.println("First occurrence index : " + occurrences.get(0));
                System.out.println("Total times found      : " + occurrences.size());
            } else {
                System.out.println("NOT FOUND: Element " + target + " does not exist in the array.");
            }
            System.out.println("-------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
