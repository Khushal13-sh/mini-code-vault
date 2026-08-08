/*
 add solution for finding the largest integer with given digit sum
*/

/**
 * Problem: Largest Integer With Given Digit Sum
 * Difficulty: Easy
 *
 * Description:
 * Given two non-negative integers n and s,
 * find the largest integer that has at most n digits
 * and whose sum of digits is exactly s.
 *
 * If no such integer exists, return -1.
 *
 * Key Insight:
 * - A number with n digits can have a maximum digit sum of 9 * n.
 * - To construct the largest number, place the largest
 *   possible digit at each position from left to right.
 * - Each digit can be at most 9.
 *
 * Approach:
 * - If s > 9 * n, return -1 because the required digit
 *   sum cannot be achieved.
 * - If s == 0, return 0.
 * - For each digit position:
 *   - Take the minimum of 9 and the remaining sum.
 *   - Add that digit to the answer.
 *   - Reduce the remaining sum.
 * - Return the constructed number.
 *
 * Why this works:
 * To maximize the number, we should make the leftmost
 * digit as large as possible. After choosing it, we repeat
 * the same strategy for the remaining positions.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class LargestIntegerWithGivenDigitSum {

    public int largestInteger(int n, int s) {

        // Maximum possible digit sum with n digits is 9 * n
        if (s > 9 * n) {
            return -1;
        }

        // If digit sum is 0, the only valid number is 0
        if (s == 0) {
            return 0;
        }

        int ans = 0;

        // Build the largest number from left to right
        for (int i = 0; i < n; i++) {

            int digit = Math.min(9, s);

            ans = ans * 10 + digit;

            s -= digit;
        }

        return ans;
    }

    public static void main(String[] args) {

        LargestIntegerWithGivenDigitSum obj =
                new LargestIntegerWithGivenDigitSum();

        // Example 1
        int result1 = obj.largestInteger(2, 9);
        System.out.println("Output 1: " + result1);

        // Example 2
        int result2 = obj.largestInteger(2, 19);
        System.out.println("Output 2: " + result2);

        // Example 3
        int result3 = obj.largestInteger(5, 0);
        System.out.println("Output 3: " + result3);
    }
}