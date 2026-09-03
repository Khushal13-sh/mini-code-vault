import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-Queens
 *
 * Difficulty: Hard
 *
 * Problem:
 * Place n queens on an n x n chessboard such that no two queens
 * attack each other.
 *
 * Approach:
 * Backtracking
 *
 * Key Idea:
 * Place one queen in each row and try every possible column.
 * If a position is safe, place the queen and move to the next row.
 * If the placement does not lead to a solution, remove the queen
 * and try another position.
 *
 * Time Complexity:
 * O(N!) approximately
 *
 * Space Complexity:
 * O(N^2) for the board and recursion/result storage.
 */
public class NQueens {

    private List<List<String>> ans = new ArrayList<>();

    /**
     * Returns all distinct solutions for the N-Queens problem.
     *
     * @param n number of queens
     * @return list of all valid board configurations
     */
    public List<List<String>> solveNQueens(int n) {

        // Create an empty chessboard
        char[][] board = new char[n][n];

        // Fill the board with empty cells
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Start placing queens from row 0
        solve(0, board, n);

        return ans;
    }

    /**
     * Tries to place a queen in the given row.
     */
    private void solve(int row, char[][] board, int n) {

        // All queens are successfully placed
        if (row == n) {

            List<String> list = new ArrayList<>();

            // Convert each board row into a String
            for (char[] r : board) {
                list.add(new String(r));
            }

            // Store this valid solution
            ans.add(list);

            return;
        }

        // Try placing the queen in every column
        for (int col = 0; col < n; col++) {

            // Check whether this position is safe
            if (safe(row, col, board, n)) {

                // Place the queen
                board[row][col] = 'Q';

                // Move to the next row
                solve(row + 1, board, n);

                // Backtrack and remove the queen
                board[row][col] = '.';
            }
        }
    }

    /**
     * Checks whether a queen can safely be placed
     * at the given row and column.
     */
    private boolean safe(int row, int col, char[][] board, int n) {

        // Check the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // No queen can attack this position
        return true;
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        NQueens obj = new NQueens();

        // Example 1
        int n1 = 4;

        List<List<String>> result1 = obj.solveNQueens(n1);

        System.out.println("Input: n = " + n1);
        System.out.println("Output:");

        for (List<String> board : result1) {
            System.out.println(board);
        }

        // Example 2
        NQueens obj2 = new NQueens();

        int n2 = 1;

        List<List<String>> result2 = obj2.solveNQueens(n2);

        System.out.println("\nInput: n = " + n2);
        System.out.println("Output: " + result2);
    }
}