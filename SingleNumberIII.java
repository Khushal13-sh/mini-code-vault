
/*
 * Problem: Single Number III
 * LeetCode: 260
 * Difficulty: Medium
 *
 * Approach: Bit Manipulation using XOR
 *
 * Every number appears twice except two unique numbers.
 *
 * Step 1:
 * XOR all elements.
 * Duplicate numbers cancel each other.
 * The result is the XOR of the two unique numbers.
 *
 * Step 2:
 * Find the rightmost set bit using:
 * xor & -xor
 *
 * This bit must be different between the two unique numbers.
 *
 * Step 3:
 * Divide all numbers into two groups based on this bit.
 *
 * Group 1: Numbers where the selected bit is set.
 * Group 2: Numbers where the selected bit is not set.
 *
 * XOR each group separately to obtain the two unique numbers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        // Step 1: XOR all elements.
        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }

        // The result contains XOR of both unique numbers.

        // Step 2: Find the rightmost set bit.
        int bit = xor & -xor;

        // Variables to store the two unique numbers.
        int num1 = 0;
        int num2 = 0;

        // Step 3: Divide numbers into two groups.
        for (int num : nums) {

            // Check whether the selected bit is set.
            if ((num & bit) != 0) {

                // Group 1: XOR numbers having this bit set.
                num1 = num1 ^ num;

            } else {

                // Group 2: XOR numbers not having this bit set.
                num2 = num2 ^ num;
            }
        }

        // Return the two unique numbers.
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

        SingleNumberIII solution = new SingleNumberIII();

        // Test Case 1
        int[] nums1 = {1, 2, 1, 3, 2, 5};

        int[] result1 = solution.singleNumber(nums1);

        System.out.println(
            result1[0] + ", " + result1[1]
        ); // 3, 5

        // Test Case 2
        int[] nums2 = {-1, 0};

        int[] result2 = solution.singleNumber(nums2);

        System.out.println(
            result2[0] + ", " + result2[1]
        ); // -1, 0

        // Test Case 3
        int[] nums3 = {0, 1};

        int[] result3 = solution.singleNumber(nums3);

        System.out.println(
            result3[0] + ", " + result3[1]
        ); // 0, 1

        // Test Case 4: Negative numbers
        int[] nums4 = {-2, -2, -5, 7};

        int[] result4 = solution.singleNumber(nums4);

        System.out.println(
            result4[0] + ", " + result4[1]
        ); // -5, 7
    }
}
