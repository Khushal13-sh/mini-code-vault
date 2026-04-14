/*
 add solution for weighted word mapping using modulo and reverse alphabet logic
*/

/**
 * Problem: Weighted Word Mapping
 * Difficulty: Easy
 *
 * Description:
 * Each word is assigned a weight based on character weights.
 * The total weight is taken modulo 26 and mapped to a character
 * using reverse alphabetical order:
 * 0 → 'z', 1 → 'y', ..., 25 → 'a'
 *
 * Approach:
 * - For each word:
 *      → Calculate sum of weights of characters
 *      → Take modulo 26
 *      → Map using: 'z' - mod
 * - Append result character to final string
 *
 * Why this works:
 * Reverse mapping ensures correct transformation from numeric result
 * to required character.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n)
 */
public class WeightedWordMapping {

    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            int mod = sum % 26;

            char mappedChar = (char) ('z' - mod);

            result.append(mappedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        WeightedWordMapping obj = new WeightedWordMapping();

        // Example 1
        String[] words1 = {"abcd", "def", "xyz"};
        int[] weights1 = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println("Output 1: " + obj.mapWordWeights(words1, weights1)); // rij

        // Example 2
        String[] words2 = {"a", "b", "c"};
        int[] weights2 = new int[26];
        for (int i = 0; i < 26; i++) weights2[i] = 1;
        System.out.println("Output 2: " + obj.mapWordWeights(words2, weights2)); // yyy

        // Example 3
        String[] words3 = {"abcd"};
        int[] weights3 = {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        System.out.println("Output 3: " + obj.mapWordWeights(words3, weights3)); // g
    }
}