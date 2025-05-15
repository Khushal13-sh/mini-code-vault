/**
 * Problem Title: DI String Match
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given a string 's' of length n, construct a permutation 'perm' of n+1 integers (from 0 to n) 
 * such that:
 * - s[i] == 'I' -> perm[i] < perm[i + 1] (Increasing)
 * - s[i] == 'D' -> perm[i] > perm[i + 1] (Decreasing)
 * 
 * 🔍 Return any valid permutation.
 * 
 * 📥 Example 1:
 * Input: s = "IDID"
 * Output: [0, 4, 1, 3, 2]
 * 
 * 📥 Example 2:
 * Input: s = "III"
 * Output: [0, 1, 2, 3]
 * 
 * 📥 Example 3:
 * Input: s = "DDI"
 * Output: [3, 2, 0, 1]
 * 
 * 📌 Constraints:
 * - 1 <= s.length <= 10^5
 * - s[i] is either 'I' or 'D'.
 */

import java.util.*;

public class DIStringMatch {

    /**
     * 🧠 Logic:
     * - Use two pointers 'low' and 'high' to construct the permutation.
     * - Traverse the string:
     *   - If 'I' -> assign low value and increment low.
     *   - If 'D' -> assign high value and decrement high.
     * - Add the remaining value at the end.
     * - This ensures that the permutation satisfies the given conditions.
     */
    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] perm = new int[len + 1];
        int low = 0;
        int high = len;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I')
                perm[i] = low++;
            else
                perm[i] = high--;
        }

        perm[len] = low;  // Add the remaining value
        return perm;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        DIStringMatch solution = new DIStringMatch();

        // Test case 1: "IDID"
        String s1 = "IDID";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + Arrays.toString(solution.diStringMatch(s1)));

        // Test case 2: "III"
        String s2 = "III";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + Arrays.toString(solution.diStringMatch(s2)));

        // Test case 3: "DDI"
        String s3 = "DDI";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + Arrays.toString(solution.diStringMatch(s3)));
    }
}
