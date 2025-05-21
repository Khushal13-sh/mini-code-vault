/**
 * Problem Title: Consecutive Characters
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * The **power of a string** is the maximum length of a non-empty substring 
 * that contains only one unique character.
 *
 * You are given a string `s`. Return the **power** of `s`.
 *
 * 📥 Example 1:
 * Input: s = "leetcode"
 * Output: 2
 * Explanation:
 * The substring "ee" has only 'e' repeated and has length 2.
 *
 * 📥 Example 2:
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation:
 * The substring "eeeee" has only 'e' repeated and has length 5.
 *
 * 📌 Constraints:
 * - 1 <= s.length <= 500
 * - s consists of only lowercase English letters.
 */

public class ConsecutiveCharacters {

    /**
     * 🧠 Logic:
     * - Traverse the string from index 1 to end.
     * - Compare current character with previous one.
     *   - If same: increase current power count.
     *   - If not: reset current power count to 1.
     * - Keep track of maximum power encountered.
     */
    public static int maxPower(String s) {
        if (s == null || s.length() == 0) return 0;

        int maxPower = 1;
        int currentPower = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentPower++;
                maxPower = Math.max(maxPower, currentPower);
            } else {
                currentPower = 1;
            }
        }

        return maxPower;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        String input1 = "leetcode";
        System.out.println("Max Power for \"" + input1 + "\": " + maxPower(input1)); // Expected: 2

        String input2 = "abbcccddddeeeeedcba";
        System.out.println("Max Power for \"" + input2 + "\": " + maxPower(input2)); // Expected: 5
    }
}
