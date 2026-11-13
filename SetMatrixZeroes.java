
/*
 * Problem: Set Matrix Zeroes
 *
 * Description:
 * Given an m x n matrix, if an element is zero,
 * set its entire row and column to zero.
 *
 * The modification must be done in place.
 *
 * Approach:
 * Use the first row and first column as markers.
 *
 * If matrix[i][j] == 0:
 * 1. Mark its row by setting matrix[i][0] = 0.
 * 2. Mark its column by setting matrix[0][j] = 0.
 *
 * Then use these markers to update the matrix.
 *
 * We separately track whether the first row and
 * first column originally contained zero.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Store whether the first row originally
        // contains any zero.
        boolean firstRowZero = false;

        for (int j = 0; j < cols; j++) {

            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Store whether the first column originally
        // contains any zero.
        boolean firstColZero = false;

        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 1: Use the first row and first column
        // as markers for the remaining matrix.
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    // Mark the current row.
                    matrix[i][0] = 0;

                    // Mark the current column.
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Set elements to zero based
        // on the row and column markers.
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: If the first row originally
        // contained zero, make the entire row zero.
        if (firstRowZero) {

            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: If the first column originally
        // contained zero, make the entire column zero.
        if (firstColZero) {

            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        SetMatrixZeroes solution = new SetMatrixZeroes();

        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        solution.setZeroes(matrix1);

        System.out.println("Example 1:");
        printMatrix(matrix1);
        // Expected:
        // [1, 0, 1]
        // [0, 0, 0]
        // [1, 0, 1]


        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };

        solution.setZeroes(matrix2);

        System.out.println("Example 2:");
        printMatrix(matrix2);
        // Expected:
        // [0, 0, 0, 0]
        // [0, 4, 5, 0]
        // [0, 3, 1, 0]


        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {0, 8, 9}
        };

        solution.setZeroes(matrix3);

        System.out.println("First column contains zero:");
        printMatrix(matrix3);
        // Expected:
        // [0, 2, 3]
        // [0, 5, 6]
        // [0, 0, 0]
    }

    // Helper method to print a matrix.
    public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }
}
