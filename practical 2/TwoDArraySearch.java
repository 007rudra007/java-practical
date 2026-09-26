import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Practical 2 - Program 8: Search in a Two-Dimensional (2D) Array
 *
 * Description:
 * Searches for a target value within a 2D grid/matrix and returns all
 * coordinate positions (row, column) where the element appears.
 */
public class TwoDArraySearch {

    // Helper class to store 2D coordinates
    static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("[Row %d, Col %d]", row, col);
        }
    }

    /**
     * Prints the 2D matrix formatted with row and column headers.
     */
    public static void printMatrix(int[][] matrix, int rows, int cols) {
        System.out.print("      ");
        for (int j = 0; j < cols; j++) {
            System.out.printf("Col %-3d", j);
        }
        System.out.println("\n      " + "-------".repeat(cols));

        for (int i = 0; i < rows; i++) {
            System.out.printf("Row %-2d|", i);
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Searches for a target element in the 2D array and records all matching coordinates.
     */
    public static List<Coordinate> search2D(int[][] matrix, int rows, int cols, int target) {
        List<Coordinate> results = new ArrayList<>();
        int comparisons = 0;

        System.out.println("\n--- 2D Array Traversal Trace ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                comparisons++;
                if (matrix[i][j] == target) {
                    System.out.printf("Checking [%d][%d] = %d (MATCH FOUND)%n", i, j, matrix[i][j]);
                    results.add(new Coordinate(i, j));
                }
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Total cells checked: " + comparisons);
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("        Practical 2.8: Two-Dimensional Array Search");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Dimensions must be positive integers.");
                return;
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("\nEnter matrix elements (" + rows + " x " + cols + "):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println("\nMatrix Input:");
            printMatrix(matrix, rows, cols);

            System.out.print("\nEnter target element to search: ");
            int target = scanner.nextInt();

            List<Coordinate> occurrences = search2D(matrix, rows, cols, target);

            System.out.println("\n----------------- Search Results -----------------");
            if (!occurrences.isEmpty()) {
                System.out.println("SUCCESS: Element " + target + " was found at:");
                for (Coordinate coord : occurrences) {
                    System.out.println("  -> " + coord + " (0-indexed)");
                }
                System.out.println("Total occurrences found: " + occurrences.size());
            } else {
                System.out.println("NOT FOUND: Element " + target + " does not exist in the 2D matrix.");
            }
            System.out.println("--------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
