/*
 add solution for checking almost equivalent strings using frequency counting
*/

/**
 * Problem: Check Whether Two Strings are Almost Equivalent
 * Difficulty: Easy
 *
 * Description:
 * Two strings are considered almost equivalent if the difference
 * between the frequency of every character is at most 3.
 *
 * Return true if both strings are almost equivalent,
 * otherwise return false.
 *
 * Approach:
 * - Create two frequency arrays of size 26
 * - Count frequency of each character in both strings
 * - Compare frequency differences for every character
 * - If any difference exceeds 3, return false
 *
 * Why this works:
 * Frequency arrays allow direct comparison of character counts
 * in O(1) time for each alphabet letter.
 *
 * Time Complexity: O(n + 26)
 * Space Complexity: O(26)
 */

public class AlmostEquivalentStrings {

    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequencies
        for (int i = 0; i < word1.length(); i++) {

            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        // Compare frequency differences
        for (int i = 0; i < 26; i++) {

            if (Math.abs(freq1[i] - freq2[i]) > 3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        AlmostEquivalentStrings obj = new AlmostEquivalentStrings();

        // Example 1
        System.out.println(
            "Output 1: " +
            obj.checkAlmostEquivalent("aaaa", "bccb")
        ); // false

        // Example 2
        System.out.println(
            "Output 2: " +
            obj.checkAlmostEquivalent("abcdeef", "abaaacc")
        ); // true

        // Example 3
        System.out.println(
            "Output 3: " +
            obj.checkAlmostEquivalent("cccddabba", "babababab")
        ); // true
    }
}