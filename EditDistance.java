
/**
 * Problem: Edit Distance
 * LeetCode: 72
 * Difficulty: Medium
 *
 * Description:
 * Given two strings, find the minimum number of operations
 * required to convert word1 into word2.
 *
 * Allowed operations:
 * 1. Insert a character.
 * 2. Delete a character.
 * 3. Replace a character.
 *
 * Approach:
 * 2D Dynamic Programming.
 *
 * We use a DP table where dp[i][j] represents the minimum
 * operations required to convert the first i characters
 * of word1 into the first j characters of word2.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {

        // Length of the first string.
        int m = word1.length();

        // Length of the second string.
        int n = word2.length();

        /*
         * DP table:
         *
         * dp[i][j] represents the minimum operations
         * required to convert:
         *
         * First i characters of word1
         * into
         * First j characters of word2.
         *
         * Extra row and column are required to handle
         * empty strings.
         */
        int[][] dp = new int[m + 1][n + 1];

        /*
         * Base Case 1:
         *
         * Convert word1's first i characters into an empty string.
         *
         * We need to delete all i characters.
         *
         * Example:
         * "horse" -> ""
         * Required operations = 5
         */
        for (int i = 0; i <= m; i++) {

            dp[i][0] = i;
        }

        /*
         * Base Case 2:
         *
         * Convert an empty string into word2's first j characters.
         *
         * We need to insert all j characters.
         *
         * Example:
         * "" -> "ros"
         * Required operations = 3
         */
        for (int j = 0; j <= n; j++) {

            dp[0][j] = j;
        }

        // Process every character of word1.
        for (int i = 1; i <= m; i++) {

            // Process every character of word2.
            for (int j = 1; j <= n; j++) {

                /*
                 * Compare the current characters.
                 *
                 * DP index i corresponds to string index i - 1.
                 * DP index j corresponds to string index j - 1.
                 */
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    /*
                     * Characters are equal.
                     *
                     * No operation is required.
                     * Take the result from the previous diagonal cell.
                     */
                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    /*
                     * Characters are different.
                     *
                     * Option 1: INSERT
                     *
                     * Insert the required character into word1.
                     * Previous result: dp[i][j - 1]
                     */
                    int insert = dp[i][j - 1];

                    /*
                     * Option 2: DELETE
                     *
                     * Delete the current character from word1.
                     * Previous result: dp[i - 1][j]
                     */
                    int delete = dp[i - 1][j];

                    /*
                     * Option 3: REPLACE
                     *
                     * Replace the current character in word1
                     * with the required character from word2.
                     * Previous result: dp[i - 1][j - 1]
                     */
                    int replace = dp[i - 1][j - 1];

                    /*
                     * Choose the operation requiring
                     * the minimum number of operations.
                     *
                     * Add 1 because we are performing
                     * one additional operation.
                     */
                    dp[i][j] = 1 + Math.min(
                            insert,
                            Math.min(delete, replace)
                    );
                }
            }
        }

        /*
         * The bottom-right cell contains the minimum
         * operations required to convert the complete
         * word1 into the complete word2.
         */
        return dp[m][n];
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        EditDistance solution = new EditDistance();

        // Test Case 1
        String word1 = "horse";
        String word2 = "ros";

        System.out.println("Word 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("Minimum Operations: "
                + solution.minDistance(word1, word2));

        // Test Case 2
        word1 = "intention";
        word2 = "execution";

        System.out.println("\nWord 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("Minimum Operations: "
                + solution.minDistance(word1, word2));

        // Test Case 3: Both strings are identical
        word1 = "java";
        word2 = "java";

        System.out.println("\nWord 1: " + word1);
        System.out.println("Word 2: " + word2);
        System.out.println("Minimum Operations: "
                + solution.minDistance(word1, word2));

        // Test Case 4: First string is empty
        word1 = "";
        word2 = "abc";

        System.out.println("\nWord 1: \"\"");
        System.out.println("Word 2: " + word2);
        System.out.println("Minimum Operations: "
                + solution.minDistance(word1, word2));

        // Test Case 5: Second string is empty
        word1 = "abc";
        word2 = "";

        System.out.println("\nWord 1: " + word1);
        System.out.println("Word 2: \"\"");
        System.out.println("Minimum Operations: "
                + solution.minDistance(word1, word2));
    }
}
