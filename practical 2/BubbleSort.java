import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 2 - Program 3: Bubble Sort Algorithm
 *
 * Description:
 * Repeatedly compares adjacent elements and swaps them if they are in the wrong order.
 * Larger elements "bubble" up to the end of the array with each pass.
 * Best Case: O(n) [with swapped optimization], Worst/Average Case: O(n^2).
 */
public class BubbleSort {

    /**
     * Sorts the array using optimized Bubble Sort and displays each pass.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int passCount = 0;
        int totalSwaps = 0;

        System.out.println("\n--- Step-by-Step Bubble Sort Passes ---");
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passCount++;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    totalSwaps++;
                }
            }

            System.out.printf("Pass %d: %s%n", passCount, Arrays.toString(arr));

            // If no two elements were swapped in this pass, array is already sorted
            if (!swapped) {
                System.out.println("Array became sorted early. Terminating further passes.");
                break;
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Total passes executed: " + passCount);
        System.out.println("Total swaps performed: " + totalSwaps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("            Practical 2.3: Bubble Sort            ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of elements to sort: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Please enter a positive count.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("\nInitial Array: " + Arrays.toString(arr));

            bubbleSort(arr);

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
