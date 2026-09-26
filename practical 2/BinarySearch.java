import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 1: Iterative Binary Search
 *
 * Description:
 * Searches for a target value within a sorted array using the iterative
 * divide-and-conquer binary search algorithm.
 * Time Complexity: O(log n)
 */
public class BinarySearch {

    /**
     * Performs iterative binary search on a sorted array.
     *
     * @param arr    the sorted input array
     * @param target the element to search for
     * @return index of target if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int step = 1;

        System.out.println("\n--- Binary Search Trace ---");
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("Step %d: low = %d, high = %d, mid = %d (arr[%d] = %d)%n",
                    step++, low, high, mid, mid, arr[mid]);

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in right half
            } else {
                high = mid - 1; // Search in left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("        Practical 2.1: Iterative Binary Search    ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of elements in the array: ");
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

            // Binary search requires a sorted array
            Arrays.sort(arr);
            System.out.println("\nSorted Array: " + Arrays.toString(arr));

            System.out.print("\nEnter target element to search: ");
            int target = scanner.nextInt();

            int resultIndex = binarySearch(arr, target);

            System.out.println("\n----------------- Search Result -----------------");
            if (resultIndex != -1) {
                System.out.println("SUCCESS: Element " + target + " found at index " + resultIndex + " in sorted array.");
            } else {
                System.out.println("NOT FOUND: Element " + target + " is not present in the array.");
            }
            System.out.println("-------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
