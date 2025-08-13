/**
 * Problem: Clear Digits
 * Difficulty: Easy
 *
 * Description:
 * You are given a string `s` consisting of lowercase English letters and digits.
 * You need to repeatedly perform the following operation:
 *  - Delete the first digit in the string and the closest non-digit character to its left.
 *  
 * Return the resulting string after removing all digits.
 * Note: The input is guaranteed to allow removal of all digits by these operations.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: "abc"
 * Explanation: There is no digit to remove.
 *
 * Example 2:
 * Input: s = "cb34"
 * Output: ""
 * Explanation:
 *  1. Remove digit '3' and closest non-digit 'b' → "c4"
 *  2. Remove digit '4' and closest non-digit 'c' → ""
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s contains only lowercase letters and digits
 * - It is always possible to delete all digits
 *
 * Approach:
 * - Use a write pointer to simulate removing characters.
 * - When a digit is found:
 *    → Move write pointer back by 1 (removing closest letter to the left)
 * - When a letter is found:
 *    → Write it at the current write position
 * - Return the built string up to the write pointer.
 *
 * Time Complexity: O(n) [n = length of string]
 * Space Complexity: O(1) (in-place modification of char array)
 */
public class ClearDigits {

    /**
     * Removes all digits and the closest non-digit to the left of each digit.
     *
     * @param s Input string containing lowercase letters and digits
     * @return String after performing all deletions
     */
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();
        int write = 0;

        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                if (write > 0) write--; // remove closest letter to the left
            } else {
                chars[write++] = ch; // keep letter
            }
        }
        return new String(chars, 0, write);
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        ClearDigits solution = new ClearDigits();
        System.out.println(solution.clearDigits("abc"));   // Output: "abc"
        System.out.println(solution.clearDigits("cb34"));  // Output: ""
    }
}
