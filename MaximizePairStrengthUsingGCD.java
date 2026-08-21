/*
 add solution for maximize pair strength using gcd
*/

/**
 * Problem: Maximize Pair Strength Using GCD
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, choose exactly one pair of
 * distinct indices i and j.
 *
 * The strength of a pair is:
 *
 *     (nums[i] * nums[j]) / gcd(nums[i], nums[j])²
 *
 * Return the maximum strength among all possible pairs.
 *
 * Key Insight:
 * - We need to check every possible pair of distinct elements.
 * - For each pair, calculate their GCD.
 * - Use the GCD to calculate the pair strength.
 * - Keep track of the maximum strength found.
 *
 * Approach:
 * - Use two nested loops to generate every pair (i, j).
 * - Start j from i + 1 so that:
 *   - i and j are always distinct.
 *   - The same pair is not checked twice.
 * - Calculate the GCD of nums[i] and nums[j] using
 *   the Euclidean algorithm.
 * - Calculate the strength of the pair.
 * - Update the maximum strength.
 *
 * Why this works:
 * Every possible pair of distinct indices is considered exactly
 * once. Therefore, the maximum strength found among these pairs
 * is the required answer.
 *
 * Important:
 * Use long while calculating the product and strength because
 * nums[i] * nums[j] can exceed the range of int.
 *
 * Time Complexity: O(n² * log(max(nums)))
 *
 * Space Complexity: O(1)
 */
public class MaximizePairStrengthUsingGCD {

    public long maxPairStrength(int[] nums) {

        long maxStrength = 0;

        // Try every possible pair of distinct indices.
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                // Find GCD of the two numbers.
                long gcd = findGCD(nums[i], nums[j]);

                // Calculate the strength of the pair.
                long strength =
                        ((long) nums[i] * nums[j]) /
                        (gcd * gcd);

                // Keep the maximum strength.
                maxStrength = Math.max(maxStrength, strength);
            }
        }

        return maxStrength;
    }

    /**
     * Finds the GCD of two numbers using
     * the Euclidean algorithm.
     */
    private long findGCD(long a, long b) {

        while (b != 0) {

            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        MaximizePairStrengthUsingGCD obj =
                new MaximizePairStrengthUsingGCD();

        // Example 1
        int[] nums1 = {2, 3, 5};
        long result1 = obj.maxPairStrength(nums1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[] nums2 = {4, 6, 8};
        long result2 = obj.maxPairStrength(nums2);

        System.out.println("Output 2: " + result2);

        // Example 3
        int[] nums3 = {3, 3};
        long result3 = obj.maxPairStrength(nums3);

        System.out.println("Output 3: " + result3);
    }
}