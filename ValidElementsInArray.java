/*
 add solution for finding valid elements in array using prefix and suffix maximums
*/

/**
 * Problem: Valid Elements in an Array
 * Difficulty: Easy
 *
 * Description:
 * An element is considered valid if:
 * 1. It is strictly greater than every element to its left
 * OR
 * 2. It is strictly greater than every element to its right
 *
 * The first and last elements are always valid.
 *
 * Return all valid elements in the same order.
 *
 * Approach:
 * - Precompute suffix maximums using rightMax[]
 * - Maintain running left maximum
 * - For every index:
 *      -> valid if greater than all left elements
 *      -> OR greater than all right elements
 *      -> OR first/last element
 *
 * Why this works:
 * - leftMax stores the maximum element seen so far on the left
 * - rightMax[i + 1] stores the maximum element on the right
 * - Comparing current value with these maximums verifies validity
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class ValidElementsInArray {

    public List<Integer> findValidElements(int[] nums) {

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Suffix maximum array
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int leftMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            boolean valid = false;

            // First and last elements are always valid
            if (i == 0 || i == n - 1) {
                valid = true;
            }

            // Greater than all elements on the left
            else if (nums[i] > leftMax) {
                valid = true;
            }

            // Greater than all elements on the right
            else if (nums[i] > rightMax[i + 1]) {
                valid = true;
            }

            if (valid) {
                ans.add(nums[i]);
            }

            leftMax = Math.max(leftMax, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        ValidElementsInArray obj = new ValidElementsInArray();

        // Example 1
        int[] nums1 = {1, 2, 4, 2, 3, 2};
        System.out.println("Output 1: " + obj.findValidElements(nums1));
        // [1, 2, 4, 3, 2]

        // Example 2
        int[] nums2 = {5, 5, 5, 5};
        System.out.println("Output 2: " + obj.findValidElements(nums2));
        // [5, 5]

        // Example 3
        int[] nums3 = {1};
        System.out.println("Output 3: " + obj.findValidElements(nums3));
        // [1]
    }
}