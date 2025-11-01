/**
 * Problem: Smallest Index With Digit Sum Equal to Index
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums.
 * Return the smallest index i such that the sum of digits of nums[i] == i.
 * If no such index exists, return -1.
 *
 * Example 1:
 * Input: nums = [1,3,2]
 * Output: 2
 * Explanation: sumOfDigits(2) = 2 → equals index 2.
 *
 * Example 2:
 * Input: nums = [1,10,11]
 * Output: 1
 * Explanation:
 * - sumOfDigits(10) = 1 → equals index 1.
 * - sumOfDigits(11) = 2 → equals index 2.
 * The smallest valid index is 1.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation: No element satisfies the condition.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * -10^5 <= nums[i] <= 10^5
 */

public class SmallestIndexDigitSum {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sumOfDigits(nums[i]) == i)
                return i;
        }
        return -1;
    }

    private static int sumOfDigits(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // --- Main method to test ---
    public static void main(String[] args) {
        SmallestIndexDigitSum solution = new SmallestIndexDigitSum();

        int[] nums1 = {1, 3, 2};
        System.out.println(solution.smallestIndex(nums1)); // Expected: 2

        int[] nums2 = {1, 10, 11};
        System.out.println(solution.smallestIndex(nums2)); // Expected: 1

        int[] nums3 = {1, 2, 3};
        System.out.println(solution.smallestIndex(nums3)); // Expected: -1
    }
}
