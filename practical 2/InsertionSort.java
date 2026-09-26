import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 4: Insertion Sort Algorithm
 *
 * Description:
 * Iterates through the input elements and grows a sorted array output at each step.
 * On each iteration, it removes one element from the input data, finds the location
 * it belongs within the sorted list, and inserts it there.
 * Time Complexity: O(n^2), Best Case: O(n).
 */
public class InsertionSort {

    /**
     * Sorts the array using Insertion Sort and displays step-by-step progress.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        System.out.println("\n--- Step-by-Step Insertion Passes ---");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            System.out.printf("Pass %d (Inserted %d): %s%n", i, key, Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("          Practical 2.4: Insertion Sort           ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of elements to sort: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("\nInitial Array: " + Arrays.toString(arr));

            insertionSort(arr);

            System.out.println("\n----------------- Final Result ------------------");
            System.out.println("Sorted Array: " + Arrays.toString(arr));
            System.out.println("-------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
