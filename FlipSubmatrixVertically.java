/**
 * Problem: Flip Square Submatrix Vertically
 * Difficulty: Easy
 *
 * Description:
 * You are given an m x n matrix grid, and three integers x, y, and k.
 * (x, y) is the top-left corner of a square submatrix with side length k.
 * Flip that submatrix vertically (reverse the order of its rows).
 * Return the updated matrix.
 *
 * Example 1:
 * Input:
 * grid = [[1,2,3,4],
 *         [5,6,7,8],
 *         [9,10,11,12],
 *         [13,14,15,16]]
 * x = 1, y = 0, k = 3
 * Output:
 * [[1,2,3,4],
 *  [13,14,15,8],
 *  [9,10,11,12],
 *  [5,6,7,16]]
 *
 * Example 2:
 * Input:
 * grid = [[3,4,2,3],
 *         [2,3,4,2]],
 * x = 0, y = 2, k = 2
 * Output:
 * [[3,4,4,2],
 *  [2,3,2,3]]
 *
 * Approach:
 * - Identify the square submatrix of size k starting from (x, y).
 * - Swap its top and bottom rows progressively to flip vertically.
 *
 * Time Complexity: O(k²)
 * Space Complexity: O(1)
 */

import java.util.*;

public class FlipSubmatrixVertically {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int topRow = x + i;
            int bottomRow = x + k - 1 - i;

            for (int j = 0; j < k; j++) {
                int col = y + j;
                int temp = grid[topRow][col];
                grid[topRow][col] = grid[bottomRow][col];
                grid[bottomRow][col] = temp;
            }
        }
        return grid;
    }

    // Utility method to print 2D array
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    // main method for testing examples
    public static void main(String[] args) {
        FlipSubmatrixVertically solution = new FlipSubmatrixVertically();

        // Example 1
        int[][] grid1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int x1 = 1, y1 = 0, k1 = 3;
        System.out.println("Example 1 Output:");
        printMatrix(solution.reverseSubmatrix(grid1, x1, y1, k1));
        // Expected: [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]

        // Example 2
        int[][] grid2 = {
            {3, 4, 2, 3},
            {2, 3, 4, 2}
        };
        int x2 = 0, y2 = 2, k2 = 2;
        System.out.println("Example 2 Output:");
        printMatrix(solution.reverseSubmatrix(grid2, x2, y2, k2));
        // Expected: [[3,4,4,2],[2,3,2,3]]
    }
}
