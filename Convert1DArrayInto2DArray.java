/**
 * Problem: Convert 1D Array Into 2D Array
 * Difficulty: Easy
 *
 * Description:
 * You are given a 1D array `original` and two integers `m` and `n`.
 * Construct a 2D array with `m` rows and `n` columns using all elements from `original`.
 *
 * - The first `n` elements form the first row,
 * - The next `n` elements form the second row,
 * - And so on...
 *
 * If it is not possible (i.e., original.length != m * n), return an empty 2D array.
 *
 * Example 1:
 * Input: original = [1,2,3,4], m = 2, n = 2
 * Output: [[1,2],[3,4]]
 *
 * Example 2:
 * Input: original = [1,2,3], m = 1, n = 3
 * Output: [[1,2,3]]
 *
 * Example 3:
 * Input: original = [1,2], m = 1, n = 1
 * Output: []
 *
 * Constraints:
 * - 1 <= original.length <= 50,000
 * - 1 <= original[i] <= 100,000
 * - 1 <= m, n <= 40,000
 *
 * Approach:
 * 1. Check if total elements match: (m * n == original.length).
 * 2. If not, return an empty 2D array.
 * 3. Otherwise, iterate through original and fill result matrix row by row.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) for the new 2D array.
 */

public class Convert1DArrayInto2DArray {

    /**
     * Method to construct a 2D array from 1D array.
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0]; // return empty 2D array
        }

        int[][] result = new int[m][n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }

        return result;
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {
        Convert1DArrayInto2DArray solution = new Convert1DArrayInto2DArray();

        int[] original1 = {1, 2, 3, 4};
        int[][] result1 = solution.construct2DArray(original1, 2, 2);
        System.out.println("Output [[1,2],[3,4]] →");
        printMatrix(result1);

        int[] original2 = {1, 2, 3};
        int[][] result2 = solution.construct2DArray(original2, 1, 3);
        System.out.println("Output [[1,2,3]] →");
        printMatrix(result2);

        int[] original3 = {1, 2};
        int[][] result3 = solution.construct2DArray(original3, 1, 1);
        System.out.println("Output [] →");
        printMatrix(result3);
    }

    /**
     * Utility function to print 2D matrix.
     */
    private static void printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }
}
