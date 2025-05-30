/**
 * Problem: Minimum Moves to Convert String
 * Difficulty: Easy
 *
 * 🧠 Description:
 * You are given a string s of characters 'X' and 'O'.
 * In one move, you can select 3 consecutive characters and convert them to 'O'.
 * Return the minimum number of moves to convert the entire string to 'O'.
 *
 * 📥 Example:
 * Input: s = "XXOX"
 * Output: 2
 * Explanation:
 * XXOX -> OOOX -> OOOO
 *
 * 🧪 Constraints:
 * - 3 <= s.length <= 1000
 * - s[i] is either 'X' or 'O'
 */

public class MinimumMovesToConvertString {

    // ✅ Optimal solution in O(n) time
    public static int minimumMoves(String s) {
        int moves = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                moves++;
                i += 3; // Skip the next 2 characters since they will be turned to 'O'
            } else {
                i++;
            }
        }

        return moves;
    }

    // 🧪 Test the function
    public static void main(String[] args) {
        String s1 = "XXX";
        String s2 = "XXOX";
        String s3 = "OOOO";
        String s4 = "XOXOXOXOXOXO";

        System.out.println(minimumMoves(s1)); // 1
        System.out.println(minimumMoves(s2)); // 2
        System.out.println(minimumMoves(s3)); // 0
        System.out.println(minimumMoves(s4)); // 4
    }
}
