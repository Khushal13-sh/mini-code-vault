/*
 add solution for counting incremovable subarrays
*/

/**
 * Problem: Count the Number of Incremovable Subarrays I
 * Difficulty: Easy
 *
 * Description:
 * Given an array of positive integers nums,
 * a subarray is called incremovable if removing it
 * makes the remaining array strictly increasing.
 *
 * Return the total number of incremovable subarrays.
 *
 * Note:
 * - The removed subarray must be non-empty.
 * - An empty remaining array is considered
 *   strictly increasing.
 *
 * Key Insight:
 * - Try every possible subarray [l...r].
 * - Remove it virtually.
 * - Check whether the remaining elements form
 *   a strictly increasing sequence.
 *
 * Approach:
 * - Generate all possible subarrays.
 * - For each subarray:
 *   - Skip its elements.
 *   - Verify the remaining array is strictly increasing.
 * - Count all valid removals.
 *
 * Why this works:
 * - Every possible removable subarray is checked.
 * - A subarray is counted only when the remaining
 *   elements satisfy the strictly increasing condition.
 *
 * Time Complexity: O(n³)
 * - O(n²) subarrays
 * - O(n) check for each subarray
 *
 * Space Complexity: O(1)
 */
public class CountIncremovableSubarrays {

    public int incremovableSubarrayCount(int[] nums) {

        int n = nums.length;
        int count = 0;

        for (int left = 0; left < n; left++) {

            for (int right = left; right < n; right++) {

                int previous = -1;
                boolean increasing = true;

                for (int i = 0; i < n; i++) {

                    if (i >= left && i <= right) {
                        continue;
                    }

                    if (previous != -1 && nums[i] <= previous) {
                        increasing = false;
                        break;
                    }

                    previous = nums[i];
                }

                if (increasing) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountIncremovableSubarrays obj =
                new CountIncremovableSubarrays();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(
                "Output 1: " +
                obj.incremovableSubarrayCount(nums1));

        // Example 2
        int[] nums2 = {6, 5, 7, 8};
        System.out.println(
                "Output 2: " +
                obj.incremovableSubarrayCount(nums2));

        // Example 3
        int[] nums3 = {8, 7, 6, 6};
        System.out.println(
                "Output 3: " +
                obj.incremovableSubarrayCount(nums3));
    }
}