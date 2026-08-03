/*
 add solution for counting valid prefixes
*/

/**
 * Problem: Count Valid Prefixes
 * Difficulty: Easy
 *
 * Description:
 * You are given a binary string s.
 *
 * A prefix is considered valid if its characters
 * can be rearranged to form an alternating string.
 *
 * Return the number of valid prefixes.
 *
 * Key Insight:
 * - A binary string can be rearranged into an
 *   alternating string only if the difference
 *   between the counts of '0' and '1'
 *   is at most 1.
 *
 * Approach:
 * - Traverse the string one character at a time.
 * - Count the number of zeros and ones
 *   in the current prefix.
 * - If |zeros - ones| <= 1,
 *   increment the answer.
 * - Return the total count.
 *
 * Why this works:
 * A binary string can form an alternating pattern
 * if the counts of zeros and ones differ
 * by no more than one.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only a few variables are used.
 */
public class CountValidPrefixes {

    public int countValidPrefixes(String s) {

        int zeros = 0;
        int ones = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }

            if (Math.abs(zeros - ones) <= 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountValidPrefixes obj = new CountValidPrefixes();

        // Example 1
        String s1 = "00101";
        System.out.println("Output 1: " + obj.countValidPrefixes(s1));

        // Example 2
        String s2 = "101";
        System.out.println("Output 2: " + obj.countValidPrefixes(s2));
    }
}