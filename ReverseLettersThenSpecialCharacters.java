/*
 add solution for reversing letters and special characters separately in a string
*/

/**
 * Problem: Reverse Letters Then Special Characters in a String
 * Difficulty: Easy
 *
 * Description:
 * Given a string containing lowercase letters and special characters:
 * 1. Reverse all lowercase letters and place them back into their
 *    original letter positions.
 * 2. Reverse all special characters and place them back into their
 *    original special-character positions.
 *
 * Return the resulting string.
 *
 * Key Insight:
 * - Letters and special characters occupy independent positions.
 * - Extract both groups separately.
 * - Reverse each group.
 * - Rebuild the string while preserving the original type
 *   (letter or special character) at every index.
 *
 * Approach:
 * - Traverse the string and store:
 *   - Letters in one list
 *   - Special characters in another list
 * - Reverse both lists.
 * - Traverse the string again:
 *   - If current character is a letter, take the next reversed letter.
 *   - Otherwise, take the next reversed special character.
 * - Construct the final string.
 *
 * Why this works:
 * Reversing each category independently while keeping their original
 * positions ensures the required transformation.
 *
 * Time Complexity: O(n)
 * - One pass for extraction
 * - One pass for reconstruction
 *
 * Space Complexity: O(n)
 * - Stores letters and special characters separately
 */
public class ReverseLettersThenSpecialCharacters {

    public String reverseByType(String s) {

        List<Character> letters = new ArrayList<>();
        List<Character> specials = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                letters.add(ch);
            } else {
                specials.add(ch);
            }
        }

        Collections.reverse(letters);
        Collections.reverse(specials);

        StringBuilder result = new StringBuilder();

        int letterIdx = 0;
        int specialIdx = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(letters.get(letterIdx++));
            } else {
                result.append(specials.get(specialIdx++));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseLettersThenSpecialCharacters obj =
                new ReverseLettersThenSpecialCharacters();

        // Example 1
        System.out.println(
                obj.reverseByType(")ebc#da@f(")
        ); // (fad@cb#e)

        // Example 2
        System.out.println(
                obj.reverseByType("z")
        ); // z

        // Example 3
        System.out.println(
                obj.reverseByType("!@#$%^&*()")
        ); // )(*&^%$#@!
    }
}