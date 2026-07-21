/*
 add solution for rearranging string to satisfy character order
*/

/**
 * Problem: Rearrange String to Avoid Character Pair
 * Difficulty: Easy
 *
 * Description:
 * Given a string s and two distinct characters x and y,
 * rearrange the characters so that every occurrence of
 * y appears before every occurrence of x.
 *
 * Return any valid rearranged string.
 *
 * Key Insight:
 * - Count the frequency of every character.
 * - Place all occurrences of y first.
 * - Place all remaining characters except x and y.
 * - Place all occurrences of x at the end.
 *
 * Approach:
 * - Count the frequency of each character.
 * - Append all y characters.
 * - Append all other characters in alphabetical order,
 *   excluding x and y.
 * - Append all x characters.
 *
 * Why this works:
 * By placing every y before every x, the required
 * condition is always satisfied while preserving
 * all characters from the original string.
 *
 * Time Complexity: O(n)
 * Counting and constructing the result both take
 * linear time.
 *
 * Space Complexity: O(1)
 * A frequency array of size 26 is used.
 */
public class RearrangeStringToAvoidCharacterPair {

    public String rearrangeString(String s, char x, char y) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        while (freq[y - 'a']-- > 0) {
            ans.append(y);
        }

        for (char c = 'a'; c <= 'z'; c++) {

            if (c == x || c == y) {
                continue;
            }

            while (freq[c - 'a']-- > 0) {
                ans.append(c);
            }
        }

        while (freq[x - 'a']-- > 0) {
            ans.append(x);
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        RearrangeStringToAvoidCharacterPair obj =
                new RearrangeStringToAvoidCharacterPair();

        // Example 1
        System.out.println("Output 1: " +
                obj.rearrangeString("aabc", 'a', 'c'));

        // Example 2
        System.out.println("Output 2: " +
                obj.rearrangeString("dcab", 'd', 'b'));

        // Example 3
        System.out.println("Output 3: " +
                obj.rearrangeString("axe", 'o', 'x'));
    }
}