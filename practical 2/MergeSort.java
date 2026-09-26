import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 6: Merge Sort Algorithm
 *
 * Description:
 * A divide-and-conquer algorithm that recursively divides the input array
 * into two halves, calls itself for the two halves, and then merges the two
 * sorted halves.
 * Time Complexity: O(n log n) in all cases (Worst, Average, Best).
 */
public class MergeSort {

    /**
     * Merges two sorted subarrays arr[l..m] and arr[m+1..r].
     */
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[]
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[]
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        System.out.printf("Merged [%d..%d]: %s%n", l, r, Arrays.toString(Arrays.copyOfRange(arr, l, r + 1)));
    }

    /**
     * Main function that sorts arr[l..r] using merge().
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("            Practical 2.6: Merge Sort             ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of elements to sort: ");
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

            System.out.println("\nInitial Array: " + Arrays.toString(arr));
            System.out.println("\n--- Divide and Conquer Merge Steps ---");

            mergeSort(arr, 0, arr.length - 1);

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
