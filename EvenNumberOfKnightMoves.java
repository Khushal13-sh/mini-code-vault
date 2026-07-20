/*
 add solution for checking even number of knight moves
*/

/**
 * Problem: Even Number of Knight Moves
 * Difficulty: Easy
 *
 * Description:
 * Given the starting and target positions of a knight
 * on an 8 x 8 chessboard, return true if the knight
 * can reach the target in an even number of moves.
 * Otherwise, return false.
 *
 * Key Insight:
 * - A knight always alternates the color of the square
 *   after every move.
 * - After an even number of moves, the knight remains
 *   on the same color.
 * - After an odd number of moves, it lands on the
 *   opposite color.
 *
 * Approach:
 * - Determine the color of the start square.
 * - Determine the color of the target square.
 * - If both colors are the same, return true.
 * - Otherwise, return false.
 *
 * Why this works:
 * Since every knight move changes the square color,
 * reaching a square of the same color always requires
 * an even number of moves.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 * Only a few integer variables are used.
 */
public class EvenNumberOfKnightMoves {

    public boolean canReach(int[] start, int[] target) {

        int startColor = (start[0] + start[1]) % 2;
        int targetColor = (target[0] + target[1]) % 2;

        return startColor == targetColor;
    }

    public static void main(String[] args) {

        EvenNumberOfKnightMoves obj =
                new EvenNumberOfKnightMoves();

        // Example 1
        int[] start1 = {1, 1};
        int[] target1 = {2, 2};
        System.out.println("Output 1: " +
                obj.canReach(start1, target1));

        // Example 2
        int[] start2 = {4, 5};
        int[] target2 = {6, 6};
        System.out.println("Output 2: " +
                obj.canReach(start2, target2));
    }
}