/*
 add solution for maximum difference between even and odd frequency using frequency counting
*/

/**
 * Problem: Maximum Difference Between Even and Odd Frequency I
 * Difficulty: Easy
 *
 * Description:
 * Find the maximum difference between:
 * - A character with odd frequency
 * - A character with even frequency
 *
 * Approach:
 * - Count frequency of each character
 * - Track:
 *      → Maximum odd frequency
 *      → Minimum even frequency
 * - Return their difference
 *
 * Why this works:
 * Maximizing (odd - even) requires picking:
 * → largest odd frequency
 * → smallest even frequency
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxDifferenceEvenOddFrequency {

    public int maxDifference(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f == 0) continue;

            if (f % 2 == 1) {
                maxOdd = Math.max(maxOdd, f);
            } else {
                minEven = Math.min(minEven, f);
            }
        }

        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        MaxDifferenceEvenOddFrequency obj = new MaxDifferenceEvenOddFrequency();

        // Example 1
        String s1 = "aaaaabbc";
        System.out.println("Output 1: " + obj.maxDifference(s1)); // 3

        // Example 2
        String s2 = "abcabcab";
        System.out.println("Output 2: " + obj.maxDifference(s2)); // 1
    }
}