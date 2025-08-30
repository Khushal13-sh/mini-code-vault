/**
 * Problem: Valid Word
 * Difficulty: Easy
 *
 * A word is considered valid if:
 * 1. It contains at least 3 characters.
 * 2. It contains only digits (0-9) and English letters (uppercase/lowercase).
 * 3. It contains at least one vowel (a, e, i, o, u - case insensitive).
 * 4. It contains at least one consonant (English letter that is not a vowel).
 *
 * Examples:
 * Input: "234Adas" → Output: true
 * Input: "b3"      → Output: false
 * Input: "a3$e"    → Output: false
 *
 * Constraints:
 * 1 <= word.length <= 20
 * word may contain '@', '#', '$', which are invalid.
 */

public class ValidWord {

    /**
     * Main method to check if word is valid.
     *
     * @param word input string
     * @return true if word is valid, otherwise false
     */
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                // digits are allowed, skip
                continue;
            } else if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else {
                // any other symbol makes it invalid
                return false;
            }
        }

        return hasVowel && hasConsonant;
    }

    /**
     * Helper function to check if a character is vowel.
     */
    private boolean isVowel(char c) {
        char lower = (c >= 'A' && c <= 'Z') ? (char)(c + 32) : c;
        return (lower == 'a' || lower == 'e' || lower == 'i' 
                || lower == 'o' || lower == 'u');
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        ValidWord solution = new ValidWord();

        System.out.println(solution.isValid("234Adas")); // true
        System.out.println(solution.isValid("b3"));      // false
        System.out.println(solution.isValid("a3$e"));    // false
        System.out.println(solution.isValid("aei123"));  // false (no consonant)
        System.out.println(solution.isValid("bcdfg1"));  // false (no vowel)
        System.out.println(solution.isValid("Code1"));   // true
    }
}
