/**
 * Problem: Furthest Point From Origin
 * Difficulty: Easy
 *
 * Description:
 * You are given a string `moves` of length n, containing characters:
 * - 'L' → move left
 * - 'R' → move right
 * - '_' → can move either left or right
 *
 * Starting from origin (0), return the maximum distance you can reach
 * from origin after making all moves optimally.
 *
 * Example 1:
 * Input: moves = "L_RL__R"
 * Output: 3
 * Explanation: Sequence "LLRLLLR" → position -3 → distance = 3
 *
 * Example 2:
 * Input: moves = "_R__LL_"
 * Output: 5
 * Explanation: Sequence "LRLLLLL" → position -5 → distance = 5
 *
 * Example 3:
 * Input: moves = "_______"
 * Output: 7
 * Explanation: Sequence "RRRRRRR" → position 7 → distance = 7
 *
 * Constraints:
 * 1 <= moves.length <= 50
 * moves consists only of {'L', 'R', '_'}
 *
 * Approach:
 * - Count net displacement from fixed moves (L and R).
 * - Count number of '_' (flexible moves).
 * - Max distance = |net displacement| + underscores
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class FurthestPointFromOrigin {

    /**
     * Returns the maximum distance from origin after all moves.
     *
     * @param moves String containing moves
     * @return maximum distance from origin
     */
    public int furthestDistanceFromOrigin(String moves) {
        int pos = 0;          // net displacement from fixed moves
        int underscore = 0;   // count of flexible moves '_'

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                pos--;
            } else if (c == 'R') {
                pos++;
            } else {
                underscore++;
            }
        }

        return absNoMath(pos) + underscore;
    }

    /**
     * Helper method to compute absolute value without Math.abs()
     */
    private int absNoMath(int x) {
        return (x >= 0) ? x : -x;
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();

        System.out.println("Output: " + solution.furthestDistanceFromOrigin("L_RL__R")); // Expected 3
        System.out.println("Output: " + solution.furthestDistanceFromOrigin("_R__LL_")); // Expected 5
        System.out.println("Output: " + solution.furthestDistanceFromOrigin("_______")); // Expected 7
        System.out.println("Output: " + solution.furthestDistanceFromOrigin("LRLR"));    // Expected 2
    }
}
