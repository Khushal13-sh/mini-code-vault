/**
 * Problem: Reverse Degree of a String
 * Difficulty: Easy
 *
 * Description:
 * For each lowercase character in string s:
 *   - Determine its position in the reversed alphabet ('a' = 26, ..., 'z' = 1).
 *   - Multiply that by its position in the string (1-indexed).
 *   - Sum up all such products.
 * Return the total as the reverse degree.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 148
 * Explanation:
 * a -> 26 * 1 = 26
 * b -> 25 * 2 = 50
 * c -> 24 * 3 = 72
 * Total = 148
 *
 * Example 2:
 * Input: s = "zaza"
 * Output: 160
 * Explanation:
 * z -> 1 * 1 = 1
 * a -> 26 * 2 = 52
 * z -> 1 * 3 = 3
 * a -> 26 * 4 = 104
 * Total = 160
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s contains only lowercase English letters.
 */

public class ReverseDegreeOfString {

    public int reverseDegree(String s) {
        int total = 0;
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int reversePos = 'z' - ch + 1; // reversed alphabet position
            int pos = i + 1;               // 1-indexed position
            total += reversePos * pos;
        }

        return total;
    }

    // --- main method for testing ---
    public static void main(String[] args) {
        ReverseDegreeOfString solution = new ReverseDegreeOfString();

        System.out.println(solution.reverseDegree("abc"));  // Expected: 148
        System.out.println(solution.reverseDegree("zaza")); // Expected: 160
        System.out.println(solution.reverseDegree("zzz"));  // Expected: 6
    }
}
