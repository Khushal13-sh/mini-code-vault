/**
 * Problem: Count Vowel Substrings of a String
 * Difficulty: Easy
 *
 * Description:
 * A substring is a contiguous (non-empty) sequence of characters within a string.
 * A vowel substring is a substring that:
 *   - contains only vowels ('a', 'e', 'i', 'o', 'u')
 *   - includes all five vowels at least once
 *
 * Task:
 * Given a string word, return the number of vowel substrings in word.
 *
 * Example 1:
 * Input: word = "aeiouu"
 * Output: 2
 *
 * Example 2:
 * Input: word = "unicornarihan"
 * Output: 0
 *
 * Example 3:
 * Input: word = "cuaieuouac"
 * Output: 7
 *
 * Constraints:
 * 1 <= word.length <= 100
 * word consists only of lowercase English letters.
 *
 * Approach:
 * - Iterate through each starting index `i` in the word
 * - Expand the substring ending at `j` while it contains only vowels
 * - Track vowels seen in a HashSet
 * - If the set reaches size 5, increment count
 *
 * Time Complexity: O(n^2) (since n <= 100, this is acceptable)
 * Space Complexity: O(1) (only a small set of vowels is stored)
 */

import java.util.*;

public class CountVowelSubstrings {

    /**
     * Counts the number of vowel substrings containing all five vowels.
     */
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int n = word.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);

                // Stop if non-vowel encountered
                if (!vowels.contains(c)) break;

                // Track current vowel
                seen.add(c);

                // All 5 vowels found
                if (seen.size() == 5) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        CountVowelSubstrings solution = new CountVowelSubstrings();

        System.out.println("Input: aeiouu → Output: " + solution.countVowelSubstrings("aeiouu")); // 2
        System.out.println("Input: unicornarihan → Output: " + solution.countVowelSubstrings("unicornarihan")); // 0
        System.out.println("Input: cuaieuouac → Output: " + solution.countVowelSubstrings("cuaieuouac")); // 7
    }
}
