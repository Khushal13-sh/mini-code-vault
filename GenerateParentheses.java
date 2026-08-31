/*
 add solution for generate parentheses
*/

/**
 * Problem: Generate Parentheses
 * Difficulty: Medium
 *
 * Description:
 * Given n pairs of parentheses, generate all combinations
 * of well-formed parentheses.
 *
 * Key Insight:
 * - We can add an opening parenthesis if we still have
 *   opening parentheses available.
 * - We can add a closing parenthesis only when there are
 *   more opening parentheses already used.
 * - This ensures that every generated combination is valid.
 *
 * Approach:
 * - Use Backtracking to build the string character by character.
 * - Keep track of the number of opening and closing parentheses.
 * - When the string length becomes 2 * n, add it to the result.
 *
 * Time Complexity: O(4^n / sqrt(n))
 *
 * Space Complexity: O(n)
 * Excluding the space required to store the result.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve("", 0, 0, n, ans);

        return ans;
    }

    /**
     * Generates valid parentheses combinations using
     * backtracking.
     */
    private void solve(
            String s,
            int open,
            int close,
            int n,
            List<String> ans) {

        // If all parentheses are used, store the combination.
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add an opening parenthesis if available.
        if (open < n) {
            solve(s + "(", open + 1, close, n, ans);
        }

        // Add a closing parenthesis only if it will
        // keep the string valid.
        if (close < open) {
            solve(s + ")", open, close + 1, n, ans);
        }
    }

    public static void main(String[] args) {

        GenerateParentheses obj =
                new GenerateParentheses();

        // Example 1
        int n1 = 3;

        List<String> result1 =
                obj.generateParenthesis(n1);

        System.out.println("Input 1: n = " + n1);
        System.out.println("Output 1: " + result1);

        // Example 2
        int n2 = 1;

        List<String> result2 =
                obj.generateParenthesis(n2);

        System.out.println("Input 2: n = " + n2);
        System.out.println("Output 2: " + result2);
    }
}