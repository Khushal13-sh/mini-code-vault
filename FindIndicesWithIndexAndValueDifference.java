/*
 add brute force solution for finding indices with index and value difference
*/

/**
 * Problem: Find Indices With Index and Value Difference I
 * Difficulty: Easy
 *
 * Description:
 * Find two indices i and j such that:
 * - abs(i - j) >= indexDifference
 * - abs(nums[i] - nums[j]) >= valueDifference
 *
 * Return any valid pair of indices.
 * If no such pair exists, return [-1, -1].
 *
 * Key Insight:
 * - Constraints are very small (n <= 100)
 * - We can check every possible pair of indices
 * - As soon as a valid pair is found, return it
 *
 * Approach:
 * - Iterate through all pairs (i, j)
 * - Check both required conditions
 * - Return the first valid pair found
 * - If no pair satisfies the conditions, return [-1, -1]
 *
 * Why this works:
 * Every possible pair is examined exactly once,
 * guaranteeing that a valid answer is found if it exists.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */
public class FindIndicesWithIndexAndValueDifference {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (Math.abs(i - j) >= indexDifference &&
                    Math.abs(nums[i] - nums[j]) >= valueDifference) {

                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FindIndicesWithIndexAndValueDifference obj =
                new FindIndicesWithIndexAndValueDifference();

        // Example 1
        int[] nums1 = {5, 1, 4, 1};
        int[] result1 = obj.findIndices(nums1, 2, 4);
        System.out.println("Output 1: [" + result1[0] + ", " + result1[1] + "]");

        // Example 2
        int[] nums2 = {2, 1};
        int[] result2 = obj.findIndices(nums2, 0, 0);
        System.out.println("Output 2: [" + result2[0] + ", " + result2[1] + "]");

        // Example 3
        int[] nums3 = {1, 2, 3};
        int[] result3 = obj.findIndices(nums3, 2, 4);
        System.out.println("Output 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}