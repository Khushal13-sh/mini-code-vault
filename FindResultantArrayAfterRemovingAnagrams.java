/**
 * Problem: Find Resultant Array After Removing Anagrams
 * Difficulty: Easy
 *
 * 🔍 Description:
 * You are given a list of strings. Remove all strings that are anagrams of their previous string.
 *
 * 🧪 Example:
 * Input: ["abba","baba","bbaa","cd","cd"]
 * Output: ["abba","cd"]
 */

import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {

    public static List<String> removeAnagrams(String[] words) {
        List<String> resultList = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            String currentSorted = sortString(word);

            // If current sorted word is not same as previous, add to result
            if (!currentSorted.equals(prevSorted)) {
                resultList.add(word);
                prevSorted = currentSorted;
            }
        }

        return resultList;
    }

    // Helper method to return alphabetically sorted string
    private static String sortString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] input1 = {"abba", "baba", "bbaa", "cd", "cd"};
        String[] input2 = {"a", "b", "c", "d", "e"};

        System.out.println(removeAnagrams(input1)); // Output: [abba, cd]
        System.out.println(removeAnagrams(input2)); // Output: [a, b, c, d, e]
    }
}
