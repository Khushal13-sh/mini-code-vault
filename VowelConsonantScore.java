/*
 add solution for calculating vowel-consonant score
*/

/**
 * Problem: Vowel-Consonant Score
 * Difficulty: Easy
 *
 * Description:
 * Given a string s consisting of lowercase letters,
 * spaces, and digits:
 *
 * - Let v be the number of vowels.
 * - Let c be the number of consonants.
 *
 * Score is defined as:
 *
 * - floor(v / c) if c > 0
 * - 0 otherwise
 *
 * Return the score of the string.
 *
 * Key Insight:
 * - Only letters contribute to vowel or consonant counts.
 * - Spaces and digits should be ignored.
 * - Use integer division to automatically get floor(v / c).
 *
 * Approach:
 * - Traverse each character of the string.
 * - If it is a letter:
 *      - Count as vowel if it is a, e, i, o, u.
 *      - Otherwise count as consonant.
 * - If consonants > 0, return vowels / consonants.
 * - Otherwise return 0.
 *
 * Why this works:
 * The problem directly requires counting vowels
 * and consonants and computing their ratio.
 *
 * Time Complexity: O(n)
 * One traversal of the string.
 *
 * Space Complexity: O(1)
 * Only a few variables are used.
 */
public class VowelConsonantScore {

    public int vowelConsonantScore(String s) {

        int vowels = 0;
        int consonants = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {

                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return consonants > 0
                ? vowels / consonants
                : 0;
    }

    public static void main(String[] args) {

        VowelConsonantScore obj =
                new VowelConsonantScore();

        // Example 1
        String s1 = "cooear";

        System.out.println(
                "Output 1: " +
                obj.vowelConsonantScore(s1)
        );

        // Example 2
        String s2 = "axeyizou";

        System.out.println(
                "Output 2: " +
                obj.vowelConsonantScore(s2)
        );

        // Example 3
        String s3 = "au 123";

        System.out.println(
                "Output 3: " +
                obj.vowelConsonantScore(s3)
        );
    }
}