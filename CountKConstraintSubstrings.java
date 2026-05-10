/*
 add solution for counting substrings satisfying k-constraint using brute force
*/

/**
 * Problem: Count Substrings That Satisfy K-Constraint I
 * Difficulty: Easy
 *
 * Description:
 * A substring satisfies the k-constraint if:
 * - Number of 0's <= k
 * OR
 * - Number of 1's <= k
 *
 * Return total number of valid substrings.
 *
 * Key Insight:
 * - Generate all possible substrings
 * - Count zeros and ones while expanding substring
 * - Check whether substring satisfies condition
 *
 * Approach:
 * - Fix starting index i
 * - Expand ending index j
 * - Maintain count of zeros and ones
 * - If zeros <= k OR ones <= k:
 *      increment answer
 *
 * Why this works:
 * Every substring is checked exactly once,
 * and validity is determined using counts
 * of zeros and ones.
 *
 * Time Complexity: O(n²)
 *
 * Space Complexity: O(1)
 */
public class CountKConstraintSubstrings {

    public int countKConstraintSubstrings(String s, int k) {

        int n = s.length();
        int count = 0;

        // Generate all substrings
        for (int i = 0; i < n; i++) {

            int zeros = 0;
            int ones = 0;

            for (int j = i; j < n; j++) {

                // Update counts
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }

                // Check k-constraint
                if (zeros <= k || ones <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountKConstraintSubstrings obj =
                new CountKConstraintSubstrings();

        // Example 1
        System.out.println(
                "Output 1: " +
                obj.countKConstraintSubstrings("10101", 1)
        ); // 12

        // Example 2
        System.out.println(
                "Output 2: " +
                obj.countKConstraintSubstrings("1010101", 2)
        ); // 25

        // Example 3
        System.out.println(
                "Output 3: " +
                obj.countKConstraintSubstrings("11111", 1)
        ); // 15
    }
}