/**
 * Problem: Modify the Matrix
 * Difficulty: Easy
 *
 * You are given a 0-indexed m x n integer matrix.
 * Create a new matrix `answer` equal to `matrix`,
 * then replace each element with value -1 by the maximum
 * element in its respective column.
 *
 * Return the matrix `answer`.
 *
 * Example 1:
 * Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * Output: [[1,2,9],[4,8,6],[7,8,9]]
 * Explanation:
 * - Replace matrix[1][1] (-1) with max in col 1 = 8.
 * - Replace matrix[0][2] (-1) with max in col 2 = 9.
 *
 * Example 2:
 * Input: matrix = [[3,-1],[5,2]]
 * Output: [[3,2],[5,2]]
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 2 <= m, n <= 50
 * - -1 <= matrix[i][j] <= 100
 * - Each column contains at least one non-negative integer.
 *
 * Approach:
 * - For each column, precompute the maximum value.
 * - Traverse the matrix; wherever element == -1,
 *   replace it with that column's maximum.
 * - Return modified matrix.
 */
public class ModifyTheMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Precompute column maximums
        int[] colMax = new int[n];
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            colMax[j] = max;
        }

        // Replace -1 with column maximum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = colMax[j];
                }
            }
        }

        return matrix;
    }

    // Quick test cases
    public static void main(String[] args) {
        ModifyTheMatrix solution = new ModifyTheMatrix();

        int[][] matrix1 = {{1,2,-1},{4,-1,6},{7,8,9}};
        int[][] ans1 = solution.modifiedMatrix(matrix1);
        printMatrix(ans1); // [[1,2,9],[4,8,6],[7,8,9]]

        int[][] matrix2 = {{3,-1},{5,2}};
        int[][] ans2 = solution.modifiedMatrix(matrix2);
        printMatrix(ans2); // [[3,2],[5,2]]
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
