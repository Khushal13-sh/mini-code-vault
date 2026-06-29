/*
 add solution for finding the first matching character from both ends
*/

/**
 * Problem: First Matching Character From Both Ends
 * Difficulty: Easy
 *
 * Description:
 * Given a string s of length n, return the smallest
 * index i such that:
 *
 * s[i] == s[n - i - 1]
 *
 * If no such index exists, return -1.
 *
 * Key Insight:
 * - Compare each character with its corresponding
 *   character from the opposite end.
 * - Return immediately when the first match is found.
 *
 * Approach:
 * - Store the length of the string.
 * - Traverse the string from left to right.
 * - For each index i, compare:
 *      s[i] and s[n - i - 1]
 * - Return i if they are equal.
 * - If no match is found, return -1.
 *
 * Why this works:
 * Since we check indices in increasing order,
 * the first successful comparison gives the
 * smallest valid index.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only constant extra space is used.
 */
public class FirstMatchingCharacterFromBothEnds {

    public int firstMatchingIndex(String s) {

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == s.charAt(n - i - 1)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        FirstMatchingCharacterFromBothEnds obj =
                new FirstMatchingCharacterFromBothEnds();

        // Example 1
        System.out.println("Output 1: " +
                obj.firstMatchingIndex("abcacbd"));

        // Example 2
        System.out.println("Output 2: " +
                obj.firstMatchingIndex("abc"));

        // Example 3
        System.out.println("Output 3: " +
                obj.firstMatchingIndex("abcdab"));
    }
}