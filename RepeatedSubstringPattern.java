/**
 * Problem: Repeated Substring Pattern
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 *
 * 🧪 Examples:
 * Input: "abab" ➞ Output: true       (because "ab" + "ab")
 * Input: "aba" ➞ Output: false
 * Input: "abcabcabcabc" ➞ Output: true   (because "abc" repeated 4 times)
 */

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        // Try all possible substring lengths from 1 to len/2
        for (int i = 1; i <= len / 2; i++) {
            // If the length can divide the whole string evenly
            if (len % i == 0) {
                String sub = s.substring(0, i); // candidate substring
                StringBuilder repeated = new StringBuilder();

                // Repeat the substring enough times
                for (int j = 0; j < len / i; j++) {
                    repeated.append(sub);
                }

                // Check if it matches the original string
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));           // true
        System.out.println(repeatedSubstringPattern("aba"));            // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));   // true
        System.out.println(repeatedSubstringPattern("a"));              // false
        System.out.println(repeatedSubstringPattern("ababab"));         // true
    }
}
