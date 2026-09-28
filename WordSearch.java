/**
 * Word Search
 *
 * Problem:
 * Given an m x n grid of characters and a word, determine whether
 * the word exists in the grid.
 *
 * The word can be constructed using letters from sequentially
 * adjacent cells. Adjacent cells can be:
 *
 * 1. Up
 * 2. Down
 * 3. Left
 * 4. Right
 *
 * The same cell cannot be used more than once in the same word.
 *
 * Example:
 *
 * Input:
 * board = {
 *     {'A', 'B', 'C', 'E'},
 *     {'S', 'F', 'C', 'S'},
 *     {'A', 'D', 'E', 'E'}
 * }
 *
 * word = "ABCCED"
 *
 * Output:
 * true
 *
 * Approach:
 * This problem is solved using Backtracking.
 *
 * We start searching from every cell in the board.
 *
 * For each cell:
 * 1. Check whether the current character matches the word.
 * 2. Mark the current cell as visited.
 * 3. Search in all four directions.
 * 4. Restore the original character after the search.
 *
 * We mark a cell as '#' temporarily so that the same cell
 * cannot be used more than once in the current path.
 *
 * Time Complexity:
 * O(m * n * 4^L)
 *
 * where:
 * m = number of rows
 * n = number of columns
 * L = length of the word
 *
 * Space Complexity:
 * O(L)
 *
 * This is the maximum recursion depth.
 */
public class WordSearch {

    /**
     * Checks whether the given word exists in the board.
     *
     * @param board character grid
     * @param word word to search
     * @return true if the word exists, otherwise false
     */
    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try starting the search from every cell.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Performs backtracking search from the current cell.
     *
     * @param board character grid
     * @param word word being searched
     * @param row current row
     * @param col current column
     * @param index current character index in the word
     * @return true if the remaining word can be found
     */
    private static boolean search(
            char[][] board,
            String word,
            int row,
            int col,
            int index) {

        // All characters of the word have been matched.
        if (index == word.length()) {
            return true;
        }

        // Check whether the current position is outside the board.
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current cell does not match the required character.
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Store the original character.
        char current = board[row][col];

        // Mark this cell as visited.
        board[row][col] = '#';

        // Search in all four directions.
        boolean found =
                search(board, word, row - 1, col, index + 1) || // Up
                search(board, word, row + 1, col, index + 1) || // Down
                search(board, word, row, col - 1, index + 1) || // Left
                search(board, word, row, col + 1, index + 1);   // Right

        // Restore the original character.
        board[row][col] = current;

        return found;
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1
        char[][] board1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";

        System.out.println("Example 1:");
        System.out.println("Word: " + word1);
        System.out.println("Output: " + exist(board1, word1));

        System.out.println();

        // Example 2
        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word2 = "SEE";

        System.out.println("Example 2:");
        System.out.println("Word: " + word2);
        System.out.println("Output: " + exist(board2, word2));

        System.out.println();

        // Example 3
        char[][] board3 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word3 = "ABCB";

        System.out.println("Example 3:");
        System.out.println("Word: " + word3);
        System.out.println("Output: " + exist(board3, word3));
    }
}