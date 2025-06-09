/**
 * Problem: Maximum Score After Splitting a String
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Given a binary string s, split it into two non-empty parts and return the maximum
 * score possible. The score is the number of 0's in the left substring +
 * the number of 1's in the right substring.
 *
 * 🧪 Example:
 * Input: "011101" ➞ Output: 5
 * Explanation: Split at index 1 => left = "0" (1 zero), right = "11101" (4 ones)
 * Score = 1 + 4 = 5
 */

public class MaximumScoreAfterSplittingString {

    public static int maxScore(String s) {
        int len = s.length();
        int maxScore = 0;
        int zeroCount = 0;

        // Count total number of 1's in the string
        int totalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        // Iterate and track zeros on left and ones on right
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                totalOnes--; // 1 moved from right to left
            }

            int score = zeroCount + totalOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101")); // Output: 5
        System.out.println(maxScore("00111"));  // Output: 5
        System.out.println(maxScore("1111"));   // Output: 3
        System.out.println(maxScore("00"));     // Output: 1
    }
}
