/*
 add solution for trimming trailing vowels from string using reverse traversal
*/

/**
 * Problem: Trim Trailing Vowels
 * Difficulty: Easy
 *
 * Description:
 * Remove all vowels from the end (right side) of the string.
 *
 * Approach:
 * - Start from the end of the string
 * - Move left while characters are vowels
 * - Return substring from start to last non-vowel index
 *
 * Why this works:
 * We only care about trailing vowels, so reverse traversal is optimal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TrimTrailingVowels {

    public String trimTrailingVowels(String s) {

        int i = s.length() - 1;

        while (i >= 0 && isVowel(s.charAt(i))) {
            i--;
        }

        return s.substring(0, i + 1);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        TrimTrailingVowels obj = new TrimTrailingVowels();

        // Example 1
        String s1 = "idea";
        System.out.println("Output 1: " + obj.trimTrailingVowels(s1)); // id

        // Example 2
        String s2 = "day";
        System.out.println("Output 2: " + obj.trimTrailingVowels(s2)); // day

        // Example 3
        String s3 = "aeiou";
        System.out.println("Output 3: " + obj.trimTrailingVowels(s3)); // ""
    }
}