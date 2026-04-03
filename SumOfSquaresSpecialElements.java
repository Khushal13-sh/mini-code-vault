/*
 add solution for sum of squares of special elements using divisor logic
*/

/**
 * Problem: Sum of Squares of Special Elements
 * Difficulty: Easy
 *
 * Description:
 * Given a 1-indexed array, an element is considered special if its index divides
 * the length of the array. Return the sum of squares of such elements.
 *
 * Approach:
 * - Traverse indices from 1 to n
 * - Check if index i divides n (n % i == 0)
 * - If yes, square the element at index (i-1) and add to result
 *
 * Example:
 * nums = [1,2,3,4], n = 4
 * Special indices → 1,2,4
 * → 1² + 2² + 4² = 21
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SumOfSquaresSpecialElements {

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                int num = nums[i - 1];
                sum += num * num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfSquaresSpecialElements obj = new SumOfSquaresSpecialElements();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Output 1: " + obj.sumOfSquares(nums1)); // 21

        // Example 2
        int[] nums2 = {2, 7, 1, 19, 18, 3};
        System.out.println("Output 2: " + obj.sumOfSquares(nums2)); // 63
    }
}