/*
 add solution for checking substring existence in string and its reverse
*/

/**
 * Problem: Existence of a Substring in a String and Its Reverse
 * Difficulty: Easy
 *
 * Description:
 * Check whether there exists any substring of length 2
 * in the original string that also exists in its reversed string.
 *
 * Key Insight:
 * - Generate the reversed string
 * - Extract every substring of length 2 from original string
 * - Check whether reversed string contains that substring
 *
 * Approach:
 * - Reverse the string using StringBuilder
 * - Traverse the string till length - 1
 * - Extract substring(i, i + 2)
 * - Use contains() to check presence in reversed string
 * - Return true if found
 *
 * Why this works:
 * We directly verify the condition given in the problem
 * for every possible substring of length 2.
 *
 * Time Complexity: O(n²)
 * n = length of string
 *
 * Space Complexity: O(n)
 * For storing reversed string
 */
public class SubstringInReverse {

    public boolean isSubstringPresent(String s) {

        String reversed =
                new StringBuilder(s).reverse().toString();

        for (int i = 0; i < s.length() - 1; i++) {

            String sub = s.substring(i, i + 2);

            if (reversed.contains(sub)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SubstringInReverse obj =
                new SubstringInReverse();

        // Example 1
        System.out.println(
                "Output 1: " +
                obj.isSubstringPresent("leetcode")
        ); // true

        // Example 2
        System.out.println(
                "Output 2: " +
                obj.isSubstringPresent("abcba")
        ); // true

        // Example 3
        System.out.println(
                "Output 3: " +
                obj.isSubstringPresent("abcd")
        ); // false
    }
}