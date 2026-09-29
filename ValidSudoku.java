import java.util.Arrays;

/**
 * Valid Sudoku
 *
 * Problem:
 * Determine whether a 9 x 9 Sudoku board is valid.
 *
 * A Sudoku board is valid if:
 *
 * 1. Each row contains digits 1-9 without repetition.
 * 2. Each column contains digits 1-9 without repetition.
 * 3. Each 3 x 3 sub-box contains digits 1-9 without repetition.
 *
 * Empty cells are represented by '.' and should be ignored.
 *
 * Important:
 * A valid Sudoku board does not necessarily mean that the
 * Sudoku puzzle can be solved. We only need to check whether
 * the currently filled cells follow the Sudoku rules.
 *
 * Example:
 *
 * Input:
 * 5 3 . . 7 . . . .
 * 6 . . 1 9 5 . . .
 * . 9 8 . . . . 6 .
 * 8 . . . 6 . . . 3
 * 4 . . 8 . 3 . . 1
 * 7 . . . 2 . . . 6
 * . 6 . . . . 2 8 .
 * . . . 4 1 9 . . 5
 * . . . . 8 . . 7 9
 *
 * Output:
 * true
 *
 * Approach:
 * Use three boolean arrays:
 *
 * rows[9][9]
 * columns[9][9]
 * boxes[9][9]
 *
 * For every filled cell:
 * 1. Find its digit.
 * 2. Find which 3 x 3 box it belongs to.
 * 3. Check whether the digit already exists in its row,
 *    column, or box.
 * 4. If it already exists, the board is invalid.
 * 5. Otherwise, mark the digit as present.
 *
 * Box calculation:
 *
 * box = (row / 3) * 3 + (col / 3)
 *
 * This converts the 3 x 3 boxes into indexes from 0 to 8.
 *
 * Time Complexity:
 * O(1)
 *
 * The board always contains exactly 81 cells.
 *
 * Space Complexity:
 * O(1)
 *
 * The boolean arrays have fixed size 9 x 9.
 */
public class ValidSudoku {

    /**
     * Checks whether the given Sudoku board is valid.
     *
     * @param board 9 x 9 Sudoku board
     * @return true if the board is valid, otherwise false
     */
    public static boolean isValidSudoku(char[][] board) {

        // rows[row][digit]
        // Stores whether a digit already exists in a row.
        boolean[][] rows = new boolean[9][9];

        // columns[col][digit]
        // Stores whether a digit already exists in a column.
        boolean[][] columns = new boolean[9][9];

        // boxes[box][digit]
        // Stores whether a digit already exists in a 3 x 3 box.
        boolean[][] boxes = new boolean[9][9];

        // Traverse every cell of the board.
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // Ignore empty cells.
                if (board[row][col] == '.') {
                    continue;
                }

                /*
                 * Convert character digit to index.
                 *
                 * '1' - '1' = 0
                 * '2' - '1' = 1
                 * ...
                 * '9' - '1' = 8
                 */
                int digit = board[row][col] - '1';

                /*
                 * Find the 3 x 3 box number.
                 *
                 * Example:
                 * row = 4, col = 4
                 *
                 * box = (4 / 3) * 3 + (4 / 3)
                 *     = 1 * 3 + 1
                 *     = 4
                 */
                int box = (row / 3) * 3 + (col / 3);

                // Check whether the digit already exists in the row.
                if (rows[row][digit]) {
                    return false;
                }

                // Check whether the digit already exists in the column.
                if (columns[col][digit]) {
                    return false;
                }

                // Check whether the digit already exists in the box.
                if (boxes[box][digit]) {
                    return false;
                }

                // Mark the digit as present.
                rows[row][digit] = true;
                columns[col][digit] = true;
                boxes[box][digit] = true;
            }
        }

        // No duplicate was found.
        return true;
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        // Example 1: Valid Sudoku
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Example 1:");
        printBoard(board1);
        System.out.println("Is Valid Sudoku: " + isValidSudoku(board1));

        System.out.println();

        // Example 2: Invalid Sudoku
        // The first cell is changed from 5 to 8.
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Example 2:");
        printBoard(board2);
        System.out.println("Is Valid Sudoku: " + isValidSudoku(board2));
    }

    /**
     * Prints the Sudoku board.
     *
     * @param board Sudoku board
     */
    private static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }
}