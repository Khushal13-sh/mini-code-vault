/**
 * Problem: Maximum Odd Binary Number
 * Difficulty: Easy
 *
 * Description:
 * You are given a binary string s that contains at least one '1'.
 * 
 * You must rearrange the bits of s such that the resulting binary number is:
 *  1. Odd (last digit must be '1')
 *  2. Maximum possible value
 *
 * Note: The string can have leading zeros.
 *
 * Example 1:
 * Input:  s = "010"
 * Output: "001"
 * Explanation:
 *  - Only one '1' is available → it must go at the end → "001".
 *
 * Example 2:
 * Input:  s = "0101"
 * Output: "1001"
 * Explanation:
 *  - Last digit must be '1'
 *  - Remaining '1's should be placed at the beginning to maximize value
 *  - Remaining zeros go in the middle
 *  - Result = "1001"
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s contains only '0' and '1'
 * - s contains at least one '1'
 *
 * Approach:
 * 1. Count total number of ones and zeros.
 * 2. Place (countOnes - 1) ones at the front.
 * 3. Place all zeros in the middle.
 * 4. Place the last one at the end (to ensure odd number).
 *
 * Time Complexity: O(n), where n = length of s
 * Space Complexity: O(n)
 */
public class MaximumOddBinaryNumber {

    /**
     * Rearranges bits to create the maximum odd binary number.
     *
     * @param s input binary string
     * @return maximum odd binary number as a string
     */
    public String maximumOddBinaryNumber(String s) {
        int countOnes = 0, countZeros = 0;

        // Count 1s and 0s
        for (char c : s.toCharArray()) {
            if (c == '1') countOnes++;
            else countZeros++;
        }

        // Build result
        StringBuilder result = new StringBuilder();

        // Step 1: Place (countOnes - 1) ones at start
        for (int i = 0; i < countOnes - 1; i++) {
            result.append('1');
        }

        // Step 2: Place all zeros
        for (int i = 0; i < countZeros; i++) {
            result.append('0');
        }

        // Step 3: Place last '1' at end
        result.append('1');

        return result.toString();
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        MaximumOddBinaryNumber solution = new MaximumOddBinaryNumber();

        System.out.println("Output (010): " + solution.maximumOddBinaryNumber("010")); // 001
        System.out.println("Output (0101): " + solution.maximumOddBinaryNumber("0101")); // 1001
        System.out.println("Output (1110): " + solution.maximumOddBinaryNumber("1110")); // 1111
        System.out.println("Output (1): " + solution.maximumOddBinaryNumber("1")); // 1
    }
}
