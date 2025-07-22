/**
 * Problem: Make Three Strings Equal
 * Difficulty: Easy
 *
 * Given three strings, find the minimum number of operations to make them equal
 * by repeatedly removing the rightmost character of any string. Return -1 if impossible.
 */

public class MakeThreeStringsEqual {

    public int findMinimumOperations(String s1, String s2, String s3) {
        String commonPrefix = commonPrefixOfAll(s1, s2, s3);

        if (commonPrefix.length() == 0) return -1;

        return (s1.length() - commonPrefix.length()) +
               (s2.length() - commonPrefix.length()) +
               (s3.length() - commonPrefix.length());
    }

    private String commonPrefixOfAll(String s1, String s2, String s3) {
        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;

        while (i < minLen && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    public static void main(String[] args) {
        MakeThreeStringsEqual solution = new MakeThreeStringsEqual();

        System.out.println(solution.findMinimumOperations("abc", "abb", "ab"));  // Output: 2
        System.out.println(solution.findMinimumOperations("dac", "bac", "cac"));  // Output: -1
        System.out.println(solution.findMinimumOperations("abc", "abc", "abc"));  // Output: 0
        System.out.println(solution.findMinimumOperations("abcd", "abc", "ab"));  // Output: 4
    }
}
