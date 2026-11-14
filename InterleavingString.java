
/*
 * Problem: Interleaving String
 *
 * Description:
 * Given three strings s1, s2 and s3, determine
 * whether s3 can be formed by interleaving s1 and s2.
 *
 * The relative order of characters in both s1 and s2
 * must be preserved.
 *
 * Approach: 2D Dynamic Programming
 *
 * dp[i][j] represents whether the first i characters
 * of s1 and first j characters of s2 can form the
 * first i + j characters of s3.
 *
 * At every position, we have two choices:
 *
 * 1. Take the next character from s1.
 * 2. Take the next character from s2.
 *
 * If either choice produces a valid previous state,
 * the current state is true.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 */

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length();
        int m = s2.length();

        // The total length of s1 and s2 must equal s3.
        if (n + m != s3.length()) {
            return false;
        }

        // dp[i][j] represents whether the first i
        // characters of s1 and first j characters
        // of s2 can form the first i + j characters of s3.
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case:
        // Two empty strings can form an empty string.
        dp[0][0] = true;

        // Initialize the first column.
        // Here, s2 is empty, so s3 must be formed
        // entirely using characters from s1.
        for (int i = 1; i <= n; i++) {

            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {

                dp[i][0] = dp[i - 1][0];
            }
        }

        // Initialize the first row.
        // Here, s1 is empty, so s3 must be formed
        // entirely using characters from s2.
        for (int j = 1; j <= m; j++) {

            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {

                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the remaining DP table.
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                // Current target string index.
                int k = i + j - 1;

                // Option 1: Take the current character
                // from s1.
                boolean fromS1 = false;

                if (s1.charAt(i - 1) == s3.charAt(k)) {

                    fromS1 = dp[i - 1][j];
                }

                // Option 2: Take the current character
                // from s2.
                boolean fromS2 = false;

                if (s2.charAt(j - 1) == s3.charAt(k)) {

                    fromS2 = dp[i][j - 1];
                }

                // If either option works, the current
                // state is possible.
                dp[i][j] = fromS1 || fromS2;
            }
        }

        // Check whether all characters of s1 and s2
        // can form the complete string s3.
        return dp[n][m];
    }

    public static void main(String[] args) {

        InterleavingString solution = new InterleavingString();

        // Example 1
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(solution.isInterleave(s1, s2, s3));
        // Expected: true

        // Example 2
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";

        System.out.println(solution.isInterleave(s1, s2, s3));
        // Expected: false

        // Example 3: All strings are empty.
        s1 = "";
        s2 = "";
        s3 = "";

        System.out.println(solution.isInterleave(s1, s2, s3));
        // Expected: true

        // Example 4: One source string is empty.
        s1 = "";
        s2 = "abc";
        s3 = "abc";

        System.out.println(solution.isInterleave(s1, s2, s3));
        // Expected: true

        // Example 5: Repeated characters.
        s1 = "aa";
        s2 = "ab";
        s3 = "aaba";

        System.out.println(solution.isInterleave(s1, s2, s3));
        // Expected: true
    }
}
