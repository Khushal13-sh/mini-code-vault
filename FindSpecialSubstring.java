/**
 * Problem: Find Special Substring of Length K
 * Difficulty: Easy
 *
 * Determine if there exists a substring of length k consisting of only one
 * distinct character, and the characters adjacent to it (if any) are different.
 */
public class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        if (k > n) return false;

        for (int i = 0; i + k <= n; i++) {
            String sub = s.substring(i, i + k);
            char c = sub.charAt(0);

            // Check if all characters are identical
            boolean allSame = true;
            for (int j = 1; j < k; j++) {
                if (sub.charAt(j) != c) {
                    allSame = false;
                    break;
                }
            }

            if (!allSame) continue;

            // Ensure boundary characters are different
            if (i > 0 && s.charAt(i - 1) == c) continue;
            if (i + k < n && s.charAt(i + k) == c) continue;

            return true;
        }

        return false;
    }

    // --- test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hasSpecialSubstring("aaabaaa", 3)); // true
        System.out.println(sol.hasSpecialSubstring("abc", 2));     // false
        System.out.println(sol.hasSpecialSubstring("bbbb", 2));    // false
    }
}
