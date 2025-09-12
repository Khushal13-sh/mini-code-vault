/**
 * Problem: Longest Nice Substring
 * Difficulty: Easy
 *
 * A string s is nice if, for every letter of the alphabet that s contains,
 * it appears both in uppercase and lowercase.
 *
 * Example:
 * - "abABB" is nice because 'A'/'a' and 'B'/'b' both appear.
 * - "abA" is not nice because 'b' appears without 'B'.
 *
 * Task:
 * Given a string s, return the longest substring of s that is nice.
 * If there are multiple, return the substring of the earliest occurrence.
 * If there are none, return an empty string.
 *
 * Example 1:
 * Input: s = "YazaAay"
 * Output: "aAa"
 *
 * Example 2:
 * Input: s = "Bb"
 * Output: "Bb"
 *
 * Example 3:
 * Input: s = "c"
 * Output: ""
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of uppercase and lowercase English letters.
 */
public class LongestNiceSubstring {

    /**
     * Function to find the longest nice substring
     *
     * @param s input string
     * @return longest nice substring
     */
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            char lower = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c; // lowercase
            char upper = (c >= 'a' && c <= 'z') ? (char)(c - 32) : c; // uppercase

            if (s.indexOf(lower) == -1 || s.indexOf(upper) == -1) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        return s;
    }

    // Main method for testing
    public static void main(String[] args) {
        LongestNiceSubstring solution = new LongestNiceSubstring();

        System.out.println(solution.longestNiceSubstring("YazaAay")); // aAa
        System.out.println(solution.longestNiceSubstring("Bb"));      // Bb
        System.out.println(solution.longestNiceSubstring("c"));       // ""
        System.out.println(solution.longestNiceSubstring("dDzeE"));   // dD
    }
}
