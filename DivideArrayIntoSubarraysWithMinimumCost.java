/*
 add solution for dividing array into three subarrays with minimum cost
*/

/**
 * Problem: Divide an Array Into Subarrays With Minimum Cost I
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums.
 * Divide the array into exactly three contiguous
 * non-empty subarrays.
 *
 * The cost of each subarray is its first element.
 *
 * Return the minimum possible total cost of the
 * three subarrays.
 *
 * Key Insight:
 * - The first subarray always starts at index 0,
 *   so nums[0] is always included in the cost.
 * - We only need to choose the starting indices
 *   of the second and third subarrays.
 * - Try every valid pair of starting positions
 *   and keep the minimum total cost.
 *
 * Approach:
 * - Fix the first subarray at index 0.
 * - Iterate over all possible starting indices
 *   for the second subarray.
 * - For each choice, iterate over all possible
 *   starting indices for the third subarray.
 * - Compute:
 *      nums[0] + nums[i] + nums[j]
 * - Return the minimum cost found.
 *
 * Why this works:
 * Every valid partition is uniquely determined
 * by the starting indices of the second and
 * third subarrays. Checking all possibilities
 * guarantees the minimum cost.
 *
 * Time Complexity: O(n²)
 *
 * Space Complexity: O(1)
 * Only a few extra variables are used.
 */
public class DivideArrayIntoSubarraysWithMinimumCost {

    public int minimumCost(int[] nums) {

        int n = nums.length;
        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                int cost = nums[0] + nums[i] + nums[j];
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }

    public static void main(String[] args) {

        DivideArrayIntoSubarraysWithMinimumCost obj =
                new DivideArrayIntoSubarraysWithMinimumCost();

        // Example 1
        int[] nums1 = {1, 2, 3, 12};
        System.out.println("Output 1: "
                + obj.minimumCost(nums1));

        // Example 2
        int[] nums2 = {5, 4, 3};
        System.out.println("Output 2: "
                + obj.minimumCost(nums2));

        // Example 3
        int[] nums3 = {10, 3, 1, 1};
        System.out.println("Output 3: "
                + obj.minimumCost(nums3));
    }
}