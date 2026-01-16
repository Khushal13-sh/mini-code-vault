/**
 * Problem: Find Winner on a Tic Tac Toe Game
 * Difficulty: Easy
 *
 * Determine the game result (A, B, Draw, or Pending)
 * using row, column, and diagonal counters.
 */
public class FindWinnerOnTicTacToe {

    public String tictactoe(int[][] moves) {

        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];

            // Player A = +1, Player B = -1
            int player = (i % 2 == 0) ? 1 : -1;

            rows[r] += player;
            cols[c] += player;

            if (r == c) diag += player;
            if (r + c == 2) antiDiag += player;

            // Check win condition
            if (Math.abs(rows[r]) == 3 ||
                Math.abs(cols[c]) == 3 ||
                Math.abs(diag) == 3 ||
                Math.abs(antiDiag) == 3) {

                return player == 1 ? "A" : "B";
            }
        }

        // No winner found
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
