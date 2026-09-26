import java.util.Arrays;
import java.util.Scanner;

/**
 * Practical 3 - Question 1: Program using 2D array for:
 *   a) Transpose
 *   b) Multiplication
 *   c) Product of diagonal elements and column elements
 *   d) Sort the elements in array
 *   e) Sum of all the elements ending with 4
 *   f) Print upper diagonal
 *   g) Print lower diagonal
 */
public class TwoDimensionalArrayOperations {

    // Utility to print a 2D matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%6d", val);
            }
            System.out.println();
        }
    }

    // a) Transpose of a matrix
    public static int[][] transpose(int[][] matrix, int rows, int cols) {
        int[][] trans = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }

    // b) Matrix Multiplication
    public static void matrixMultiplication(int[][] a, int r1, int c1, Scanner sc) {
        System.out.println("\n--- Matrix Multiplication ---");
        System.out.print("Enter rows for second matrix: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns for second matrix: ");
        int c2 = sc.nextInt();

        if (c1 != r2) {
            System.out.println("Error: Matrix multiplication not possible! Columns of first matrix ("
                    + c1 + ") must equal rows of second matrix (" + r2 + ").");
            return;
        }

        int[][] b = new int[r2][c2];
        System.out.println("Enter elements for second matrix (" + r2 + " x " + c2 + "):");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int[][] result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("\nProduct Matrix (" + r1 + " x " + c2 + "):");
        printMatrix(result);
    }

    // c) Product of diagonal elements and column elements
    public static void productOfDiagonalsAndColumns(int[][] matrix, int rows, int cols) {
        System.out.println("\n--- Product of Diagonal & Column Elements ---");

        // Diagonal product (applicable if rows == cols or minimum dimension)
        if (rows == cols) {
            long mainDiagProduct = 1;
            long antiDiagProduct = 1;

            for (int i = 0; i < rows; i++) {
                mainDiagProduct *= matrix[i][i];
                antiDiagProduct *= matrix[i][rows - 1 - i];
            }

            System.out.println("Primary Diagonal Product    : " + mainDiagProduct);
            System.out.println("Secondary Diagonal Product  : " + antiDiagProduct);
        } else {
            System.out.println("Note: Matrix is not square (" + rows + "x" + cols + "), skipping square diagonal product.");
        }

        // Product of each column's elements
        System.out.println("\nColumn Elements Product:");
        for (int j = 0; j < cols; j++) {
            long colProduct = 1;
            for (int i = 0; i < rows; i++) {
                colProduct *= matrix[i][j];
            }
            System.out.println("  Column " + j + " Product: " + colProduct);
        }
    }

    // d) Sort the elements in array
    public static void sortMatrixElements(int[][] matrix, int rows, int cols) {
        System.out.println("\n--- Sorted Elements in 2D Array ---");
        int[] flat = new int[rows * cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flat[k++] = matrix[i][j];
            }
        }

        Arrays.sort(flat);

        int[][] sortedMatrix = new int[rows][cols];
        k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix[i][j] = flat[k++];
            }
        }

        System.out.println("Matrix after sorting elements:");
        printMatrix(sortedMatrix);
    }

    // e) Sum of all the elements ending with 4
    public static void sumOfElementsEndingWith4(int[][] matrix, int rows, int cols) {
        System.out.println("\n--- Sum of Elements Ending with 4 ---");
        long sum = 0;
        boolean found = false;
        StringBuilder elementsList = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.abs(matrix[i][j]) % 10 == 4) {
                    sum += matrix[i][j];
                    elementsList.append(matrix[i][j]).append(" ");
                    found = true;
                }
            }
        }

        if (found) {
            System.out.println("Elements ending with 4 : " + elementsList.toString().trim());
            System.out.println("Sum of elements        : " + sum);
        } else {
            System.out.println("No elements ending with 4 were found in the matrix.");
        }
    }

    // f) Print upper diagonal / upper triangle
    public static void printUpperDiagonal(int[][] matrix, int rows, int cols) {
        System.out.println("\n--- Upper Diagonal / Triangle (j >= i) ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j >= i) {
                    System.out.printf("%6d", matrix[i][j]);
                } else {
                    System.out.printf("%6s", " ");
                }
            }
            System.out.println();
        }
    }

    // g) Print lower diagonal / lower triangle
    public static void printLowerDiagonal(int[][] matrix, int rows, int cols) {
        System.out.println("\n--- Lower Diagonal / Triangle (i >= j) ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i >= j) {
                    System.out.printf("%6d", matrix[i][j]);
                } else {
                    System.out.printf("%6s", " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("     Practical 3.1: 2D Array Operations           ");
        System.out.println("==================================================");

        try {
            System.out.print("Enter number of rows: ");
            int rows = sc.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = sc.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Dimensions must be positive integers.");
                return;
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("\nEnter matrix elements (" + rows + " x " + cols + "):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.println("\nOriginal Matrix:");
            printMatrix(matrix);

            // a) Transpose
            System.out.println("\na) Transpose of the matrix:");
            int[][] transposed = transpose(matrix, rows, cols);
            printMatrix(transposed);

            // b) Multiplication
            System.out.println("\nb) Matrix Multiplication:");
            matrixMultiplication(matrix, rows, cols, sc);

            // c) Product of diagonal elements and column elements
            System.out.println("\nc) Product of diagonal elements and column elements:");
            productOfDiagonalsAndColumns(matrix, rows, cols);

            // d) Sort the elements in array
            System.out.println("\nd) Sort elements in array:");
            sortMatrixElements(matrix, rows, cols);

            // e) Sum of all the elements ending with 4
            System.out.println("\ne) Sum of elements ending with 4:");
            sumOfElementsEndingWith4(matrix, rows, cols);

            // f) Print upper diagonal
            System.out.println("\nf) Print upper diagonal:");
            printUpperDiagonal(matrix, rows, cols);

            // g) Print lower diagonal
            System.out.println("\ng) Print lower diagonal:");
            printLowerDiagonal(matrix, rows, cols);

        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
