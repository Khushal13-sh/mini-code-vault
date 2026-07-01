/*
 add solution for finding maximum unique subarray sum after deletion
*/

/**
 * Problem: Maximum Unique Subarray Sum After Deletion
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, you may delete any
 * number of elements (without making the array empty).
 *
 * After deletion, choose a subarray such that:
 * - All elements are unique.
 * - The sum of the subarray is maximized.
 *
 * Return the maximum possible sum.
 *
 * Key Insight:
 * - Since deletions are allowed, all negative values
 *   and duplicate positive values can be removed.
 * - Keep each positive value only once.
 * - If every value is non-positive, return the
 *   largest element.
 *
 * Approach:
 * - Traverse the array once.
 * - Track the maximum element.
 * - Store each unique positive number in a HashSet.
 * - Add each unique positive number to the sum.
 * - If the sum is positive, return it.
 * - Otherwise, return the maximum element.
 *
 * Why this works:
 * Removing negative numbers always increases the sum,
 * and duplicate positive values do not help because
 * the chosen subarray must contain unique elements.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 * HashSet stores unique positive elements.
 */
import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {

    public int maxSum(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {

            max = Math.max(max, num);

            if (num > 0 && !seen.contains(num)) {
                seen.add(num);
                sum += num;
            }
        }

        return sum > 0 ? sum : max;
    }

    public static void main(String[] args) {

        MaximumUniqueSubarraySumAfterDeletion obj =
                new MaximumUniqueSubarraySumAfterDeletion();

        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Output 1: " +
                obj.maxSum(nums1));

        // Example 2
        int[] nums2 = {1, 1, 0, 1, 1};
        System.out.println("Output 2: " +
                obj.maxSum(nums2));

        // Example 3
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1};
        System.out.println("Output 3: " +
                obj.maxSum(nums3));
    }
}