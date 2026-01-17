/**
 * Problem: Count Negative Numbers in a Sorted Matrix
 * Difficulty: Easy
 *
 * Uses top-right traversal to efficiently count
 * all negative numbers in a sorted matrix.
 */
class Solution {

    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int row = 0;
        int col = n - 1;
        int count = 0;

        // Traverse from top-right corner
        while (row < m && col >= 0) {

            if (grid[row][col] < 0) {
                // All elements below are negative
                count += (m - row);
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}
