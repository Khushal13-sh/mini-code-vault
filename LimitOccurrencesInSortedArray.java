/*
 add solution for limiting occurrences in sorted array
*/

/**
 * Problem: Limit Occurrences in Sorted Array
 * Difficulty: Easy
 *
 * Description:
 * Given a sorted integer array nums and an integer k,
 * return an array where each distinct element appears
 * at most k times while preserving the original order.
 *
 * If an element appears more than k times,
 * only the first k occurrences are kept.
 *
 * Key Insight:
 * - Since the array is already sorted, duplicates
 *   appear consecutively.
 * - Keep an element only if it does not exceed
 *   the allowed frequency k.
 *
 * Approach:
 * - Use a write pointer to build the result in-place.
 * - For each element:
 *   - Always keep it if fewer than k elements
 *     have been written so far.
 *   - Otherwise, compare it with the element
 *     k positions before the write pointer.
 * - If they are different, keep the current element.
 * - Return the valid portion of the array.
 *
 * Why this works:
 * - In a sorted array, identical values are grouped.
 * - Comparing with nums[write - k] ensures no value
 *   appears more than k times in the result.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Ignoring the returned output array.
 */
import java.util.Arrays;

public class LimitOccurrencesInSortedArray {

    public int[] limitOccurrences(int[] nums, int k) {

        int write = 0;

        for (int num : nums) {

            if (write < k || num != nums[write - k]) {
                nums[write++] = num;
            }
        }

        return Arrays.copyOf(nums, write);
    }

    public static void main(String[] args) {

        LimitOccurrencesInSortedArray obj =
                new LimitOccurrencesInSortedArray();

        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] result1 = obj.limitOccurrences(nums1, 2);

        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2
        int[] nums2 = {1, 2, 3};
        int[] result2 = obj.limitOccurrences(nums2, 1);

        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}