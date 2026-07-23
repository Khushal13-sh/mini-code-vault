/*
 add solution for finding longest alternating even odd subarray
*/

/**
 * Problem: Longest Even Odd Subarray With Threshold
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums and an integer threshold,
 * find the length of the longest subarray that:
 *
 * - Starts with an even number.
 * - Alternates between even and odd numbers.
 * - Contains only elements less than or equal to threshold.
 *
 * Return the maximum valid subarray length.
 *
 * Key Insight:
 * - Try every valid starting index.
 * - The first element must be even and within the threshold.
 * - Extend the subarray while the threshold and
 *   alternating parity conditions are satisfied.
 *
 * Approach:
 * - Traverse every index as a possible starting point.
 * - Skip numbers that are odd or greater than threshold.
 * - Expand the subarray until any condition fails.
 * - Track the maximum valid length.
 *
 * Why this works:
 * Every valid starting position is explored,
 * and the subarray is extended only while all
 * required conditions remain true.
 *
 * Time Complexity: O(n²)
 * Each index may expand through the remaining array.
 *
 * Space Complexity: O(1)
 * Only a few extra variables are used.
 */
public class LongestEvenOddSubarrayWithThreshold {

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int maxLength = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                continue;
            }

            int length = 1;

            for (int j = i + 1; j < n; j++) {

                if (nums[j] > threshold) {
                    break;
                }

                if ((nums[j] % 2) == (nums[j - 1] % 2)) {
                    break;
                }

                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestEvenOddSubarrayWithThreshold obj =
                new LongestEvenOddSubarrayWithThreshold();

        // Example 1
        int[] nums1 = {3, 2, 5, 4};
        System.out.println("Output 1: " +
                obj.longestAlternatingSubarray(nums1, 5));

        // Example 2
        int[] nums2 = {1, 2};
        System.out.println("Output 2: " +
                obj.longestAlternatingSubarray(nums2, 2));

        // Example 3
        int[] nums3 = {2, 3, 4, 5};
        System.out.println("Output 3: " +
                obj.longestAlternatingSubarray(nums3, 4));
    }
}