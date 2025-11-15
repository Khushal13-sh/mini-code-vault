/**
 * Problem: Minimum Positive Sum Subarray
 * Difficulty: Easy
 *
 * You are given:
 * - nums → an integer list
 * - l, r → the allowed subarray length range [l, r]
 *
 * Task:
 * Find the minimum **positive** sum of any subarray whose length is between l and r (inclusive).
 *
 * Rules:
 * - A subarray must be contiguous.
 * - Only consider subarrays with sum > 0.
 * - If no such subarray exists, return -1.
 *
 * Example:
 *  nums = [3, -2, 1, 4], l = 2, r = 3
 *  Valid subarrays with positive sums:
 *      [3, -2] = 1   ← minimum positive sum
 *      [1, 4] = 5
 *      [3, -2, 1] = 2
 *      [-2, 1, 4] = 3
 *  Output: 1
 */

import java.util.*;

class Solution {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;
        boolean found = false;

        for (int start = 0; start < n; start++) {

            for (int len = l; len <= r; len++) {
                int end = start + len;
                if (end > n) break;

                int sum = prefix[end] - prefix[start];

                if (sum > 0) {
                    found = true;
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return found ? minSum : -1;
    }

    // -------------------- MAIN METHOD WITH EXAMPLES --------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<Integer> nums1 = Arrays.asList(3, -2, 1, 4);
        System.out.println(sol.minimumSumSubarray(nums1, 2, 3)); 
        // Expected Output: 1

        List<Integer> nums2 = Arrays.asList(-2, 2, -3, 1);
        System.out.println(sol.minimumSumSubarray(nums2, 2, 3)); 
        // Expected Output: -1

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        System.out.println(sol.minimumSumSubarray(nums3, 2, 4)); 
        // Expected Output: 3
    }
}
