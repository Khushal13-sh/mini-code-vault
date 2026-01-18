/**
 * Problem: Reverse String Prefix
 * Difficulty: Easy
 *
 * Reverse the first k characters of a string and
 * return the resulting string.
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * Explanation:
 * The first k = 2 characters "ab" are reversed to "ba".
 * The final resulting string is "bacd".
 *
 * Example 2:
 * Input: s = "xyz", k = 3
 * Output: "zyx"
 * Explanation:
 * The first k = 3 characters "xyz" are reversed to "zyx".
 * The final resulting string is "zyx".
 *
 * Example 3:
 * Input: s = "hey", k = 1
 * Output: "hey"
 * Explanation:
 * Reversing a single character does not change the string.
 */
public class ReverseStringPrefix {

    public String reversePrefix(String s, int k) {

        char[] chars = s.toCharArray();
        int left = 0;
        int right = k - 1;

        // Reverse first k characters
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    // Main method with example test cases
    public static void main(String[] args) {

        ReverseStringPrefix solution = new ReverseStringPrefix();

        // Example 1
        String s1 = "abcd";
        int k1 = 2;
        System.out.println("Example 1 Output: " + solution.reversePrefix(s1, k1));

        // Example 2
        String s2 = "xyz";
        int k2 = 3;
        System.out.println("Example 2 Output: " + solution.reversePrefix(s2, k2));

        // Example 3
        String s3 = "hey";
        int k3 = 1;
        System.out.println("Example 3 Output: " + solution.reversePrefix(s3, k3));
    }
}
