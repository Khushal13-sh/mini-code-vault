/*
 add solution for counting residue prefixes using frequency tracking
*/

/**
 * Problem: Count Residue Prefixes
 * Difficulty: Easy
 *
 * Description:
 * A prefix is called a residue if:
 *
 * distinctCharacters == prefixLength % 3
 *
 * Return the total number of residue prefixes.
 *
 * Key Insight:
 * - While traversing the string:
 *      Track frequency of characters
 *      Track number of distinct characters
 * - For every prefix:
 *      Check if distinct == length % 3
 *
 * Approach:
 * - Use frequency array of size 26
 * - Maintain distinct character count
 * - Traverse string character by character
 * - Update distinct count whenever a new character appears
 * - Check residue condition for each prefix
 *
 * Why this works:
 * Every iteration represents one prefix ending at index i.
 * We directly validate the residue condition.
 *
 * Time Complexity: O(n)
 * n = length of string
 *
 * Space Complexity: O(1)
 * Fixed frequency array of size 26
 */
public class CountResiduePrefixes {

    public int residuePrefixes(String s) {

        int[] freq = new int[26];

        int distinct = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // New distinct character found
            if (freq[ch - 'a'] == 0) {
                distinct++;
            }

            freq[ch - 'a']++;

            int prefixLen = i + 1;

            // Check residue condition
            if (distinct == prefixLen % 3) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountResiduePrefixes obj =
                new CountResiduePrefixes();

        // Example 1
        System.out.println(
                "Output 1: " +
                obj.residuePrefixes("abc")
        ); // 2

        // Example 2
        System.out.println(
                "Output 2: " +
                obj.residuePrefixes("dd")
        ); // 1

        // Example 3
        System.out.println(
                "Output 3: " +
                obj.residuePrefixes("bob")
        ); // 2
    }
}