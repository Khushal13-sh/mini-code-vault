/*
 add greedy solution for minimum number of pushes to type word
*/

/**
 * Problem: Minimum Number of Pushes to Type Word I
 * Difficulty: Easy
 *
 * Description:
 * Given a word containing distinct lowercase English letters,
 * remap the letters to telephone keypad keys (2-9) such that
 * the total number of key presses required to type the word
 * is minimized.
 *
 * There are 8 available keys (2 to 9).
 *
 * Key Insight:
 * - The first 8 letters can be assigned to the first position
 *   of each key → cost = 1 push.
 * - The next 8 letters can be assigned to the second position
 *   of each key → cost = 2 pushes.
 * - The next 8 letters → cost = 3 pushes.
 * - Remaining letters → cost = 4 pushes.
 *
 * Since all letters are distinct and appear exactly once,
 * only the number of letters matters.
 *
 * Approach:
 * - Traverse each character position.
 * - Every group of 8 letters increases the push count by 1.
 * - Add (i / 8) + 1 for each letter.
 *
 * Why this works:
 * To minimize total pushes, assign letters to the cheapest
 * available keypad positions first.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class MinimumNumberOfPushesToTypeWord {

    public int minimumPushes(String word) {

        int pushes = 0;

        for (int i = 0; i < word.length(); i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWord obj =
                new MinimumNumberOfPushesToTypeWord();

        // Example 1
        System.out.println(
                obj.minimumPushes("abcde")
        ); // 5

        // Example 2
        System.out.println(
                obj.minimumPushes("xycdefghij")
        ); // 12
    }
}