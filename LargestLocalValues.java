import java.util.Arrays;

/**
 * Problem: Largest Local Values in a Matrix
 * Difficulty: Easy
 *
 * Given an n x n integer matrix grid:
 *  - Generate a matrix maxLocal of size (n-2) x (n-2)
 *  - maxLocal[i][j] is the largest value in the 3x3 matrix
 *    centered around row i+1 and column j+1 in grid.
 *
 * Approach:
 * 1. Precompute row-wise 3-element max values to optimize.
 * 2. Then compute the max among 3 consecutive rows to get 3x3 max.
 */
public class LargestLocalValues {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] rowMax = new int[n][n - 2];

        // Step 1: Compute horizontal 3-element max for each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                rowMax[i][j] = Math.max(grid[i][j],
                                 Math.max(grid[i][j + 1], grid[i][j + 2]));
            }
        }

        // Step 2: Compute vertical 3-row max to form 3x3 local max
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = Math.max(rowMax[i][j],
                                   Math.max(rowMax[i + 1][j], rowMax[i + 2][j]));
            }
        }

        return maxLocal;
    }

    public static void main(String[] args) {
        LargestLocalValues solution = new LargestLocalValues();

        int[][] grid1 = {
            {9, 9, 8, 1},
            {5, 6, 2, 6},
            {8, 2, 6, 4},
            {6, 2, 2, 2}
        };
        System.out.println(Arrays.deepToString(solution.largestLocal(grid1)));
        // Expected: [[9, 9], [8, 6]]

        int[][] grid2 = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.deepToString(solution.largestLocal(grid2)));
        // Expected: [[2,2,2],[2,2,2],[2,2,2]]
    }
}
