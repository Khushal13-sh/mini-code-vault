/*
 add solution for finding maximum nesting depth of parentheses
*/

/**
 * Problem: Maximum Nesting Depth of the Parentheses
 * Difficulty: Easy
 *
 * Description:
 * Given a valid parentheses string (VPS), return the maximum
 * nesting depth of the parentheses.
 *
 * The nesting depth is the maximum number of open parentheses
 * that exist at any point while traversing the string.
 *
 * Key Insight:
 * - Every '(' increases the current depth.
 * - Every ')' decreases the current depth.
 * - Track the maximum depth reached during traversal.
 *
 * Approach:
 * - Initialize currentDepth = 0 and maxDepth = 0.
 * - Traverse each character in the string.
 * - If character is '(':
 *      - Increment currentDepth.
 *      - Update maxDepth.
 * - If character is ')':
 *      - Decrement currentDepth.
 * - Return maxDepth.
 *
 * Why this works:
 * currentDepth always represents the number of currently
 * open parentheses. The maximum value reached is the
 * nesting depth of the expression.
 *
 * Time Complexity: O(n)
 * - Single traversal of the string.
 *
 * Space Complexity: O(1)
 * - Only two integer variables are used.
 */
public class MaximumNestingDepthOfParentheses {

    public int maxDepth(String s) {

        int maxDepth = 0;
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            else if (ch == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOfParentheses obj =
                new MaximumNestingDepthOfParentheses();

        // Example 1
        System.out.println(
                obj.maxDepth("(1+(2*3)+((8)/4))+1")
        ); // 3

        // Example 2
        System.out.println(
                obj.maxDepth("(1)+((2))+(((3)))")
        ); // 3

        // Example 3
        System.out.println(
                obj.maxDepth("()(())((()()))")
        ); // 3
    }
}