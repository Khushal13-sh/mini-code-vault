/*
 add solution for finding maximum XOR of strong pairs
*/

/**
 * Problem: Maximum Strong Pair XOR I
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, find the maximum XOR value
 * among all strong pairs.
 *
 * A pair (x, y) is considered strong if:
 *
 * |x - y| <= min(x, y)
 *
 * The same element can be chosen twice.
 *
 * Return the maximum XOR value among all valid pairs.
 *
 * Key Insight:
 * - Check every possible pair in the array.
 * - Verify whether the pair satisfies the strong pair condition.
 * - If valid, compute the XOR and update the maximum value.
 *
 * Approach:
 * - Traverse every pair using two nested loops.
 * - For each pair:
 *   - Check if |x - y| <= min(x, y).
 *   - If true, calculate x ^ y.
 *   - Update the maximum XOR found.
 * - Return the maximum XOR.
 *
 * Why this works:
 * Every possible pair is examined exactly once,
 * ensuring that the maximum XOR among all valid
 * strong pairs is found.
 *
 * Time Complexity: O(n²)
 * Every pair of elements is checked.
 *
 * Space Complexity: O(1)
 * Only a few integer variables are used.
 */
public class MaximumStrongPairXorI {

    public int maximumStrongPairXor(int[] nums) {

        int maxXor = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                int x = nums[i];
                int y = nums[j];

                if (Math.abs(x - y) <= Math.min(x, y)) {
                    maxXor = Math.max(maxXor, x ^ y);
                }
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {

        MaximumStrongPairXorI obj =
                new MaximumStrongPairXorI();

        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Output 1: " +
                obj.maximumStrongPairXor(nums1));

        // Example 2
        int[] nums2 = {10, 100};
        System.out.println("Output 2: " +
                obj.maximumStrongPairXor(nums2));

        // Example 3
        int[] nums3 = {5, 6, 25, 30};
        System.out.println("Output 3: " +
                obj.maximumStrongPairXor(nums3));
    }
}