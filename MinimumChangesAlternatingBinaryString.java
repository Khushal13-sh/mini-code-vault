/*
 add solution for minimum changes to make alternating binary string
*/

/**
 * Problem: Minimum Changes To Make Alternating Binary String
 * Difficulty: Easy
 *
 * Description:
 * Given a binary string, find the minimum number of changes
 * required to make the string alternating.
 *
 * An alternating string can be:
 * - "010101..."
 * - "101010..."
 *
 * Key Insight:
 * Only two valid alternating patterns are possible:
 * 1. Start with '0'
 * 2. Start with '1'
 *
 * Count mismatches for both patterns and return the minimum.
 *
 * Approach:
 * - Traverse the string
 * - Compare each character with expected character
 *   for both alternating patterns
 * - Count mismatches separately
 * - Return minimum mismatch count
 *
 * Why this works:
 * Every mismatch represents one required operation.
 * The optimal answer must be one of the two possible
 * alternating patterns.
 *
 * Time Complexity: O(n)
 * n = length of string
 *
 * Space Complexity: O(1)
 */
public class MinimumChangesAlternatingBinaryString {

    public int minOperations(String s) {

        int startWith0 = 0;
        int startWith1 = 0;

        for (int i = 0; i < s.length(); i++) {

            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0) {
                startWith0++;
            }

            if (s.charAt(i) != expected1) {
                startWith1++;
            }
        }

        return Math.min(startWith0, startWith1);
    }

    public static void main(String[] args) {

        MinimumChangesAlternatingBinaryString obj =
                new MinimumChangesAlternatingBinaryString();

        // Example 1
        System.out.println(obj.minOperations("0100")); // 1

        // Example 2
        System.out.println(obj.minOperations("10")); // 0

        // Example 3
        System.out.println(obj.minOperations("1111")); // 2
    }
}