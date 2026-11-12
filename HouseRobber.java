
/*
 * Problem: House Robber
 *
 * Description:
 * Given an array where each element represents the money
 * available in a house, find the maximum money that can
 * be robbed without robbing two adjacent houses.
 *
 * Approach: Bottom-Up Dynamic Programming
 *
 * At every house, we have two choices:
 *
 * 1. Rob the current house:
 *    Add its money to the maximum money collected
 *    up to the house before the previous one.
 *
 * 2. Skip the current house:
 *    Keep the maximum money collected up to
 *    the previous house.
 *
 * Recurrence:
 * dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HouseRobber {

    public int rob(int[] nums) {

        int n = nums.length;

        // If there is only one house, rob that house.
        if (n == 1) {
            return nums[0];
        }

        // dp[i] stores the maximum money that can be
        // robbed from house 0 to house i.
        int[] dp = new int[n];

        // Base case: Only the first house is available.
        dp[0] = nums[0];

        // Base case: Choose the house with more money
        // because two adjacent houses cannot be robbed.
        dp[1] = Math.max(nums[0], nums[1]);

        // Calculate the maximum money for each
        // remaining house.
        for (int i = 2; i < n; i++) {

            // Option 1: Rob the current house.
            // We must skip the previous house.
            int robCurrent = nums[i] + dp[i - 2];

            // Option 2: Skip the current house.
            // Keep the previous maximum.
            int skipCurrent = dp[i - 1];

            // Choose the option that gives more money.
            dp[i] = Math.max(robCurrent, skipCurrent);
        }

        // The last element contains the maximum
        // money that can be robbed from all houses.
        return dp[n - 1];
    }

    public static void main(String[] args) {

        HouseRobber solution = new HouseRobber();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Output: " + solution.rob(nums1));
        // Expected: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Output: " + solution.rob(nums2));
        // Expected: 12

        int[] nums3 = {5};
        System.out.println("Output: " + solution.rob(nums3));
        // Expected: 5

        int[] nums4 = {2, 1, 1, 2};
        System.out.println("Output: " + solution.rob(nums4));
        // Expected: 4
    }
}
