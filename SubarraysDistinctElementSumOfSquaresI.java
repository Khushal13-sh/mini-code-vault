/*
 add solution for calculating sum of squares of distinct counts of all subarrays
*/

/**
 * Problem: Subarrays Distinct Element Sum of Squares I
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, find the sum of the squares
 * of the number of distinct elements in every possible
 * non-empty subarray.
 *
 * Key Insight:
 * - Start a subarray from every possible index.
 * - Use a boolean array to keep track of elements already seen.
 * - Whenever a new distinct element is found, increase
 *   the distinct count.
 * - Add distinct * distinct to the answer for every subarray.
 *
 * Approach:
 * - Use the first loop to choose the starting index.
 * - Use the second loop to extend the subarray.
 * - Track distinct elements using a boolean array.
 * - For every subarray, add the square of its distinct count.
 * - Return the final sum.
 *
 * Why this works:
 * Every possible subarray is considered exactly once.
 * The distinct count is updated as the subarray expands,
 * allowing us to calculate its contribution immediately.
 *
 * Time Complexity: O(n²)
 * Every possible subarray is visited once.
 *
 * Space Complexity: O(1)
 * The boolean array has a fixed size of 101 based on
 * the given value constraint.
 */
public class SubarraysDistinctElementSumOfSquaresI {

    public int sumCounts(List<Integer> nums) {

        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            boolean[] seen = new boolean[101];
            int distinct = 0;

            for (int j = i; j < n; j++) {

                int value = nums.get(j);

                if (!seen[value]) {
                    seen[value] = true;
                    distinct++;
                }

                ans += distinct * distinct;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        SubarraysDistinctElementSumOfSquaresI obj =
                new SubarraysDistinctElementSumOfSquaresI();

        // Example 1
        List<Integer> nums1 = Arrays.asList(1, 2, 1);
        System.out.println("Output 1: " +
                obj.sumCounts(nums1));

        // Example 2
        List<Integer> nums2 = Arrays.asList(1, 1);
        System.out.println("Output 2: " +
                obj.sumCounts(nums2));
    }
}