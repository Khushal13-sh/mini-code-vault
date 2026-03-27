/*
 add solution for minimum number of flips to reverse binary string with example execution
*/

/**
 * Problem: Minimum Number of Flips to Reverse Binary String
 * Difficulty: Easy
 *
 * Description:
 * Given an integer n, convert it into its binary representation.
 * Find the minimum number of bit flips required to make the binary
 * string equal to its reversed version.
 *
 * Approach:
 * - Convert integer to binary string
 * - Reverse the string
 * - Compare both strings character by character
 * - Count mismatched positions → each mismatch requires one flip
 *
 * Note:
 * Each mismatch represents a required flip since both strings
 * must become identical.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MinimumFlipsBinaryReverse {

    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        String rev = new StringBuilder(s).reverse().toString();

        int flips = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != rev.charAt(i)) {
                flips++;
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        MinimumFlipsBinaryReverse obj = new MinimumFlipsBinaryReverse();

        // Example 1
        int n1 = 7;
        System.out.println("Output 1: " + obj.minimumFlips(n1)); // 0

        // Example 2
        int n2 = 10;
        System.out.println("Output 2: " + obj.minimumFlips(n2)); // 4
    }
}