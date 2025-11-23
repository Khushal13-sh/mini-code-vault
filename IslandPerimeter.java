/**
 * Problem: Island Perimeter
 * Difficulty: Easy
 *
 * Calculate the total perimeter of the single island in the grid.
 * For every land cell, add 4. Subtract 2 for each adjacent land cell
 * to the right or bottom to avoid double-counting shared edges.
 */

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    // Each land cell initially contributes 4
                    perimeter += 4;

                    // Check right neighbor
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }

                    // Check bottom neighbor
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    // ------------ MAIN METHOD FOR TESTS ------------
    public static void main(String[] args) {
        IslandPerimeter sol = new IslandPerimeter();

        int[][] grid1 = {
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        };

        int[][] grid2 = {{1}};
        int[][] grid3 = {{1,0}};

        System.out.println(sol.islandPerimeter(grid1)); // 16
        System.out.println(sol.islandPerimeter(grid2)); // 4
        System.out.println(sol.islandPerimeter(grid3)); // 4
    }
}
