/**
 * Problem: Maximize Sum of At Most K Distinct Elements
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums and an integer k,
 * choose at most k distinct elements to maximize the sum.
 * Return the chosen elements in strictly descending order.
 *
 * Example:
 * Input: nums = [84,93,100,77,90], k = 3
 * Output: [100,93,90]
 *
 * Approach:
 * - Sort array in ascending order.
 * - Traverse from the end to pick largest distinct elements.
 * - Stop once we’ve picked k distinct numbers.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class MaxKDistinct {

    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] distinct = new int[n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (count == 0 || nums[i] != distinct[count - 1]) {
                distinct[count++] = nums[i];
                if (count == k) break;
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = distinct[i];
        }

        return result;
    }

    // main method for testing examples
    public static void main(String[] args) {
        MaxKDistinct solution = new MaxKDistinct();

        // Example 1
        int[] nums1 = {84, 93, 100, 77, 90};
        int k1 = 3;
        System.out.println("Example 1 Output: " + Arrays.toString(solution.maxKDistinct(nums1, k1)));
        // Expected: [100, 93, 90]

        // Example 2
        int[] nums2 = {84, 93, 100, 77, 93};
        int k2 = 3;
        System.out.println("Example 2 Output: " + Arrays.toString(solution.maxKDistinct(nums2, k2)));
        // Expected: [100, 93, 84]

        // Example 3
        int[] nums3 = {1, 1, 1, 2, 2, 2};
        int k3 = 6;
        System.out.println("Example 3 Output: " + Arrays.toString(solution.maxKDistinct(nums3, k3)));
        // Expected: [2, 1]
    }
}
