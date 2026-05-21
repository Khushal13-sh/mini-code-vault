/*
 add solution for adjacent increasing subarrays detection using simulation
*/

/**
 * Problem: Adjacent Increasing Subarrays Detection I
 * Difficulty: Easy
 *
 * Description:
 * Check whether there exist two adjacent subarrays of length k
 * such that both subarrays are strictly increasing.
 *
 * Key Insight:
 * - Two subarrays are adjacent if:
 *      secondStart = firstStart + k
 * - Each subarray must satisfy:
 *      nums[i] < nums[i + 1]
 *
 * Approach:
 * - Try every possible starting index
 * - Check if the first subarray of length k is strictly increasing
 * - Check if the second adjacent subarray is also strictly increasing
 * - Return true if both conditions are satisfied
 *
 * Why this works:
 * We directly verify the problem conditions for every valid pair
 * of adjacent subarrays.
 *
 * Time Complexity: O(n * k)
 * n = size of array
 *
 * Space Complexity: O(1)
 */
public class AdjacentIncreasingSubarraysDetection {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();

        for (int start = 0; start <= n - 2 * k; start++) {

            boolean firstIncreasing = true;

            // Check first subarray
            for (int i = start; i < start + k - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    firstIncreasing = false;
                    break;
                }
            }

            if (!firstIncreasing) {
                continue;
            }

            boolean secondIncreasing = true;

            // Check second adjacent subarray
            for (int i = start + k; i < start + 2 * k - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    secondIncreasing = false;
                    break;
                }
            }

            if (secondIncreasing) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AdjacentIncreasingSubarraysDetection obj =
                new AdjacentIncreasingSubarraysDetection();

        // Example 1
        List<Integer> nums1 =
                Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);

        System.out.println(
                "Output 1: " +
                obj.hasIncreasingSubarrays(nums1, 3)
        ); // true

        // Example 2
        List<Integer> nums2 =
                Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);

        System.out.println(
                "Output 2: " +
                obj.hasIncreasingSubarrays(nums2, 5)
        ); // false
    }
}