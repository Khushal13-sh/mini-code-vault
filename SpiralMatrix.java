import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * Problem:
 * Given an m x n matrix, return all elements of the matrix
 * in spiral order.
 *
 * Spiral order means:
 * 1. Traverse from left to right.
 * 2. Traverse from top to bottom.
 * 3. Traverse from right to left.
 * 4. Traverse from bottom to top.
 *
 * Repeat these steps for the remaining inner matrix.
 *
 * Example:
 * Input:
 * [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 *
 * Output:
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Approach:
 * Use four boundaries to represent the remaining matrix:
 *
 * top    -> first available row
 * bottom -> last available row
 * left   -> first available column
 * right  -> last available column
 *
 * After traversing one side, move its boundary inward.
 *
 * Time Complexity:
 * O(m * n)
 *
 * Space Complexity:
 * O(1) excluding the result list.
 */
public class SpiralMatrix {

    /**
     * Returns all elements of the matrix in spiral order.
     *
     * @param matrix input matrix
     * @return list of elements in spiral order
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 1. Traverse from left to right.
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // Top row is completed.
            top++;

            // 2. Traverse from top to bottom.
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            // Right column is completed.
            right--;

            // 3. Traverse from right to left.
            // Check if there is still an unvisited row.
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }

                // Bottom row is completed.
                bottom--;
            }

            // 4. Traverse from bottom to top.
            // Check if there is still an unvisited column.
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }

                // Left column is completed.
                left++;
            }
        }

        return result;
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Example 1:");
        System.out.println("Input:");
        printMatrix(matrix1);

        System.out.println("Spiral Order:");
        System.out.println(spiralOrder(matrix1));

        System.out.println();

        // Example 2
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("Example 2:");
        System.out.println("Input:");
        printMatrix(matrix2);

        System.out.println("Spiral Order:");
        System.out.println(spiralOrder(matrix2));
    }

    /**
     * Prints the matrix row by row.
     *
     * @param matrix matrix to print
     */
    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(" ]");
        }
    }
}