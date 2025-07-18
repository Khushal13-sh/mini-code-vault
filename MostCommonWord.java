/**
 * Problem: Most Common Word
 * Difficulty: Easy
 *
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not banned. Words are case-insensitive and punctuation is ignored.
 */

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z ]", " ").split("\\s+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        String commonWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                commonWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return commonWord;
    }

    public static void main(String[] args) {
        MostCommonWord solution = new MostCommonWord();

        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"})); // Output: "ball"
        System.out.println(solution.mostCommonWord("a.", new String[]{})); // Output: "a"
    }
}
