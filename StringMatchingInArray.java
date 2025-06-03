/**
 * Problem: String Matching in an Array
 * Difficulty: Easy
 *
 * 🧠 Description:
 * Given an array of unique strings, return all strings that are a substring of another word in the array.
 * Order of result doesn't matter.
 *
 * 🧪 Example:
 * Input: ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 */

import java.util.*;

public class StringMatchingInArray {
    public static List<String> stringMatching(String[] words) {
        List<String> resultList = new ArrayList<>();

        for (String word1 : words) {
            for (String word2 : words) {
                if (!word1.equals(word2) && word2.contains(word1)) {
                    resultList.add(word1);
                    break; // No need to check further if already found
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        String[] input1 = {"mass", "as", "hero", "superhero"};
        String[] input2 = {"leetcode", "et", "code"};
        String[] input3 = {"blue", "green", "bu"};
        String[] input4 = {"a", "b", "ab", "abc"};

        System.out.println(stringMatching(input1)); // Output: [as, hero]
        System.out.println(stringMatching(input2)); // Output: [et, code]
        System.out.println(stringMatching(input3)); // Output: []
        System.out.println(stringMatching(input4)); // Output: [a, b, ab]
    }
}
