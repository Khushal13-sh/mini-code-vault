/**
 * Jump Game
 *
 * Difficulty: Medium
 *
 * Problem:
 * Given an integer array nums, determine whether you can reach
 * the last index starting from the first index.
 *
 * Each element represents the maximum jump length from that index.
 *
 * Approach:
 * Greedy
 *
 * Key Idea:
 * Keep track of the farthest index that can be reached so far.
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 */
public class JumpGame {

    /**
     * Determines whether the last index can be reached.
     *
     * @param nums input array
     * @return true if the last index is reachable,
     *         otherwise false
     */
    public boolean canJump(int[] nums) {

        // Farthest index that can currently be reached
        int farthest = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If the current index cannot be reached,
            // then the last index is also unreachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable index
            farthest = Math.max(
                    farthest,
                    i + nums[i]
            );

            // If we can already reach the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        JumpGame obj = new JumpGame();

        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};

        System.out.println(
                "Input: [2, 3, 1, 1, 4]"
        );

        System.out.println(
                "Output: " + obj.canJump(nums1)
        );

        // Example 2
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(
                "\nInput: [3, 2, 1, 0, 4]"
        );

        System.out.println(
                "Output: " + obj.canJump(nums2)
        );
    }
}