
import java.util.Arrays;

/*
 * Problem: Rotate Image
 * Difficulty: Medium
 *
 * Given an n x n matrix, rotate it 90 degrees clockwise.
 *
 * Requirement:
 * Modify the original matrix in-place.
 * Do not create another 2D matrix.
 *
 * Approach:
 * 1. Transpose the matrix.
 * 2. Reverse each row.
 *
 * Transpose:
 * Swap matrix[i][j] with matrix[j][i].
 *
 * Reverse each row:
 * Swap the leftmost and rightmost elements,
 * then move the pointers toward the center.
 *
 * Time Complexity: O(n * n)
 * Auxiliary Space Complexity: O(1)
 */
public class RotateImage {

    /*
     * Rotates the given square matrix 90 degrees clockwise.
     *
     * The original matrix is modified directly.
     */
    public static void rotate(int[][] matrix) {

        // Number of rows and columns in the square matrix.
        int n = matrix.length;

        /*
         * STEP 1: TRANSPOSE THE MATRIX
         *
         * Transposing means converting rows into columns.
         *
         * We swap matrix[i][j] with matrix[j][i].
         *
         * The inner loop starts at i + 1 because:
         * 1. Elements on the main diagonal do not need swapping.
         * 2. Each pair should be swapped only once.
         */
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                // Store the current element temporarily.
                int temp = matrix[i][j];

                // Move the corresponding element into this position.
                matrix[i][j] = matrix[j][i];

                // Complete the swap.
                matrix[j][i] = temp;
            }
        }

        /*
         * STEP 2: REVERSE EVERY ROW
         *
         * After transposing, reverse each row horizontally.
         *
         * Use two pointers:
         * left  -> first element of the row
         * right -> last element of the row
         *
         * Swap their values and move both pointers inward.
         */
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            // Continue until the two pointers meet or cross.
            while (left < right) {

                // Store the left element temporarily.
                int temp = matrix[i][left];

                // Move the right element to the left position.
                matrix[i][left] = matrix[i][right];

                // Complete the swap.
                matrix[i][right] = temp;

                // Move both pointers toward the center.
                left++;
                right--;
            }
        }
    }

    /*
     * Helper method to print the matrix row by row.
     */
    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /*
     * Helper method to run a test case.
     */
    private static void runTestCase(String testName, int[][] matrix) {

        System.out.println(testName);
        System.out.println("Before rotation:");
        printMatrix(matrix);

        // Rotate the original matrix in-place.
        rotate(matrix);

        System.out.println("After rotation:");
        printMatrix(matrix);
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {

        // Test Case 1: 3 x 3 matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        runTestCase("Test Case 1", matrix1);

        // Expected:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]


        // Test Case 2: 4 x 4 matrix
        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        runTestCase("Test Case 2", matrix2);

        // Expected:
        // [15, 13, 2, 5]
        // [14, 3, 4, 1]
        // [12, 6, 8, 9]
        // [16, 7, 10, 11]


        // Test Case 3: Single element
        int[][] matrix3 = {
            {5}
        };

        runTestCase("Test Case 3", matrix3);

        // Expected:
        // [5]


        // Test Case 4: 2 x 2 matrix
        int[][] matrix4 = {
            {1, 2},
            {3, 4}
        };

        runTestCase("Test Case 4", matrix4);

        // Expected:
        // [3, 1]
        // [4, 2]
    }
}
