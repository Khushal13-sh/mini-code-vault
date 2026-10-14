
import java.util.Arrays;

/*
 * Problem: Minimum Path Sum
 * Difficulty: Medium
 *
 * Given an m x n grid containing non-negative integers,
 * find the minimum sum of a path from the top-left cell
 * to the bottom-right cell.
 *
 * Allowed movements:
 * 1. Right
 * 2. Down
 *
 * Approach:
 * Dynamic Programming (DP)
 *
 * We maintain a DP matrix where dp[i][j] stores the
 * minimum path sum required to reach cell (i, j).
 *
 * For each cell, we choose the cheaper path from above
 * or from the left, then add the current cell's value.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {

        // Get the number of rows and columns in the grid.
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] stores the minimum sum from (0, 0)
        // to the cell at row i and column j.
        int[][] dp = new int[m][n];

        // The starting cell is included in the path sum.
        dp[0][0] = grid[0][0];

        // Step 1: Initialize the first row.
        // We can reach these cells only by moving right.
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Step 2: Initialize the first column.
        // We can reach these cells only by moving down.
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Step 3: Fill the remaining cells.
        // Each cell can be reached from above or from the left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // Select the minimum path sum from the
                // two possible previous cells.
                int minimumPreviousPath =
                        Math.min(dp[i - 1][j], dp[i][j - 1]);

                // Add the current cell's value to that
                // minimum path sum.
                dp[i][j] = grid[i][j] + minimumPreviousPath;
            }
        }

        // The bottom-right cell contains the minimum
        // path sum for the entire grid.
        return dp[m - 1][n - 1];
    }

    // Helper method to print a matrix for testing.
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Test cases
    public static void main(String[] args) {

        // Test Case 1
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println("Test Case 1:");
        System.out.println("Input:");
        printGrid(grid1);
        System.out.println("Minimum Path Sum: " + minPathSum(grid1));
        System.out.println("Expected: 7");
        System.out.println();

        // Test Case 2
        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("Test Case 2:");
        System.out.println("Input:");
        printGrid(grid2);
        System.out.println("Minimum Path Sum: " + minPathSum(grid2));
        System.out.println("Expected: 12");
        System.out.println();

        // Test Case 3: A single cell
        int[][] grid3 = {
            {5}
        };

        System.out.println("Test Case 3:");
        System.out.println("Minimum Path Sum: " + minPathSum(grid3));
        System.out.println("Expected: 5");
        System.out.println();

        // Test Case 4: A single row
        int[][] grid4 = {
            {1, 2, 3, 4}
        };

        System.out.println("Test Case 4:");
        System.out.println("Minimum Path Sum: " + minPathSum(grid4));
        System.out.println("Expected: 10");
        System.out.println();

        // Test Case 5: A single column
        int[][] grid5 = {
            {1},
            {2},
            {3}
        };

        System.out.println("Test Case 5:");
        System.out.println("Minimum Path Sum: " + minPathSum(grid5));
        System.out.println("Expected: 6");
    }
}
