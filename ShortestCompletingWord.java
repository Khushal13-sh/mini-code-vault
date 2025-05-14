/**
 * Problem Title: Shortest Completing Word
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given a string 'licensePlate' and an array of words, find the shortest completing word.
 * - A completing word contains all the letters in 'licensePlate', ignoring numbers and spaces.
 * - Treat letters as case-insensitive.
 * - If a letter appears multiple times in 'licensePlate', it must appear the same number of times in the word.
 * 
 * 🔍 Return the shortest completing word.
 * - If multiple shortest completing words exist, return the first one.
 * 
 * 📥 Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation:
 * - The letters from the license plate are "s", "p", "s", "t".
 * - "steps" contains all these letters and is the shortest among valid words.
 * 
 * 📥 Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation:
 * - The letters from the license plate are "s".
 * - "pest" is the first word among shortest valid words.
 * 
 * 📌 Constraints:
 * - 1 <= licensePlate.length <= 7
 * - 1 <= words.length <= 1000
 * - 1 <= words[i].length <= 15
 * - An answer is guaranteed to exist.
 */

import java.util.*;

public class ShortestCompletingWord {

    /**
     * 🧠 Logic:
     * - Convert the license plate to a frequency array of letters.
     * - For each word, calculate the frequency of letters.
     * - Check if the word's frequency covers the license plate frequency.
     * - Keep track of the shortest valid word.
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCount = getCharCount(licensePlate);
        String result = null;

        for (String word : words) {
            int[] wordCnt = getCharCount(word);
            if (matches(targetCount, wordCnt) && (result == null || word.length() < result.length())) {
                result = word;
            }
        }
        return result;
    }

    // 🔧 Helper method to count the frequency of letters in a string (case-insensitive).
    private static int[] getCharCount(String str) {
        int[] count = new int[26];
        for (char ch : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                count[ch - 'a']++;
            }
        }
        return count;
    }

    // 🔄 Check if the word's frequency covers the target frequency.
    private static boolean matches(int[] target, int[] word) {
        for (int i = 0; i < 26; i++) {
            if (target[i] > word[i]) {
                return false;
            }
        }
        return true;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        ShortestCompletingWord scw = new ShortestCompletingWord();

        String licensePlate1 = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        System.out.println("Result: " + scw.shortestCompletingWord(licensePlate1, words1));  // Expected: "steps"

        String licensePlate2 = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println("Result: " + scw.shortestCompletingWord(licensePlate2, words2));  // Expected: "pest"
    }
}
