/**
 * Problem: Rings and Rods
 * Difficulty: Easy
 *
 * There are n rings and each ring is either red, green, or blue.
 * The rings are distributed across 10 rods labeled from 0 to 9.
 *
 * You are given a string `rings` of length 2n:
 * - Each pair of characters forms (color, rod).
 * - color ∈ { 'R', 'G', 'B' }.
 * - rod ∈ { '0'..'9' }.
 *
 * Return the number of rods that have all three colors of rings on them.
 *
 * Example 1:
 * Input: rings = "B0B6G0R6R0R6G9"
 * Output: 1
 *
 * Example 2:
 * Input: rings = "B0R0G0R9R0B0G0"
 * Output: 1
 *
 * Example 3:
 * Input: rings = "G4"
 * Output: 0
 *
 * Constraints:
 * - rings.length == 2 * n
 * - 1 <= n <= 100
 * - rings[i] (even index) ∈ { 'R', 'G', 'B' }
 * - rings[i] (odd index) ∈ { '0'..'9' }
 */
public class RingsAndRods {

    /**
     * Function to count rods that have all three colors
     *
     * @param rings the input string representing rings and rods
     * @return number of rods with all three colors
     */
    public int countPoints(String rings) {
        boolean[] red = new boolean[10];
        boolean[] green = new boolean[10];
        boolean[] blue = new boolean[10];

        // Process pairs of (color, rod)
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            if (color == 'R') red[rod] = true;
            else if (color == 'G') green[rod] = true;
            else if (color == 'B') blue[rod] = true;
        }

        // Count rods having all three colors
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (red[i] && green[i] && blue[i]) {
                count++;
            }
        }
        return count;
    }

    // Quick testing
    public static void main(String[] args) {
        RingsAndRods solution = new RingsAndRods();

        System.out.println(solution.countPoints("B0B6G0R6R0R6G9")); // 1
        System.out.println(solution.countPoints("B0R0G0R9R0B0G0")); // 1
        System.out.println(solution.countPoints("G4"));              // 0
    }
}
