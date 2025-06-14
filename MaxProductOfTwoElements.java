/**
 * Problem: Maximum Product of Two Elements in an Array
 * Difficulty: Easy
 *
 * 🧮 Formula:
 * Choose two different indices i and j such that:
 *     result = (nums[i] - 1) * (nums[j] - 1)
 *
 * 📘 Example:
 * Input: nums = [3, 4, 5, 2]
 * Output: 12
 * Explanation: (5 - 1) * (4 - 1) = 4 * 3 = 12
 */

public class MaxProductOfTwoElements {

    public static int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Find the largest and second largest elements
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        // Apply the formula (max1 - 1) * (max2 - 1)
        return (firstMax - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 2};
        System.out.println("Max Product: " + maxProduct(nums1));  // Output: 12

        int[] nums2 = {1, 5, 4, 5};
        System.out.println("Max Product: " + maxProduct(nums2));  // Output: 16

        int[] nums3 = {3, 7};
        System.out.println("Max Product: " + maxProduct(nums3));  // Output: 12
    }
}
