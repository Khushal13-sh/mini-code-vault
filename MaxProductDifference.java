/**
 * Problem: Maximum Product Difference Between Two Pairs
 * Difficulty: Easy
 *
 * 🧠 Concept:
 * The goal is to find the maximum value of:
 *     (max1 * max2) - (min1 * min2)
 * Where:
 * - max1, max2 are the two largest numbers
 * - min1, min2 are the two smallest numbers
 *
 * 💡 Strategy:
 * - Iterate through the array once
 * - Track the two largest and two smallest numbers
 * - Compute the product difference using the formula above
 *
 * 🔁 Time Complexity: O(n)
 * 🧠 Space Complexity: O(1)
 */

public class MaxProductDifference {
    public static int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // Update two largest values
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // Update two smallest values
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5, 6, 2, 7, 4}));     // Output: 34
        System.out.println(maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8})); // Output: 64
        System.out.println(maxProductDifference(new int[]{1, 10, 1, 1}));        // Output: 90
    }
}
