import java.util.Arrays;

/**
 * Problem: Assign Cookies
 * Difficulty: Easy
 * 
 * You are given two integer arrays:
 * - g[]: greed factor of each child
 * - s[]: size of each cookie
 * 
 * Each child gets at most one cookie.
 * Return the maximum number of children that can be content.
 */

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes

        int happyChild = 0;
        int cookie = 0;

        while (happyChild < g.length && cookie < s.length) {
            if (s[cookie] >= g[happyChild]) {
                happyChild++; // Cookie satisfies the current child
            }
            cookie++; // Try next cookie either way
        }

        return happyChild;
    }

    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();

        int[] g1 = {1, 2, 3}, s1 = {1, 1};
        int[] g2 = {1, 2}, s2 = {1, 2, 3};

        System.out.println("Example 1 Output: " + solution.findContentChildren(g1, s1)); // Output: 1
        System.out.println("Example 2 Output: " + solution.findContentChildren(g2, s2)); // Output: 2
    }
}
