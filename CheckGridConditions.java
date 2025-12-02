/**
 * Problem: Check if Grid Satisfies Conditions
 * Difficulty: Easy
 *
 * Conditions checked:
 * 1. Each cell must match the cell directly below it (if exists).
 * 2. Each cell must differ from the cell to the right (if exists).
 */

public class CheckGridConditions {

    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Check below
                if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }

                // Check right
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckGridConditions solution = new CheckGridConditions();

        System.out.println(solution.satisfiesConditions(new int[][]{{1,0,2},{1,0,2}})); // true
        System.out.println(solution.satisfiesConditions(new int[][]{{1,1,1},{0,0,0}})); // false
        System.out.println(solution.satisfiesConditions(new int[][]{{1},{2},{3}}));     // false
    }
}
