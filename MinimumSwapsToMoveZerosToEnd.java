/*
 add solution for finding minimum swaps to move all zeros to the end
*/

/**
 * Problem: Minimum Swaps to Move Zeros to End
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, in one operation you
 * can swap any two distinct elements.
 *
 * Return the minimum number of swaps required to move
 * all zeros to the end of the array.
 *
 * Key Insight:
 * - Count the total number of zeros.
 * - The last 'zeroCount' positions should contain all zeros.
 * - Any zero found before this region must be swapped
 *   with a non-zero from the end region.
 *
 * Approach:
 * - Count the number of zeros.
 * - Compute the index where the zero region begins.
 * - Traverse the non-zero region.
 * - Count every zero found there.
 * - That count equals the minimum swaps required.
 *
 * Why this works:
 * Every misplaced zero before the final zero region
 * needs exactly one swap with a non-zero element from
 * the end of the array.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only constant extra space is used.
 */
public class MinimumSwapsToMoveZerosToEnd {

    public int minimumSwaps(int[] nums) {

        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int swaps = 0;
        int limit = nums.length - zeroCount;

        for (int i = 0; i < limit; i++) {
            if (nums[i] == 0) {
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        MinimumSwapsToMoveZerosToEnd obj =
                new MinimumSwapsToMoveZerosToEnd();

        // Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Output 1: " +
                obj.minimumSwaps(nums1));

        // Example 2
        int[] nums2 = {0, 1, 0, 2};
        System.out.println("Output 2: " +
                obj.minimumSwaps(nums2));

        // Example 3
        int[] nums3 = {1, 2, 0};
        System.out.println("Output 3: " +
                obj.minimumSwaps(nums3));
    }
}