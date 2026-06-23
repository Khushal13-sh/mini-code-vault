/*
 add solution for creating grid with exactly one path
*/

/**
 * Problem: Create Grid With Exactly One Path
 * Difficulty: Easy
 *
 * Description:
 * Given integers m and n representing the number
 * of rows and columns of a grid, construct an
 * m × n grid containing:
 *
 * '.' -> free cell
 * '#' -> obstacle cell
 *
 * Such that there is exactly one valid path from:
 *
 * (0,0) to (m-1,n-1)
 *
 * Moving only:
 * - Right
 * - Down
 *
 * Return any valid grid.
 *
 * Key Insight:
 * - Create a single corridor from start to end.
 * - Keep all other cells blocked.
 * - This guarantees exactly one possible path.
 *
 * Approach:
 * - Fill the entire grid with '#'.
 * - Make the entire first row free.
 * - Make the entire last column free.
 * - This creates one L-shaped path:
 *      Right → Right → ... → Down → Down
 *
 * Why this works:
 * - Every other cell remains blocked.
 * - There is only one route from start to destination.
 * - No alternative path can exist.
 *
 * Time Complexity: O(m × n)
 *
 * Space Complexity: O(m × n)
 */
import java.util.Arrays;

public class CreateGridWithExactlyOnePath {

    public String[] createGrid(int m, int n) {

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        // Free cells in first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }

        // Free cells in last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        CreateGridWithExactlyOnePath obj =
                new CreateGridWithExactlyOnePath();

        // Example 1
        String[] grid1 = obj.createGrid(2, 3);

        System.out.println("Output 1:");
        for (String row : grid1) {
            System.out.println(row);
        }

        // Example 2
        String[] grid2 = obj.createGrid(3, 3);

        System.out.println("\nOutput 2:");
        for (String row : grid2) {
            System.out.println(row);
        }
    }
}