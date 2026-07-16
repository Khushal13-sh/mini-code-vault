/*
 add solution for finding minimum element after digit sum replacement
*/

/**
 * Problem: Minimum Element After Replacement With Digit Sum
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, replace each element
 * with the sum of its digits and return the minimum
 * element after all replacements.
 *
 * Key Insight:
 * - Calculate the digit sum for each number.
 * - Track the minimum digit sum while traversing
 *   the array.
 *
 * Approach:
 * - Initialize the answer as Integer.MAX_VALUE.
 * - For each element, compute its digit sum.
 * - Update the minimum value if needed.
 * - Return the minimum digit sum.
 *
 * Why this works:
 * Every element is independently replaced by the
 * sum of its digits, so checking each element once
 * guarantees the correct minimum.
 *
 * Time Complexity: O(n × d)
 * where d is the number of digits (at most 5).
 *
 * Space Complexity: O(1)
 * Only a few extra variables are used.
 */
public class MinimumElementAfterReplacementWithDigitSum {

    public int minElement(int[] nums) {

        int result = Integer.MAX_VALUE;

        for (int num : nums) {

            int digitSum = sumOfDigits(num);

            if (digitSum < result) {
                result = digitSum;
            }
        }

        return result;
    }

    private int sumOfDigits(int number) {

        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        MinimumElementAfterReplacementWithDigitSum obj =
                new MinimumElementAfterReplacementWithDigitSum();

        // Example 1
        int[] nums1 = {10, 12, 13, 14};
        System.out.println("Output 1: " + obj.minElement(nums1));

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + obj.minElement(nums2));

        // Example 3
        int[] nums3 = {999, 19, 199};
        System.out.println("Output 3: " + obj.minElement(nums3));
    }
}