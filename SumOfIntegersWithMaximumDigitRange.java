/*
 add solution for summing integers with maximum digit range
*/

/**
 * Problem: Sum of Integers with Maximum Digit Range
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums,
 * the digit range of an integer is the difference
 * between its largest and smallest digit.
 *
 * Return the sum of all integers whose digit
 * range is equal to the maximum digit range
 * found in the array.
 *
 * Key Insight:
 * - Compute the digit range for each number.
 * - Track the maximum digit range encountered.
 * - Sum all numbers having the maximum digit range.
 *
 * Approach:
 * - Traverse each number in the array.
 * - Find its largest and smallest digits.
 * - Calculate the digit range.
 * - If the range is greater than the current maximum,
 *   update the maximum and reset the sum.
 * - If the range equals the maximum,
 *   add the number to the sum.
 *
 * Why this works:
 * Every number is processed once, and the
 * maximum digit range is maintained while
 * accumulating the required sum.
 *
 * Time Complexity: O(n × d)
 * where d is the number of digits in each number.
 *
 * Space Complexity: O(1)
 * Only a few extra variables are used.
 */
public class SumOfIntegersWithMaximumDigitRange {

    public int maxDigitRange(int[] nums) {

        int maxRange = -1;
        int sum = 0;

        for (int num : nums) {

            int temp = num;
            int maxDigit = 0;
            int minDigit = 9;

            while (temp > 0) {
                int digit = temp % 10;
                maxDigit = Math.max(maxDigit, digit);
                minDigit = Math.min(minDigit, digit);
                temp /= 10;
            }

            int range = maxDigit - minDigit;

            if (range > maxRange) {
                maxRange = range;
                sum = num;
            } else if (range == maxRange) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        SumOfIntegersWithMaximumDigitRange obj =
                new SumOfIntegersWithMaximumDigitRange();

        // Example 1
        int[] nums1 = {5724, 111, 350};
        System.out.println("Output 1: " +
                obj.maxDigitRange(nums1));

        // Example 2
        int[] nums2 = {90, 900};
        System.out.println("Output 2: " +
                obj.maxDigitRange(nums2));
    }
}