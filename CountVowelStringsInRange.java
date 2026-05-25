/*
 add solution for counting vowel strings in a given range
*/

/**
 * Problem: Count the Number of Vowel Strings in Range
 * Difficulty: Easy
 *
 * Description:
 * Count how many strings in the given index range [left, right]
 * start and end with a vowel.
 *
 * Vowels:
 * a, e, i, o, u
 *
 * Key Insight:
 * - A valid word must:
 *      start with a vowel
 *      end with a vowel
 *
 * Approach:
 * - Traverse words from left to right
 * - Extract first and last characters
 * - Check whether both are vowels
 * - Increment count if valid
 *
 * Why this works:
 * We directly validate the condition for every word
 * within the specified range.
 *
 * Time Complexity: O(n)
 * n = number of checked words
 *
 * Space Complexity: O(1)
 */
public class CountVowelStringsInRange {

    public int vowelStrings(String[] words, int left, int right) {

        int count = 0;

        String vowels = "aeiou";

        for (int i = left; i <= right; i++) {

            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (vowels.indexOf(first) != -1 &&
                vowels.indexOf(last) != -1) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountVowelStringsInRange obj =
                new CountVowelStringsInRange();

        // Example 1
        String[] words1 = {"are", "amy", "u"};

        System.out.println(
                "Output 1: " +
                obj.vowelStrings(words1, 0, 2)
        ); // 2

        // Example 2
        String[] words2 =
                {"hey", "aeo", "mu", "ooo", "artro"};

        System.out.println(
                "Output 2: " +
                obj.vowelStrings(words2, 1, 4)
        ); // 3
    }
}