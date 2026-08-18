/*
 add solution for minimum operations to make columns strictly increasing
*/

/**
 * Problem: Minimum Operations to Make Columns Strictly Increasing
 * Difficulty: Easy
 *
 * Description:
 * Given a matrix grid, increment any element by 1 in one operation.
 * Return the minimum number of operations required to make every
 * column strictly increasing from top to bottom.
 *
 * Key Insight:
 * - Each column can be processed independently.
 * - For every row after the first row, its value must be greater
 *   than the value directly above it.
 * - If the current value is already greater, no operation is needed.
 * - Otherwise, increase it to exactly one more than the previous value.
 *
 * Approach:
 * - Traverse each column from top to bottom.
 * - Start from row 1 because the first row has no value above it.
 * - If grid[row][col] <= grid[row - 1][col]:
 *   - The required value is grid[row - 1][col] + 1.
 *   - Add the difference to the operation count.
 *   - Update the current value.
 * - Continue until all columns are processed.
 *
 * Why this works:
 * We only need to increase values, so when a value is not greater
 * than the previous value, the smallest valid value is exactly
 * previous value + 1.
 *
 * Choosing the smallest possible value is optimal because it
 * minimizes the current operations and does not create unnecessary
 * extra operations for the following rows.
 *
 * Time Complexity: O(m * n)
 *
 * Space Complexity: O(1)
 * The given grid is modified directly.
 */
public class MinimumOperationsToMakeColumnsStrictlyIncreasing {

    public int minimumOperations(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int operations = 0;

        // Process each column independently.
        for (int col = 0; col < n; col++) {

            // Start from the second row.
            for (int row = 1; row < m; row++) {

                // Current value must be strictly greater
                // than the value above it.
                if (grid[row][col] <= grid[row - 1][col]) {

                    int needed = grid[row - 1][col] + 1;

                    // Count the required increments.
                    operations += needed - grid[row][col];

                    // Update the current value.
                    grid[row][col] = needed;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {

        MinimumOperationsToMakeColumnsStrictlyIncreasing obj =
                new MinimumOperationsToMakeColumnsStrictlyIncreasing();

        // Example 1
        int[][] grid1 = {
                {3, 2},
                {1, 3},
                {3, 4},
                {0, 1}
        };

        int result1 = obj.minimumOperations(grid1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[][] grid2 = {
                {3, 2, 1},
                {2, 1, 0},
                {1, 2, 3}
        };

        int result2 = obj.minimumOperations(grid2);

        System.out.println("Output 2: " + result2);
    }
}