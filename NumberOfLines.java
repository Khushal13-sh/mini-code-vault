/**
 * Problem Title: Number of Lines To Write String
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * You are given a string 's' of lowercase English letters and an array 'widths' 
 * denoting how many pixels wide each lowercase English letter is. 
 * - Write 's' across several lines, where each line is no longer than 100 pixels.
 * - Start at the beginning of 's', and continue writing letters on the next line when the limit exceeds.
 * 
 * 🔍 Return an array result of length 2 where:
 * - result[0] = Total number of lines.
 * - result[1] = Width of the last line in pixels.
 * 
 * 📥 Example 1:
 * Input: widths = [10,10,10,...,10], s = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3,60]
 * Explanation:
 * Line 1: "abcdefghij" (100 pixels)
 * Line 2: "klmnopqrst" (100 pixels)
 * Line 3: "uvwxyz" (60 pixels)
 * 
 * 📥 Example 2:
 * Input: widths = [4,10,10,...,10], s = "bbbcccdddaaa"
 * Output: [2,4]
 * Explanation:
 * Line 1: "bbbcccdddaa" (98 pixels)
 * Line 2: "a" (4 pixels)
 * 
 * 📌 Constraints:
 * - widths.length == 26
 * - 2 <= widths[i] <= 10
 * - 1 <= s.length <= 1000
 * - s contains only lowercase English letters.
 */

import java.util.*;

public class NumberOfLines {

    /**
     * 🧠 Logic:
     * - Initialize the line count as 1 and the current width as 0.
     * - For each character in the string:
     *   - Calculate the width using the given widths array.
     *   - If adding the current character exceeds 100 pixels:
     *     - Increment line count.
     *     - Start a new line with the current character width.
     *   - Otherwise, add the character width to the current line.
     */
    public static int[] numberOfLines(int[] widths, String s) {
        int currentWidth = 0;
        int lineCount = 1;

        for (char ch : s.toCharArray()) {
            int width = widths[ch - 'a'];

            if (currentWidth + width > 100) {
                lineCount++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }
        return new int[]{lineCount, currentWidth};
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int[] widths1 = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Result: " + Arrays.toString(numberOfLines(widths1, s1)));  // Expected: [3,60]

        int[] widths2 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s2 = "bbbcccdddaaa";
        System.out.println("Result: " + Arrays.toString(numberOfLines(widths2, s2)));  // Expected: [2,4]
    }
}
