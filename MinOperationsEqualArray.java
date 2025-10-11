/**
 * Problem: Minimum Operations to Equalize Array
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums.
 * In one operation, choose any subarray nums[l...r] and replace all elements
 * with the bitwise AND of that subarray.
 *
 * Return the minimum number of operations required to make all elements equal.
 *
 * Example:
 * Input: nums = [1, 2]
 * Output: 1
 *
 * Explanation:
 * Choose subarray [0...1]: (1 AND 2) = 0 → nums becomes [0, 0].
 * All elements are now equal in one operation.
 *
 * Approach:
 * - If all elements are already equal, return 0.
 * - Otherwise, we can always make all elements equal in 1 operation
 *   by applying the AND on the entire array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class MinOperationsEqualArray {

    public int minOperations(int[] nums) {
        int n = nums.length;

        // Check if all elements are already equal
        boolean allEqual = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[0]) {
                allEqual = false;
                break;
            }
        }

        if (allEqual) return 0; // already equal

        // Otherwise, one operation is enough
        return 1;
    }

    // main method for testing examples
    public static void main(String[] args) {
        MinOperationsEqualArray solution = new MinOperationsEqualArray();

        // Example 1
        int[] nums1 = {1, 2};
        System.out.println("Example 1 Output: " + solution.minOperations(nums1));
        // Expected: 1

        // Example 2
        int[] nums2 = {5, 5, 5};
        System.out.println("Example 2 Output: " + solution.minOperations(nums2));
        // Expected: 0

        // Example 3
        int[] nums3 = {4, 6, 8};
        System.out.println("Example 3 Output: " + solution.minOperations(nums3));
        // Expected: 1
    }
}
