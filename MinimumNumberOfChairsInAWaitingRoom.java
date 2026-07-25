/*
 add solution for finding minimum number of chairs in a waiting room
*/

/**
 * Problem: Minimum Number of Chairs in a Waiting Room
 * Difficulty: Easy
 *
 * Description:
 * Given a string s representing people entering ('E')
 * and leaving ('L') a waiting room, determine the
 * minimum number of chairs required so that every
 * entering person always has a chair.
 *
 * Key Insight:
 * - Track the number of people currently in the room.
 * - Every 'E' increases the count.
 * - Every 'L' decreases the count.
 * - The maximum number of people present at any time
 *   equals the minimum number of chairs needed.
 *
 * Approach:
 * - Initialize current people count to 0.
 * - Traverse the string:
 *   - Increment the count for 'E'.
 *   - Decrement the count for 'L'.
 * - Update the maximum count after each entry.
 * - Return the maximum count.
 *
 * Why this works:
 * The maximum occupancy of the waiting room determines
 * the minimum number of chairs required.
 *
 * Time Complexity: O(n)
 * The string is traversed once.
 *
 * Space Complexity: O(1)
 * Only a few integer variables are used.
 */
public class MinimumNumberOfChairsInAWaitingRoom {

    public int minimumChairs(String s) {

        int current = 0;
        int maxChairs = 0;

        for (char ch : s.toCharArray()) {

            if (ch == 'E') {
                current++;
                maxChairs = Math.max(maxChairs, current);
            } else {
                current--;
            }
        }

        return maxChairs;
    }

    public static void main(String[] args) {

        MinimumNumberOfChairsInAWaitingRoom obj =
                new MinimumNumberOfChairsInAWaitingRoom();

        // Example 1
        System.out.println("Output 1: " +
                obj.minimumChairs("EEEEEEE"));

        // Example 2
        System.out.println("Output 2: " +
                obj.minimumChairs("ELELEEL"));

        // Example 3
        System.out.println("Output 3: " +
                obj.minimumChairs("ELEELEELLL"));
    }
}