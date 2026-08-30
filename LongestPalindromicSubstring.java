/*
 add solution for longest palindromic substring
*/

/**
 * Problem: Longest Palindromic Substring
 * Difficulty: Medium
 *
 * Description:
 * Given a string s, find the longest substring that is
 * a palindrome.
 *
 * A palindrome reads the same from left to right and
 * right to left.
 *
 * Key Insight:
 * Every palindrome has a center.
 *
 * There are two possible centers:
 * - One character for odd-length palindromes.
 * - Two characters for even-length palindromes.
 *
 * Approach:
 * - Consider every index as a possible center.
 * - Expand around the center for odd-length palindromes.
 * - Expand around two adjacent characters for even-length
 *   palindromes.
 * - Keep track of the longest palindrome found.
 *
 * Time Complexity: O(n^2)
 *
 * Space Complexity: O(1)
 * We only use a few variables and do not create an
 * additional data structure.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Check for odd-length palindrome.
            int oddLength = expand(s, i, i);

            // Check for even-length palindrome.
            int evenLength = expand(s, i, i + 1);

            int length = Math.max(oddLength, evenLength);

            // Update the longest palindrome found so far.
            if (length > end - start + 1) {

                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * Expands around the given left and right positions
     * while the characters are equal.
     */
    private int expand(String s, int left, int right) {

        while (left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // Length of the palindrome before the last expansion.
        return right - left - 1;
    }

    public static void main(String[] args) {

        LongestPalindromicSubstring obj =
                new LongestPalindromicSubstring();

        // Example 1
        String s1 = "babad";
        String result1 = obj.longestPalindrome(s1);

        System.out.println("Input 1: " + s1);
        System.out.println("Output 1: " + result1);

        // Example 2
        String s2 = "cbbd";
        String result2 = obj.longestPalindrome(s2);

        System.out.println("Input 2: " + s2);
        System.out.println("Output 2: " + result2);
    }
}