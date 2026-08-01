/*
 add solution to find the first word starting with the given prefix
*/

/**
 * Problem: Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * Difficulty: Easy
 *
 * Description:
 * Given a sentence and a search word,
 * return the 1-based index of the first word
 * that starts with the given prefix.
 *
 * If no such word exists, return -1.
 *
 * Key Insight:
 * - Split the sentence into individual words.
 * - Check each word using startsWith().
 * - Return the first matching index.
 *
 * Approach:
 * - Split the sentence by spaces.
 * - Traverse each word.
 * - If the current word starts with searchWord,
 *   return its 1-based position.
 * - If no match is found, return -1.
 *
 * Why this works:
 * Each word is checked exactly once, and
 * startsWith() efficiently verifies whether
 * the search word is a prefix.
 *
 * Time Complexity: O(n)
 * n = total number of characters in the sentence.
 *
 * Space Complexity: O(n)
 * Extra space is used to store the split words.
 */
public class PrefixOfWordInSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        PrefixOfWordInSentence obj =
                new PrefixOfWordInSentence();

        // Example 1
        String sentence1 = "i love eating burger";
        String searchWord1 = "burg";

        System.out.println("Output 1: " +
                obj.isPrefixOfWord(sentence1, searchWord1));

        // Example 2
        String sentence2 = "this problem is an easy problem";
        String searchWord2 = "pro";

        System.out.println("Output 2: " +
                obj.isPrefixOfWord(sentence2, searchWord2));

        // Example 3
        String sentence3 = "i am tired";
        String searchWord3 = "you";

        System.out.println("Output 3: " +
                obj.isPrefixOfWord(sentence3, searchWord3));
    }
}