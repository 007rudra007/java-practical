import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 2: Recursive Binary Search
 *
 * Description:
 * Implements binary search recursively by dividing the search interval in half
 * on each recursive call until the target is found or interval is empty.
 * Time Complexity: O(log n)
 */
public class BinarySearchRecursive {

    /**
     * Recursive method to search for target in arr[low..high].
     *
     * @param arr    the sorted array
     * @param low    starting index
     * @param high   ending index
     * @param target search key
     * @param depth  recursion call depth for visual trace
     * @return index if found, else -1
     */
    public static int binarySearchRecursive(int[] arr, int low, int high, int target, int depth) {
        if (low > high) {
            return -1; // Base case: interval exhausted
        }

        int mid = low + (high - low) / 2;
        System.out.printf("  Call (depth %d): low=%d, high=%d, mid=%d (arr[%d]=%d)%n",
                depth, low, high, mid, mid, arr[mid]);

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            // Target lies in the left subarray
            return binarySearchRecursive(arr, low, mid - 1, target, depth + 1);
        }

        // Target lies in the right subarray
        return binarySearchRecursive(arr, mid + 1, high, target, depth + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("        Practical 2.2: Recursive Binary Search    ");
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

            Arrays.sort(arr);
            System.out.println("\nSorted Array: " + Arrays.toString(arr));

            System.out.print("\nEnter target element to search: ");
            int target = scanner.nextInt();

            System.out.println("\n--- Recursive Call Trace ---");
            int resultIndex = binarySearchRecursive(arr, 0, arr.length - 1, target, 1);

            System.out.println("\n----------------- Search Result -----------------");
            if (resultIndex != -1) {
                System.out.println("SUCCESS: Element " + target + " found at index " + resultIndex + ".");
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
