
import java.util.Arrays;

/*
 * Problem: Surrounded Regions
 * Difficulty: Medium
 *
 * Given a board containing 'X' and 'O', capture all regions
 * of 'O' that are completely surrounded by 'X'.
 *
 * An 'O' connected horizontally or vertically to a boundary
 * 'O' must not be captured.
 *
 * Approach: Depth-First Search (DFS)
 *
 * 1. Run DFS from every boundary cell.
 * 2. Mark every boundary-connected 'O' as '#'.
 * 3. Convert remaining 'O' cells into 'X'.
 * 4. Restore '#' cells to 'O'.
 *
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n) in the worst case
 * because of the recursive DFS call stack.
 */
public class SurroundedRegions {

    /*
     * Modifies the board in-place by capturing surrounded regions.
     */
    public static void solve(char[][] board) {

        // Number of rows and columns.
        int m = board.length;
        int n = board[0].length;

        /*
         * STEP 1: Process the left and right boundaries.
         *
         * Every 'O' connected to these boundary cells must
         * be preserved.
         */
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        /*
         * STEP 2: Process the top and bottom boundaries.
         *
         * DFS also preserves any 'O' connected to these cells.
         */
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        /*
         * STEP 3: Update every cell.
         *
         * 'O'  -> 'X': This region was not connected to a boundary.
         * '#'  -> 'O': This cell was connected to a boundary.
         * 'X' remains unchanged.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    // Capture the surrounded region.
                    board[i][j] = 'X';

                } else if (board[i][j] == '#') {
                    // Restore a safe boundary-connected cell.
                    board[i][j] = 'O';
                }
            }
        }
    }

    /*
     * Marks every 'O' connected to the given cell as '#'.
     *
     * The search explores all four directions:
     * down, up, right, and left.
     */
    private static void dfs(char[][] board, int i, int j) {

        int m = board.length;
        int n = board[0].length;

        /*
         * Base cases:
         * 1. The coordinates are outside the board.
         * 2. The current cell is not 'O'.
         *
         * Returning here prevents invalid access and stops
         * the search from crossing 'X' or revisiting marked cells.
         */
        if (i < 0 || i >= m || j < 0 || j >= n
                || board[i][j] != 'O') {
            return;
        }

        /*
         * Mark this cell immediately.
         *
         * This prevents the DFS from repeatedly visiting
         * the same cell through neighboring directions.
         */
        board[i][j] = '#';

        // Explore the cell below.
        dfs(board, i + 1, j);

        // Explore the cell above.
        dfs(board, i - 1, j);

        // Explore the cell to the right.
        dfs(board, i, j + 1);

        // Explore the cell to the left.
        dfs(board, i, j - 1);
    }

    /*
     * Helper method to print the board.
     */
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    /*
     * Helper method to run and display a test case.
     */
    private static void runTestCase(String name, char[][] board) {

        System.out.println(name);
        System.out.println("Before:");
        printBoard(board);

        solve(board);

        System.out.println("After:");
        printBoard(board);
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {

        // Test Case 1: Surrounded region in the center.
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        runTestCase("Test Case 1", board1);

        // Expected:
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, O, X, X]


        // Test Case 2: Boundary-connected region.
        char[][] board2 = {
            {'X', 'O', 'X'},
            {'O', 'O', 'X'},
            {'X', 'X', 'X'}
        };

        runTestCase("Test Case 2", board2);

        // Expected:
        // [X, O, X]
        // [O, O, X]
        // [X, X, X]


        // Test Case 3: All cells are 'O'.
        char[][] board3 = {
            {'O', 'O'},
            {'O', 'O'}
        };

        runTestCase("Test Case 3", board3);

        // Expected:
        // [O, O]
        // [O, O]


        // Test Case 4: Single cell.
        char[][] board4 = {
            {'O'}
        };

        runTestCase("Test Case 4", board4);

        // Expected:
        // [O]
    }
}
