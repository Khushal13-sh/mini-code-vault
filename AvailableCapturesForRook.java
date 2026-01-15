/**
 * Problem: Available Captures for Rook
 * Difficulty: Easy
 *
 * Count the number of pawns a rook can capture on an 8x8 chessboard.
 * The rook moves in four directions until blocked by a bishop or edge.
 */
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {

        int rookRow = 0, rookCol = 0;

        // Step 1: Find the rook position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                }
            }
        }

        // Directions: down, up, right, left
        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int count = 0;

        // Step 2: Explore all four directions
        for (int[] dir : directions) {
            int x = rookRow + dir[0];
            int y = rookCol + dir[1];

            while (x >= 0 && x < 8 && y >= 0 && y < 8) {

                // Bishop blocks the path
                if (board[x][y] == 'B') {
                    break;
                }

                // Pawn can be captured
                if (board[x][y] == 'p') {
                    count++;
                    break;
                }

                x += dir[0];
                y += dir[1];
            }
        }

        return count;
    }
}
