/*
 add solution for finding kth character in string game using simulation
*/

/**
 * Problem: Find the K-th Character in String Game I
 * Difficulty: Easy
 *
 * Description:
 * Initially, word = "a".
 *
 * In each operation:
 * - Generate a new string by replacing every character
 *   with its next alphabet character
 * - Append this new string to the original word
 *
 * Return the kth character after enough operations.
 *
 * Approach:
 * - Start with word = "a"
 * - Keep generating next transformed string
 * - Append transformed string to original word
 * - Stop when length becomes at least k
 * - Return character at index (k - 1)
 *
 * Why this works:
 * The problem directly asks us to simulate
 * the string generation process.
 *
 * Time Complexity: O(k)
 * Space Complexity: O(k)
 */

public class KthCharacterInStringGame {

    public char kthCharacter(int k) {

        String word = "a";

        // Generate until length reaches k
        while (word.length() < k) {

            StringBuilder next = new StringBuilder();

            // Generate transformed string
            for (char ch : word.toCharArray()) {

                next.append((char)(ch + 1));
            }

            // Append new part
            word += next.toString();
        }

        return word.charAt(k - 1);
    }

    public static void main(String[] args) {

        KthCharacterInStringGame obj =
                new KthCharacterInStringGame();

        // Example 1
        System.out.println(
            "Output 1: " +
            obj.kthCharacter(5)
        ); // b

        // Example 2
        System.out.println(
            "Output 2: " +
            obj.kthCharacter(10)
        ); // c
    }
}