/**
 * Problem: Spiral Matrix II
 * Difficulty: Medium
 *
 * Problem Description:
 *
 * Given a positive integer n, generate an n x n matrix
 * containing the numbers from 1 to n^2 in spiral order.
 *
 * The matrix should be filled starting from the top-left
 * corner and moving in the following order:
 *
 *     Right -> Down -> Left -> Up
 *
 * Example:
 *
 *     Input:
 *     n = 3
 *
 *     Output:
 *
 *     1  2  3
 *     8  9  4
 *     7  6  5
 *
 * Approach:
 *
 * We divide the matrix into layers and fill one layer
 * at a time.
 *
 * Four boundaries are maintained:
 *
 *     top
 *     bottom
 *     left
 *     right
 *
 * For every layer:
 *
 * 1. Fill the top row from left to right.
 * 2. Move the top boundary downward.
 *
 * 3. Fill the right column from top to bottom.
 * 4. Move the right boundary left.
 *
 * 5. Fill the bottom row from right to left.
 * 6. Move the bottom boundary upward.
 *
 * 7. Fill the left column from bottom to top.
 * 8. Move the left boundary right.
 *
 * We continue until all boundaries cross.
 *
 * Time Complexity:
 *
 * O(n^2)
 *
 * Every cell is visited exactly once.
 *
 * Space Complexity:
 *
 * O(n^2)
 *
 * The returned matrix itself requires n^2 space.
 */
public class SpiralMatrixII {

    /**
     * Generates an n x n matrix filled with values
     * from 1 to n^2 in spiral order.
     *
     * @param n size of the matrix
     * @return generated spiral matrix
     */
    public int[][] generateMatrix(int n) {

        // Create an n x n matrix.
        int[][] matrix = new int[n][n];

        // Define the four boundaries.
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        // First value to be inserted.
        int value = 1;

        /*
         * Continue while there is still an unfilled
         * portion of the matrix.
         */
        while (top <= bottom && left <= right) {

            /*
             * Step 1:
             *
             * Fill the top row from left to right.
             *
             * Example:
             *
             * 1  2  3
             * .  .  .
             * .  .  .
             */
            for (int col = left; col <= right; col++) {
                matrix[top][col] = value++;
            }

            // The top row is now completely filled.
            top++;

            /*
             * Step 2:
             *
             * Fill the right column from top to bottom.
             *
             * Example:
             *
             * 1  2  3
             * .  .  4
             * .  .  5
             */
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = value++;
            }

            // The right column is now completely filled.
            right--;

            /*
             * Step 3:
             *
             * Fill the bottom row from right to left.
             *
             * We first check whether a bottom row
             * still exists.
             */
            if (top <= bottom) {

                /*
                 * Example:
                 *
                 * 1  2  3
                 * .  .  4
                 * 7  6  5
                 */
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = value++;
                }

                // The bottom row is now completely filled.
                bottom--;
            }

            /*
             * Step 4:
             *
             * Fill the left column from bottom to top.
             *
             * We first check whether a left column
             * still exists.
             */
            if (left <= right) {

                /*
                 * Example:
                 *
                 * 1  2  3
                 * 8  .  4
                 * 7  6  5
                 */
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = value++;
                }

                // The left column is now completely filled.
                left++;
            }
        }

        return matrix;
    }

    /**
     * Prints the matrix row by row.
     *
     * @param matrix matrix to print
     */
    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        SpiralMatrixII solution = new SpiralMatrixII();

        // Example 1
        System.out.println("n = 3");
        int[][] matrix1 = solution.generateMatrix(3);
        printMatrix(matrix1);

        /*
         * Expected:
         *
         * 1 2 3
         * 8 9 4
         * 7 6 5
         */

        System.out.println();

        // Example 2
        System.out.println("n = 1");
        int[][] matrix2 = solution.generateMatrix(1);
        printMatrix(matrix2);

        /*
         * Expected:
         *
         * 1
         */

        System.out.println();

        // Example 3
        System.out.println("n = 4");
        int[][] matrix3 = solution.generateMatrix(4);
        printMatrix(matrix3);

        /*
         * Expected:
         *
         *  1  2  3  4
         * 12 13 14  5
         * 11 16 15  6
         * 10  9  8  7
         */
    }
}