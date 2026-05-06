/*
 add solution for counting words with given prefix using string startsWith method
*/

/**
 * Problem: Counting Words With a Given Prefix
 * Difficulty: Easy
 *
 * Description:
 * Count how many words in the array start with the given prefix.
 *
 * Key Insight:
 * - A prefix means the string must start with given characters
 * - Java provides built-in method startsWith()
 *
 * Approach:
 * - Iterate through each word
 * - Check if word.startsWith(pref)
 * - Increment count if true
 *
 * Why this works:
 * startsWith() efficiently checks prefix match.
 *
 * Time Complexity: O(n * m)
 * n = number of words, m = prefix length
 *
 * Space Complexity: O(1)
 */
public class CountWordsWithPrefix {

    public int prefixCount(String[] words, String pref) {

        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountWordsWithPrefix obj = new CountWordsWithPrefix();

        // Example 1
        String[] words1 = {"pay", "attention", "practice", "attend"};
        System.out.println("Output 1: " + obj.prefixCount(words1, "at")); // 2

        // Example 2
        String[] words2 = {"leetcode", "win", "loops", "success"};
        System.out.println("Output 2: " + obj.prefixCount(words2, "code")); // 0
    }
}