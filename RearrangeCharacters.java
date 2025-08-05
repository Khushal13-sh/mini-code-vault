/**
 * Problem: Rearrange Characters to Make Target String
 * Difficulty: Easy
 *
 * Given two strings `s` and `target`:
 *  - You can use letters from `s` to form copies of `target`.
 *  - Return the maximum number of copies of `target` that can be formed.
 *
 * Approach:
 * 1. Count the frequency of each character in `s` and in `target`.
 * 2. For each unique character in `target`, compute how many copies can be formed.
 * 3. The minimum across all characters gives the answer.
 */
public class RearrangeCharacters {

    public int rearrangeCharacters(String s, String target) {
        int min = 101; // Max s.length = 100
        
        for (char ch : target.toCharArray()) {
            int appearCount = getAppearCount(s, ch);
            int required = getAppearCount(target, ch);
            min = minNum(min, appearCount / required);
        }

        return min;
    }

    // Count how many times character 'c' appears in string 'str'
    public int getAppearCount(String str, char c) {
        return str.length() - str.replace(c + "", "").length();
    }

    // Utility method to get minimum of two numbers
    public int minNum(int num1, int num2) {
        return (num1 < num2) ? num1 : num2;
    }

    public static void main(String[] args) {
        RearrangeCharacters solution = new RearrangeCharacters();

        System.out.println(solution.rearrangeCharacters("ilovecodingonleetcode", "code")); // Output: 2
        System.out.println(solution.rearrangeCharacters("abcba", "abc")); // Output: 1
        System.out.println(solution.rearrangeCharacters("abbaccaddaeea", "aaaaa")); // Output: 1
    }
}
