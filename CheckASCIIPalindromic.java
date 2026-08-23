/*
 add solution for check ascii palindromic
*/

/**
 * Problem: Check ASCII Palindromic
 * Difficulty: Easy
 *
 * Description:
 * Given a string s containing lowercase English letters,
 * convert every character into its 8-bit ASCII binary
 * representation, including leading zeros.
 *
 * Concatenate all the binary representations while keeping
 * the original character order.
 *
 * Return true if the resulting binary string is a palindrome.
 * Otherwise, return false.
 *
 * Key Insight:
 * - Every character has an ASCII value.
 * - Convert each ASCII value into an 8-bit binary string.
 * - Leading zeros must be included.
 * - Append all binary strings together.
 * - Check whether the final binary string is a palindrome.
 *
 * Approach:
 * - Create a StringBuilder to store the binary string.
 * - Traverse every character in s.
 * - Convert the character to binary using
 *   Integer.toBinaryString().
 * - Add leading zeros until the length becomes 8.
 * - Append the 8-bit representation to the StringBuilder.
 * - Use two pointers to check whether the binary string
 *   is a palindrome.
 * - If any pair of characters is different, return false.
 * - If all characters match, return true.
 *
 * Why this works:
 * The problem specifically asks us to construct the complete
 * binary string and check whether it reads the same from both
 * directions.
 *
 * Since every character contributes exactly 8 bits, the final
 * binary string has length 8 * s.length().
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 */
public class CheckASCIIPalindromic {

    public boolean isPalindromic(String s) {

        StringBuilder binary = new StringBuilder();

        // Convert every character into its 8-bit ASCII
        // binary representation.
        for (char c : s.toCharArray()) {

            String bits = String.format("%8s",
                            Integer.toBinaryString(c))
                            .replace(' ', '0');

            binary.append(bits);
        }

        // Use two pointers to check the palindrome.
        int left = 0;
        int right = binary.length() - 1;

        while (left < right) {

            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        CheckASCIIPalindromic obj =
                new CheckASCIIPalindromic();

        // Example 1
        String s1 = "ff";
        boolean result1 = obj.isPalindromic(s1);

        System.out.println("Output 1: " + result1);

        // Example 2
        String s2 = "leet";
        boolean result2 = obj.isPalindromic(s2);

        System.out.println("Output 2: " + result2);
    }
}