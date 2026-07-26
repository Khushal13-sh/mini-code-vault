/*
 add solution for calculating average of even numbers divisible by three
*/

/**
 * Problem: Average Value of Even Numbers That Are Divisible by Three
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, find the average of all
 * positive integers that are both even and divisible by 3.
 *
 * The average is rounded down to the nearest integer.
 * If no number satisfies the condition, return 0.
 *
 * Key Insight:
 * - A number must satisfy both conditions:
 *   - num % 2 == 0
 *   - num % 3 == 0
 * - Track the sum and count of valid numbers.
 *
 * Approach:
 * - Traverse the array.
 * - Check whether each number is even and divisible by 3.
 * - Add valid numbers to the sum and increase the count.
 * - Return sum / count if at least one valid number exists.
 * - Otherwise, return 0.
 *
 * Why this works:
 * Every valid number contributes to both the total sum
 * and the number of elements used for calculating the average.
 *
 * Time Complexity: O(n)
 * The array is traversed once.
 *
 * Space Complexity: O(1)
 * Only sum and count variables are used.
 */
public class AverageValueOfEvenNumbersDivisibleByThree {

    public int averageValue(int[] nums) {

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    public static void main(String[] args) {

        AverageValueOfEvenNumbersDivisibleByThree obj =
                new AverageValueOfEvenNumbersDivisibleByThree();

        // Example 1
        int[] nums1 = {1, 3, 6, 10, 12, 15};
        System.out.println("Output 1: " +
                obj.averageValue(nums1));

        // Example 2
        int[] nums2 = {1, 2, 4, 7, 10};
        System.out.println("Output 2: " +
                obj.averageValue(nums2));
    }
}