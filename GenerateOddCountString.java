/**
 * Problem Title: Generate a String With Characters That Have Odd Counts
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * Given an integer `n`, return a string with `n` lowercase English letters such that:
 * - Every character in the string appears **an odd number of times**.
 * - If multiple answers exist, return **any one** of them.
 *
 * 📥 Example 1:
 * Input: n = 4
 * Output: "aaab" or "pppz"
 * Explanation: One letter appears 3 times (odd), another appears once (odd).
 *
 * 📥 Example 2:
 * Input: n = 2
 * Output: "xy"
 * Explanation: Both characters appear once, which is odd.
 *
 * 📥 Example 3:
 * Input: n = 7
 * Output: "aaaaaaa"
 * Explanation: One character used 7 times (odd).
 *
 * 📌 Constraints:
 * - 1 <= n <= 500
 */

public class GenerateOddCountString {

    /**
     * 🧠 Logic:
     * - If n is odd, we can simply return a string of `n` occurrences of the same character (like 'a').
     * - If n is even, return `n - 1` of one character (like 'a') and 1 of another (like 'b'),
     *   making both counts odd.
     */
    public static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();

        if (n % 2 == 0) {
            // Add (n-1) 'a's and 1 'b' to keep both counts odd
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            // Add n 'a's
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }

        return sb.toString();
    }

    // 🧪 Main method for testing the solution
    public static void main(String[] args) {
        System.out.println("Generated String (n = 4): " + generateTheString(4));  // Example output: aaab
        System.out.println("Generated String (n = 2): " + generateTheString(2));  // Example output: ab
        System.out.println("Generated String (n = 7): " + generateTheString(7));  // Example output: aaaaaaa
    }
}
