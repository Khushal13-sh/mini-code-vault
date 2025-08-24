/**
 * Problem: Find Closest Person
 * Difficulty: Easy
 *
 * Description:
 * You are given three integers x, y, and z representing the positions of three people on a number line:
 *   - x → position of Person 1
 *   - y → position of Person 2
 *   - z → position of Person 3 (does not move)
 *
 * Both Person 1 and Person 2 move toward Person 3 at the same speed.
 *
 * Task:
 * - Return 1 if Person 1 reaches Person 3 first
 * - Return 2 if Person 2 reaches Person 3 first
 * - Return 0 if both reach Person 3 at the same time
 *
 * Example 1:
 * Input: x = 2, y = 7, z = 4
 * Output: 1
 * Explanation: Person 1 reaches in 2 steps, Person 2 in 3 steps → Person 1 is closer.
 *
 * Example 2:
 * Input: x = 2, y = 5, z = 6
 * Output: 2
 * Explanation: Person 1 needs 4 steps, Person 2 needs 1 step → Person 2 is closer.
 *
 * Example 3:
 * Input: x = 1, y = 5, z = 3
 * Output: 0
 * Explanation: Both reach in 2 steps → Tie.
 *
 * Constraints:
 * 1 <= x, y, z <= 100
 *
 * Approach:
 * - Compute absolute distance of Person 1 (|x - z|) and Person 2 (|y - z|)
 * - Compare distances and return result accordingly
 * - Custom absolute method is used instead of Math.abs()
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class FindClosestPerson {

    /**
     * Returns which person reaches closest to Person 3 first.
     */
    public int findClosest(int x, int y, int z) {
        int dist1 = absolute(x - z);
        int dist2 = absolute(y - z);

        if (dist1 < dist2) return 1;
        else if (dist2 < dist1) return 2;
        else return 0; // tie
    }

    /**
     * Custom method to calculate absolute value without Math.abs().
     */
    private int absolute(int num) {
        return num < 0 ? -num : num;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        FindClosestPerson solution = new FindClosestPerson();

        System.out.println("Input: x=2, y=7, z=4 → Output: " + solution.findClosest(2, 7, 4)); // 1
        System.out.println("Input: x=2, y=5, z=6 → Output: " + solution.findClosest(2, 5, 6)); // 2
        System.out.println("Input: x=1, y=5, z=3 → Output: " + solution.findClosest(1, 5, 3)); // 0
    }
}
