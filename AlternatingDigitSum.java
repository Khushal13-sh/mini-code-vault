/**
 * Problem: Alternating Digit Sum
 * Difficulty: Easy
 *
 * Description:
 * You are given a positive integer n.
 * Each digit of n has a sign based on its position:
 *  - The most significant digit (first digit) is assigned a positive sign.
 *  - Each following digit alternates the sign (positive → negative → positive ...).
 *
 * Task:
 * Return the sum of all digits with their corresponding sign.
 *
 * Example 1:
 * Input: n = 521
 * Output: 4
 * Explanation: (+5) + (-2) + (+1) = 4
 *
 * Example 2:
 * Input: n = 111
 * Output: 1
 * Explanation: (+1) + (-1) + (+1) = 1
 *
 * Example 3:
 * Input: n = 886996
 * Output: 0
 * Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 *
 * Constraints:
 * 1 <= n <= 10^9
 *
 * Approach:
 * 1. Convert the integer to a string to access digits easily.
 * 2. Iterate over digits:
 *    - If the index is even, add the digit.
 *    - If the index is odd, subtract the digit.
 * 3. Return the sum.
 *
 * Time Complexity: O(d), where d = number of digits in n
 * Space Complexity: O(1) (only uses a few variables)
 */

public class AlternatingDigitSum {

    /**
     * Method to calculate the alternating digit sum.
     */
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum -= digit;
            }
        }
        return sum;
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        AlternatingDigitSum solution = new AlternatingDigitSum();

        System.out.println("Input: 521 → Output: " + solution.alternateDigitSum(521));   // 4
        System.out.println("Input: 111 → Output: " + solution.alternateDigitSum(111));   // 1
        System.out.println("Input: 886996 → Output: " + solution.alternateDigitSum(886996)); // 0
    }
}
