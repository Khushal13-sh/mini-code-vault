/*
 add solution for maximum length substring with at most two occurrences using sliding window
*/

/**
 * Problem: Maximum Length Substring With Two Occurrences
 * Difficulty: Easy
 *
 * Description:
 * Find the maximum length of a substring such that each character
 * appears at most two times.
 *
 * Approach:
 * - Use Sliding Window technique
 * - Maintain a frequency array of size 26
 * - Expand window using right pointer
 * - If any character exceeds frequency 2 → shrink window from left
 * - Track maximum window length
 *
 * Why this works:
 * Sliding window ensures we always maintain a valid substring
 * where no character appears more than twice.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxLengthSubstringTwoOccurrences {

    public int maximumLengthSubstring(String s) {

        int[] freq = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            // Shrink window if condition breaks
            while (freq[ch - 'a'] > 2) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MaxLengthSubstringTwoOccurrences obj = new MaxLengthSubstringTwoOccurrences();

        // Example 1
        String s1 = "bcbbbcba";
        System.out.println("Output 1: " + obj.maximumLengthSubstring(s1)); // 4

        // Example 2
        String s2 = "aaaa";
        System.out.println("Output 2: " + obj.maximumLengthSubstring(s2)); // 2
    }
}