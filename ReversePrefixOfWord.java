/**
 * Problem: Reverse Prefix of Word
 * Difficulty: Easy
 *
 * Given a string word and a character ch, reverse the prefix of the word 
 * up to and including the first occurrence of ch. If ch is not present, 
 * return the word unchanged.
 *
 * Constraints:
 * - 1 <= word.length <= 250
 * - word consists of lowercase English letters.
 * - ch is a lowercase English letter.
 */

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        int charIndex = word.indexOf(ch);
        if (charIndex == -1) return word;

        String prefix = word.substring(0, charIndex + 1);
        String reversedPrefix = reverseString(prefix);
        String suffix = word.substring(charIndex + 1);

        return reversedPrefix + suffix;
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        ReversePrefixOfWord solution = new ReversePrefixOfWord();

        System.out.println(solution.reversePrefix("abcdefd", 'd')); // Output: "dcbaefd"
        System.out.println(solution.reversePrefix("xyxzxe", 'z'));  // Output: "zxyxxe"
        System.out.println(solution.reversePrefix("abcd", 'z'));    // Output: "abcd"
        System.out.println(solution.reversePrefix("a", 'a'));       // Output: "a"
    }
}
