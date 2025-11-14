/**
 * Problem: Substring Matching Pattern
 * Difficulty: Easy
 *
 * You are given two strings: 
 * - s → the main string
 * - p → a pattern string containing exactly one '*'
 *
 * The '*' can match ANY sequence of characters (including empty).
 *
 * Task:
 * Check if the pattern p can be transformed into a substring of s 
 * by replacing '*' with any sequence of characters.
 *
 * Return:
 *  - true  → if p can match any substring of s
 *  - false → otherwise
 *
 * Example:
 *  Input: s = "leetcode", p = "ee*e"
 *  '*' → "tcod"
 *  "eetcode" becomes a substring → true
 */
public class SubstringPatternMatch {

    public boolean hasMatch(String s, String p) {

        int starIndex = p.indexOf('*');
        String prefix = p.substring(0, starIndex);
        String suffix = p.substring(starIndex + 1);

        int n = s.length();

        // Try all positions where prefix can match
        for (int i = 0; i + prefix.length() <= n; i++) {

            if (!s.startsWith(prefix, i)) continue;

            int remainingStart = i + prefix.length();

            // Try all possible matches for '*'
            for (int end = remainingStart; end <= n; end++) {
                if (end + suffix.length() <= n &&
                    s.startsWith(suffix, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    // ------------------------
    // Main Method (Examples)
    // ------------------------
    public static void main(String[] args) {
        SubstringPatternMatch solver = new SubstringPatternMatch();

        // Example 1
        System.out.println(solver.hasMatch("leetcode", "ee*e"));  
        // Expected: true

        // Example 2
        System.out.println(solver.hasMatch("car", "c*v"));       
        // Expected: false

        // Example 3
        System.out.println(solver.hasMatch("luck", "u*"));        
        // Expected: true
    }
}
