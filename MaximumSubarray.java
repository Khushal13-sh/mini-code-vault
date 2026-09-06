/**
 * Maximum Subarray
 *
 * Difficulty: Medium
 *
 * Problem:
 * Given an integer array nums, find the contiguous subarray
 * with the largest sum and return its sum.
 *
 * Approach:
 * Kadane's Algorithm
 *
 * Key Idea:
 * At every element, decide whether to start a new subarray
 * or continue the previous subarray.
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 */
public class MaximumSubarray {

    /**
     * Finds the maximum sum of any contiguous subarray.
     *
     * @param nums input integer array
     * @return maximum subarray sum
     */
    public int maxSubArray(int[] nums) {

        // Maximum sum of subarray ending at current position
        int currentSum = nums[0];

        // Maximum sum found so far
        int maxSum = nums[0];

        // Start from the second element
        for (int i = 1; i < nums.length; i++) {

            // Decide whether to start a new subarray
            // or continue the existing subarray
            currentSum = Math.max(
                    nums[i],
                    currentSum + nums[i]
            );

            // Update the overall maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        MaximumSubarray obj = new MaximumSubarray();

        // Example 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(
                "Output 1: " + obj.maxSubArray(nums1)
        );

        // Example 2
        int[] nums2 = {1};

        System.out.println(
                "Output 2: " + obj.maxSubArray(nums2)
        );

        // Example 3
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(
                "Output 3: " + obj.maxSubArray(nums3)
        );
    }
}