import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * Difficulty: Medium
 *
 * Problem:
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 *
 * Approach:
 * Sliding Window + HashSet
 *
 * Key Idea:
 * Maintain a window containing only unique characters.
 * If a duplicate character is found, move the left pointer
 * until the duplicate is removed.
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(min(n, character set size))
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Finds the length of the longest substring without
     * duplicate characters.
     *
     * @param s input string
     * @return length of the longest substring
     */
    public int lengthOfLongestSubstring(String s) {

        // Stores characters currently inside the window
        Set<Character> set = new HashSet<>();

        // Left boundary of the sliding window
        int left = 0;

        // Maximum length found so far
        int maxLength = 0;

        // Right boundary moves through the string
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If duplicate exists, move left pointer
            // until the duplicate character is removed
            while (set.contains(ch)) {

                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the window
            set.add(ch);

            // Calculate current window length
            int length = right - left + 1;

            // Update maximum length
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters obj =
                new LongestSubstringWithoutRepeatingCharacters();

        // Example 1
        String s1 = "abcabcbb";

        System.out.println("Input: " + s1);
        System.out.println(
                "Output: " + obj.lengthOfLongestSubstring(s1)
        );

        // Example 2
        String s2 = "bbbbb";

        System.out.println("\nInput: " + s2);
        System.out.println(
                "Output: " + obj.lengthOfLongestSubstring(s2)
        );

        // Example 3
        String s3 = "pwwkew";

        System.out.println("\nInput: " + s3);
        System.out.println(
                "Output: " + obj.lengthOfLongestSubstring(s3)
        );
    }
}