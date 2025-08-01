import java.util.*;

/**
 * Problem: Minimum String Length After Removing Substrings
 * Difficulty: Easy
 *
 * Given a string s of uppercase letters, repeatedly remove any occurrence of
 * "AB" or "CD" until no such substrings remain. Return the minimum length of
 * the resulting string.
 *
 * Approach:
 * - Use a stack (StringBuilder) to simulate removals.
 * - Traverse each character in s:
 *      - If top of stack with current char forms "AB" or "CD", pop from stack.
 *      - Otherwise, push char to stack.
 * - Remaining stack length is the answer.
 */
public class MinimumStringLengthAfterRemoving {

    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0) {
                char top = stack.charAt(len - 1);
                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    stack.deleteCharAt(len - 1); // Remove the pair
                    continue; // Skip appending current char
                }
            }
            stack.append(c); // Push current char
        }

        return stack.length();
    }

    public static void main(String[] args) {
        MinimumStringLengthAfterRemoving solution = new MinimumStringLengthAfterRemoving();

        System.out.println(solution.minLength("ABFCACDB")); // Expected: 2
        System.out.println(solution.minLength("ACBBD"));    // Expected: 5
        System.out.println(solution.minLength("CDAB"));     // Expected: 0
        System.out.println(solution.minLength("AABBCCDD")); // Expected: 0
    }
}
