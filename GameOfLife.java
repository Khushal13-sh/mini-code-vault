/*
 * Problem: Game of Life
 *
 * Description:
 * Given an m x n board containing live cells (1) and dead cells (0),
 * update the board to represent the next generation.
 *
 * Each cell follows four rules based on its eight neighboring cells:
 * 1. A live cell with fewer than 2 live neighbors dies.
 * 2. A live cell with 2 or 3 live neighbors survives.
 * 3. A live cell with more than 3 live neighbors dies.
 * 4. A dead cell with exactly 3 live neighbors becomes alive.
 *
 * All cell updates must happen simultaneously.
 *
 * Approach: In-Place State Encoding
 *
 * Use temporary values to preserve the original state while
 * calculating the next generation:
 *
 * 0 = Originally dead, remains dead.
 * 1 = Originally alive, remains alive.
 * 2 = Originally alive, becomes dead.
 * 3 = Originally dead, becomes alive.
 *
 * 1. Traverse every cell and count its eight live neighbors.
 * 2. Use values 2 and 3 to store state transitions.
 * 3. Treat both 1 and 2 as originally alive when counting neighbors.
 * 4. After processing every cell, make a second traversal:
 *    - Convert 2 into 0.
 *    - Convert 3 into 1.
 *
 * This ensures all cells are updated simultaneously.
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                // Count the eight neighboring live cells.
                for (int k = 0; k < 8; k++) {

                    int r = i + rowDir[k];
                    int c = j + colDir[k];

                    if (r >= 0 && r < m && c >= 0 && c < n) {

                        // 1 and 2 both represent originally live cells.
                        if (board[r][c] == 1 || board[r][c] == 2) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[i][j] == 1) {

                    // Live cell dies due to underpopulation or overpopulation.
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2;
                    }

                } else {

                    // Dead cell becomes alive through reproduction.
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Convert temporary states into their final states.
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;

                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        GameOfLife solution = new GameOfLife();

        int[][] board1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        solution.gameOfLife(board1);

        for (int[] row : board1) {
            System.out.println(java.util.Arrays.toString(row));
        }

        System.out.println();

        int[][] board2 = {
            {1, 1},
            {1, 0}
        };

        solution.gameOfLife(board2);

        for (int[] row : board2) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}