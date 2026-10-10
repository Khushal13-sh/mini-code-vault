
/**
 * Problem: Reverse Words in a String
 * Difficulty: Medium
 *
 * Problem Description:
 *
 * Given a string s, reverse the order of its words.
 *
 * A word is a sequence of non-space characters.
 * Words may be separated by multiple spaces.
 *
 * The returned string must:
 * 1. Reverse the order of the words.
 * 2. Contain only one space between adjacent words.
 * 3. Have no leading or trailing spaces.
 *
 * Example:
 *
 * Input:
 *     "a good   example"
 *
 * Output:
 *     "example good a"
 *
 * Approach:
 *
 * 1. Use trim() to remove leading and trailing spaces.
 * 2. Use split("\\s+") to separate the words.
 * 3. Traverse the words array from right to left.
 * 4. Append each word to a StringBuilder.
 * 5. Append a space between words, but not after the last word.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Here, n is the length of the input string.
 */
public class ReverseWordsInAString {

    /**
     * Reverses the order of words and normalizes spaces.
     *
     * @param s input string
     * @return string containing reversed words
     */
    public String reverseWords(String s) {

        // Remove leading and trailing spaces.
        String trimmed = s.trim();

        // Split the string wherever one or more whitespace
        // characters occur.
        String[] words = trimmed.split("\\s+");

        // Used to build the final result efficiently.
        StringBuilder result = new StringBuilder();

        // Traverse the words from last to first.
        for (int i = words.length - 1; i >= 0; i--) {

            // Append the current word.
            result.append(words[i]);

            // Add one space between words.
            // Do not add a trailing space after the final word.
            if (i > 0) {
                result.append(" ");
            }
        }

        // Convert the StringBuilder into a String.
        return result.toString();
    }

    /**
     * Tests the reverseWords method.
     */
    public static void main(String[] args) {

        ReverseWordsInAString solution = new ReverseWordsInAString();

        // Example 1
        System.out.println(
            solution.reverseWords("the sky is blue")
        );
        // Output: blue is sky the

        // Example 2
        System.out.println(
            solution.reverseWords("  hello world  ")
        );
        // Output: world hello

        // Example 3
        System.out.println(
            solution.reverseWords("a good   example")
        );
        // Output: example good a

        // Example 4
        System.out.println(
            solution.reverseWords("Java")
        );
        // Output: Java

        // Example 5
        System.out.println(
            solution.reverseWords("  practice   makes perfect  ")
        );
        // Output: perfect makes practice
    }
}
