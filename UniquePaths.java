
/*
 * Problem: Unique Paths
 * Difficulty: Medium
 *
 * A robot starts at the top-left corner of an m x n grid
 * and must reach the bottom-right corner.
 *
 * The robot can move only right or down.
 * Return the total number of unique paths.
 *
 * Approach: Dynamic Programming
 *
 * dp[i][j] stores the number of unique paths from the
 * top-left corner to the cell at row i and column j.
 *
 * Every cell can be reached from:
 * 1. The cell directly above it.
 * 2. The cell directly to its left.
 *
 * Therefore:
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class UniquePaths {

    /*
     * Calculates the number of unique paths in an m x n grid.
     *
     * m - Number of rows.
     * n - Number of columns.
     */
    public static int uniquePaths(int m, int n) {

        // dp[i][j] stores the number of ways to reach cell (i, j).
        int[][] dp = new int[m][n];

        /*
         * Step 1: Initialize the first row.
         *
         * To reach any cell in the first row, the robot must
         * move only right. There is exactly one possible path.
         */
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        /*
         * Step 2: Initialize the first column.
         *
         * To reach any cell in the first column, the robot must
         * move only down. There is exactly one possible path.
         */
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        /*
         * Step 3: Calculate paths for the remaining cells.
         *
         * Each cell can be reached from above or from the left.
         * Add the number of paths to both previous cells to
         * calculate the total number of paths to this cell.
         */
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                // Paths from above + paths from the left.
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        /*
         * The bottom-right cell contains the total number
         * of unique paths from the starting cell.
         */
        return dp[m - 1][n - 1];
    }

    // Test cases
    public static void main(String[] args) {

        // Test Case 1
        int m1 = 3;
        int n1 = 7;

        System.out.println("Test Case 1");
        System.out.println("Input: m = " + m1 + ", n = " + n1);
        System.out.println("Output: " + uniquePaths(m1, n1));
        System.out.println("Expected: 28");
        System.out.println();

        // Test Case 2
        int m2 = 3;
        int n2 = 2;

        System.out.println("Test Case 2");
        System.out.println("Input: m = " + m2 + ", n = " + n2);
        System.out.println("Output: " + uniquePaths(m2, n2));
        System.out.println("Expected: 3");
        System.out.println();

        // Test Case 3: Single cell
        int m3 = 1;
        int n3 = 1;

        System.out.println("Test Case 3");
        System.out.println("Input: m = " + m3 + ", n = " + n3);
        System.out.println("Output: " + uniquePaths(m3, n3));
        System.out.println("Expected: 1");
        System.out.println();

        // Test Case 4: Single row
        System.out.println("Test Case 4");
        System.out.println("Input: m = 1, n = 5");
        System.out.println("Output: " + uniquePaths(1, 5));
        System.out.println("Expected: 1");
        System.out.println();

        // Test Case 5: Single column
        System.out.println("Test Case 5");
        System.out.println("Input: m = 5, n = 1");
        System.out.println("Output: " + uniquePaths(5, 1));
        System.out.println("Expected: 1");
    }
}
