/**
 * Problem: Largest Odd Number in String
 * Difficulty: Easy
 *
 * From right to left, find the first odd digit.
 * Return the substring from index 0 to that position (inclusive).
 */

public class LargestOddNumberInString {

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LargestOddNumberInString solution = new LargestOddNumberInString();

        System.out.println(solution.largestOddNumber("52"));      // Output: "5"
        System.out.println(solution.largestOddNumber("4206"));    // Output: ""
        System.out.println(solution.largestOddNumber("35427"));   // Output: "35427"
        System.out.println(solution.largestOddNumber("10000"));   // Output: ""
        System.out.println(solution.largestOddNumber("123456789")); // Output: "123456789"
    }
}
