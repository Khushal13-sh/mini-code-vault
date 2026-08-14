/*
 add solution for checking if a string is an acronym of words
*/

/**
 * Problem: Check if a String Is an Acronym of Words
 * Difficulty: Easy
 *
 * Description:
 * Given an array of strings words and a string s,
 * determine whether s is an acronym of words.
 *
 * An acronym is formed by concatenating the first
 * character of every word in the same order.
 *
 * Key Insight:
 * - The number of words must be equal to the length of s.
 * - The first character of each word must match the
 *   corresponding character in s.
 *
 * Approach:
 * - First check whether the number of words and the
 *   length of s are equal.
 * - Traverse through all words.
 * - Compare the first character of each word with the
 *   corresponding character of s.
 * - If any character does not match, return false.
 * - If all characters match, return true.
 *
 * Why this works:
 * The acronym is created using exactly one character
 * from each word, and that character is always the
 * first character. Therefore, checking each character
 * directly is sufficient.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class CheckIfAStringIsAnAcronymOfWords {

    public boolean isAcronym(List<String> words, String s) {

        // Number of words must match the acronym length.
        if (words.size() != s.length()) {
            return false;
        }

        // Compare the first character of each word
        // with the corresponding character in s.
        for (int i = 0; i < words.size(); i++) {

            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        CheckIfAStringIsAnAcronymOfWords obj =
                new CheckIfAStringIsAnAcronymOfWords();

        // Example 1
        List<String> words1 = Arrays.asList(
                "alice", "bob", "charlie"
        );

        String s1 = "abc";

        boolean result1 = obj.isAcronym(words1, s1);

        System.out.println("Output 1: " + result1);

        // Example 2
        List<String> words2 = Arrays.asList(
                "an", "apple"
        );

        String s2 = "a";

        boolean result2 = obj.isAcronym(words2, s2);

        System.out.println("Output 2: " + result2);

        // Example 3
        List<String> words3 = Arrays.asList(
                "never", "gonna", "give", "up", "on", "you"
        );

        String s3 = "ngguoy";

        boolean result3 = obj.isAcronym(words3, s3);

        System.out.println("Output 3: " + result3);
    }
}