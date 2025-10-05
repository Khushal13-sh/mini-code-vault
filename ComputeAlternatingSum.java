import java.util.Arrays;

/**
 * Problem: Compute Alternating Sum
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array `nums`.
 * The alternating sum is calculated as:
 * nums[0] - nums[1] + nums[2] - nums[3] + ...
 *
 * Example:
 * Input: nums = [1, 3, 5, 7]
 * Output: -4
 *
 * Approach:
 * - Traverse the array.
 * - Add the element if index is even.
 * - Subtract the element if index is odd.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ComputeAlternatingSum {

    public int alternatingSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }

    // Main method to test examples
    public static void main(String[] args) {
        ComputeAlternatingSum solution = new ComputeAlternatingSum();

        // Example 1
        int[] nums1 = {1, 3, 5, 7};
        System.out.println("Example 1 Output: " + solution.alternatingSum(nums1));
        // Expected: -4

        // Example 2
        int[] nums2 = {100};
        System.out.println("Example 2 Output: " + solution.alternatingSum(nums2));
        // Expected: 100

        // Example 3 (custom)
        int[] nums3 = {10, 5, 3, 1};
        System.out.println("Example 3 Output: " + solution.alternatingSum(nums3));
        // Expected: 10 - 5 + 3 - 1 = 7
    }
}
