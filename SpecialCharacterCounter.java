import java.util.HashSet;
import java.util.Set;

/**
 * ------------------------------------------------------------
 * Problem : Count the Number of Special Characters I
 * Class   : SpecialCharacterCounter
 * ------------------------------------------------------------
 */

public class SpecialCharacterCounter {

    public int numberOfSpecialChars(String word) {

        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        // Separate lowercase and uppercase characters
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }

        int count = 0;

        // Check matching pairs
        for (char ch : lower) {
            if (upper.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        SpecialCharacterCounter obj = new SpecialCharacterCounter();

        // Example 1
        String word1 = "aaAbcBC";
        System.out.println("Output: " + obj.numberOfSpecialChars(word1));
        // Expected: 3

        // Example 2
        String word2 = "abc";
        System.out.println("Output: " + obj.numberOfSpecialChars(word2));
        // Expected: 0

        // Example 3
        String word3 = "abBCab";
        System.out.println("Output: " + obj.numberOfSpecialChars(word3));
        // Expected: 1
    }
}