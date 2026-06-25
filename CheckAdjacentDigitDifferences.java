/*
 add solution for checking adjacent digit differences
*/

/**
 * Problem: Check Adjacent Digit Differences
 * Difficulty: Easy
 *
 * Description:
 * Given a string s consisting only of digits,
 * return true if the absolute difference between
 * every pair of adjacent digits is at most 2.
 *
 * Otherwise, return false.
 *
 * Key Insight:
 * - Compare every digit with its previous digit.
 * - If any adjacent difference exceeds 2,
 *   the condition fails immediately.
 *
 * Approach:
 * - Traverse the string from index 1.
 * - Convert adjacent characters into digits.
 * - Compute their absolute difference.
 * - If the difference is greater than 2,
 *   return false.
 * - If all pairs satisfy the condition,
 *   return true.
 *
 * Why this works:
 * - The problem only depends on adjacent pairs.
 * - Checking each pair exactly once guarantees
 *   a correct result.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class CheckAdjacentDigitDifferences {

    public boolean isAdjacentDiffAtMostTwo(String s) {

        for (int i = 1; i < s.length(); i++) {

            int previousDigit = s.charAt(i - 1) - '0';
            int currentDigit = s.charAt(i) - '0';

            if (Math.abs(currentDigit - previousDigit) > 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        CheckAdjacentDigitDifferences obj =
                new CheckAdjacentDigitDifferences();

        // Example 1
        String s1 = "132";
        System.out.println(
                "Output 1: " +
                obj.isAdjacentDiffAtMostTwo(s1));

        // Example 2
        String s2 = "129";
        System.out.println(
                "Output 2: " +
                obj.isAdjacentDiffAtMostTwo(s2));
    }
}