import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 7: Selection Sort Algorithm
 *
 * Description:
 * In-place comparison sort. It divides the input list into two parts:
 * a sorted sublist of items which is built up from left to right at the front,
 * and a sublist of the remaining unsorted items.
 * Time Complexity: O(n^2) in all cases.
 */
public class SelectionSort {

    /**
     * Sorts the array using Selection Sort and displays step-by-step passes.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        System.out.println("\n--- Step-by-Step Selection Passes ---");
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            System.out.printf("Pass %d (Min element %d placed at index %d): %s%n",
                    (i + 1), arr[i], i, Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("          Practical 2.7: Selection Sort          ");
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

            selectionSort(arr);

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
