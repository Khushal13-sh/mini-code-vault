/*
 add solution for finding absolute difference between
 sum of maximum and minimum k elements
*/

/**
 * Problem: Absolute Difference Between Maximum and Minimum K Elements
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums and an integer k,
 * find the absolute difference between:
 *
 * - The sum of the k largest elements.
 * - The sum of the k smallest elements.
 *
 * Return the absolute difference.
 *
 * Key Insight:
 * - Sort the array.
 * - The first k elements are the smallest.
 * - The last k elements are the largest.
 * - Compute both sums and return their absolute difference.
 *
 * Approach:
 * - Sort the array in ascending order.
 * - Traverse the first k elements to calculate the minimum sum.
 * - Traverse the last k elements to calculate the maximum sum.
 * - Return the absolute difference of the two sums.
 *
 * Why this works:
 * Sorting places the smallest elements at the beginning
 * and the largest elements at the end, allowing both
 * sums to be calculated efficiently.
 *
 * Time Complexity: O(n log n)
 * Sorting the array dominates the time complexity.
 *
 * Space Complexity: O(1)
 * No extra space is used apart from sorting.
 */
public class AbsoluteDifferenceBetweenMaximumAndMinimumKElements {

    public int absDifference(int[] nums, int k) {

        Arrays.sort(nums);

        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            minSum += nums[i];
            maxSum += nums[nums.length - 1 - i];
        }

        return Math.abs(maxSum - minSum);
    }

    public static void main(String[] args) {

        AbsoluteDifferenceBetweenMaximumAndMinimumKElements obj =
                new AbsoluteDifferenceBetweenMaximumAndMinimumKElements();

        // Example 1
        int[] nums1 = {5, 2, 2, 4};
        System.out.println("Output 1: " +
                obj.absDifference(nums1, 2));

        // Example 2
        int[] nums2 = {100};
        System.out.println("Output 2: " +
                obj.absDifference(nums2, 1));
    }
}