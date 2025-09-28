/**
 * Problem: Jump Game II
 * Difficulty: Medium
 *
 * Given an array nums, each element represents the maximum forward jump from that index.
 * Return the minimum number of jumps to reach the last index.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: Jump from index 0 → 1 → 4 (last index)
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - 0 <= nums[i] <= 1000
 * - It is guaranteed that you can reach nums[n - 1]
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums1)); // 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2)); // 2

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solution.jump(nums3)); // 3
    }
}
