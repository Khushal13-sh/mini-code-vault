/*
 add solution for minimum operations to make array values equal to k
*/

/**
 * Problem: Minimum Operations to Make Array Values Equal to K
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums and an integer k,
 * make every element in nums equal to k using the
 * allowed operation.
 *
 * An operation selects a valid value h and changes
 * all elements greater than h to h.
 *
 * Return the minimum number of operations required.
 * If any element is smaller than k, return -1 because
 * values can only be decreased.
 *
 * Key Insight:
 * - If any number is smaller than k, it is impossible
 *   to make it equal to k.
 * - Every distinct value greater than k requires one
 *   operation.
 * - Therefore, the answer is the number of distinct
 *   values greater than k.
 *
 * Approach:
 * - Use a boolean array to keep track of values already seen.
 * - If nums[i] < k, return -1.
 * - If nums[i] > k and has not been seen before,
 *   count one operation.
 * - Return the total count.
 *
 * Why this works:
 * Each distinct value greater than k must eventually be
 * reduced to a smaller value. Because all occurrences of
 * the same value can be handled together, each distinct
 * value requires exactly one operation.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * The boolean array has a fixed size of 101.
 */
public class MinimumOperationsToMakeArrayValuesEqualToK {

    public int minOperations(int[] nums, int k) {

        boolean[] seen = new boolean[101];
        int operations = 0;

        for (int num : nums) {

            // A value smaller than k cannot be increased.
            if (num < k) {
                return -1;
            }

            // Each distinct value greater than k requires
            // one operation.
            if (num > k && !seen[num]) {
                seen[num] = true;
                operations++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {

        MinimumOperationsToMakeArrayValuesEqualToK obj =
                new MinimumOperationsToMakeArrayValuesEqualToK();

        // Example 1
        int[] nums1 = {5, 2, 5, 4, 5};
        int result1 = obj.minOperations(nums1, 2);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[] nums2 = {2, 1, 2};
        int result2 = obj.minOperations(nums2, 2);

        System.out.println("Output 2: " + result2);

        // Example 3
        int[] nums3 = {9, 7, 5, 3};
        int result3 = obj.minOperations(nums3, 1);

        System.out.println("Output 3: " + result3);
    }
}