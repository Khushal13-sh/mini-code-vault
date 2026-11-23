/*
 * Problem: Number of Islands
 *
 * Description:
 * Given a 2D grid containing '1' (land) and '0' (water),
 * count the total number of islands.
 *
 * An island is formed by connecting adjacent land cells
 * horizontally or vertically.
 *
 * Approach: Depth-First Search (DFS)
 *
 * 1. Traverse every cell in the grid.
 * 2. Whenever a land cell ('1') is found:
 *    - Increment the island count.
 *    - Start DFS from that cell.
 * 3. During DFS, visit all four adjacent directions:
 *    up, down, left, and right.
 * 4. Mark every visited land cell as '0' to avoid
 *    counting the same island again.
 * 5. Continue until the entire grid is traversed.
 *
 * The number of DFS starting points represents the
 * total number of islands.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {

                    count++;

                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Check boundaries and skip water cells.
        if (row < 0 || col < 0 ||
            row >= rows || col >= cols ||
            grid[row][col] == '0') {

            return;
        }

        // Mark the current land cell as visited.
        grid[row][col] = '0';

        // Explore all four adjacent directions.
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static void main(String[] args) {

        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(solution.numIslands(grid1));
        System.out.println(solution.numIslands(grid2));
    }
}