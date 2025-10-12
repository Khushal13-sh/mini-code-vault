/**
 * Problem: Equal Score Substrings
 * Difficulty: Easy
 *
 * Description:
 * You are given a string s consisting of lowercase English letters.
 * The score of a string is the sum of positions of its characters:
 * 'a' = 1, 'b' = 2, ..., 'z' = 26.
 *
 * Determine if there exists an index i such that the string can be split into
 * two non-empty substrings s[0..i] and s[(i + 1)..(n - 1)]
 * having equal scores.
 *
 * Example:
 * Input: s = "adcb"
 * Output: true
 * 
 * Explanation:
 * Split at i = 1:
 * Left = "ad" → 1 + 4 = 5
 * Right = "cb" → 3 + 2 = 5
 * Both halves have equal score → true.
 *
 * Approach:
 * - Compute total score of string.
 * - Iterate through prefix, maintaining prefix sum.
 * - If prefixSum * 2 == totalSum, return true.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class EqualScoreSubstrings {

    public boolean scoreBalance(String s) {
        int n = s.length();
        int totalSum = 0;

        // Calculate total score
        for (char ch : s.toCharArray()) {
            totalSum += (ch - 'a' + 1);
        }

        int prefixSum = 0;

        // Check for split point
        for (int i = 0; i < n - 1; i++) {
            prefixSum += (s.charAt(i) - 'a' + 1);
            if (prefixSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }

    // main method for testing examples
    public static void main(String[] args) {
        EqualScoreSubstrings solution = new EqualScoreSubstrings();

        // Example 1
        String s1 = "adcb";
        System.out.println("Example 1 Output: " + solution.scoreBalance(s1));
        // Expected: true

        // Example 2
        String s2 = "bace";
        System.out.println("Example 2 Output: " + solution.scoreBalance(s2));
        // Expected: false

        // Example 3
        String s3 = "abc";
        System.out.println("Example 3 Output: " + solution.scoreBalance(s3));
        // Expected: false
    }
}
