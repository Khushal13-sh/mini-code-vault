/*
 add solution for determining the winner of a bowling game
*/

/**
 * Problem: Determine the Winner of a Bowling Game
 * Difficulty: Easy
 *
 * Description:
 * Two players play a bowling game.
 * Each turn normally scores the number of pins knocked down.
 *
 * If a player scored 10 pins in either of the previous
 * two turns, the current turn's score is doubled.
 *
 * Return:
 * - 1 if Player 1 has the higher score
 * - 2 if Player 2 has the higher score
 * - 0 if both scores are equal
 *
 * Key Insight:
 * - Calculate each player's total score independently.
 * - Double the current score only if one of the
 *   previous two turns was a strike (10 pins).
 *
 * Approach:
 * - Create a helper method to calculate a player's score.
 * - Traverse each turn.
 * - Check the previous one and two turns for a strike.
 * - Double the current turn score when required.
 * - Compare both final scores.
 *
 * Why this works:
 * The scoring rule depends only on the previous
 * two turns, making a single traversal sufficient.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only constant extra space is used.
 */
public class DetermineWinnerOfBowlingGame {

    public int isWinner(int[] player1, int[] player2) {

        int score1 = calculateScore(player1);
        int score2 = calculateScore(player2);

        if (score1 > score2) {
            return 1;
        }

        if (score2 > score1) {
            return 2;
        }

        return 0;
    }

    private int calculateScore(int[] player) {

        int score = 0;

        for (int i = 0; i < player.length; i++) {

            if ((i >= 1 && player[i - 1] == 10)
                    || (i >= 2 && player[i - 2] == 10)) {

                score += 2 * player[i];

            } else {
                score += player[i];
            }
        }

        return score;
    }

    public static void main(String[] args) {

        DetermineWinnerOfBowlingGame obj =
                new DetermineWinnerOfBowlingGame();

        // Example 1
        int[] player1 = {5, 10, 3, 2};
        int[] player2 = {6, 5, 7, 3};

        System.out.println("Winner 1: "
                + obj.isWinner(player1, player2));

        // Example 2
        int[] player3 = {3, 5, 7, 6};
        int[] player4 = {8, 10, 10, 2};

        System.out.println("Winner 2: "
                + obj.isWinner(player3, player4));

        // Example 3
        int[] player5 = {2, 3};
        int[] player6 = {4, 1};

        System.out.println("Winner 3: "
                + obj.isWinner(player5, player6));
    }
}