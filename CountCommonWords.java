import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Count Common Words With One Occurrence
 * Difficulty: Easy
 *
 * Counts words that appear exactly once
 * in both given string arrays.
 */
class CountCommonWords {

    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();

        // Count frequency in words1
        for (String word : words1) {
            count1.put(word, count1.getOrDefault(word, 0) + 1);
        }

        // Count frequency in words2
        for (String word : words2) {
            count2.put(word, count2.getOrDefault(word, 0) + 1);
        }

        int result = 0;

        // Check words appearing exactly once in both arrays
        for (String word : count1.keySet()) {
            if (count1.get(word) == 1 && count2.getOrDefault(word, 0) == 1) {
                result++;
            }
        }

        return result;
    }

    // Example test cases
    public static void main(String[] args) {
        CountCommonWords obj = new CountCommonWords();

        System.out.println(obj.countWords(
                new String[]{"leetcode","is","amazing","as","is"},
                new String[]{"amazing","leetcode","is"})); // 2

        System.out.println(obj.countWords(
                new String[]{"b","bb","bbb"},
                new String[]{"a","aa","aaa"})); // 0

        System.out.println(obj.countWords(
                new String[]{"a","ab"},
                new String[]{"a","a","a","ab"})); // 1
    }
}
