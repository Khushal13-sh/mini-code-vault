/*
 add solution for sum of all subset xor totals
*/

/**
 * Problem: Sum of All Subset XOR Totals
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, return the sum of the XOR
 * totals of all possible subsets of nums.
 *
 * The XOR total of a subset is the bitwise XOR of all
 * elements in that subset. The XOR total of an empty
 * subset is 0.
 *
 * Key Insight:
 * - First calculate the bitwise OR of all elements.
 * - Every set bit in the OR appears in the XOR total
 *   of exactly half of all possible subsets.
 * - There are 2^n total subsets.
 * - Therefore, each set bit contributes 2^(n - 1) times.
 * - The final answer is:
 *
 *   OR of all elements * 2^(n - 1)
 *
 * Approach:
 * - Initialize OR as 0.
 * - Perform bitwise OR with every element in nums.
 * - Calculate 2^(n - 1) using Math.pow().
 * - Multiply the OR value by the multiplier.
 * - Return the result.
 *
 * Why this works:
 * For every bit that is set in at least one element,
 * exactly half of all subsets will have that bit set in
 * their XOR total.
 *
 * Therefore:
 *
 *   Answer = OR * 2^(n - 1)
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {

        int or = 0;

        // Calculate the bitwise OR of all elements.
        for (int num : nums) {
            or = or | num;
        }

        // Each set bit contributes to exactly half
        // of all possible subset XOR totals.
        int multiplier = (int) Math.pow(2, nums.length - 1);

        return or * multiplier;
    }

    public static void main(String[] args) {

        SumOfAllSubsetXORTotals obj =
                new SumOfAllSubsetXORTotals();

        // Example 1
        int[] nums1 = {1, 3};
        int result1 = obj.subsetXORSum(nums1);

        System.out.println("Output 1: " + result1);

        // Example 2
        int[] nums2 = {5, 1, 6};
        int result2 = obj.subsetXORSum(nums2);

        System.out.println("Output 2: " + result2);

        // Example 3
        int[] nums3 = {3, 4, 5, 6, 7, 8};
        int result3 = obj.subsetXORSum(nums3);

        System.out.println("Output 3: " + result3);
    }
}