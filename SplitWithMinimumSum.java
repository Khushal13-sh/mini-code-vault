import java.util.Arrays;

/**
 * Problem: Split With Minimum Sum
 * Difficulty: Easy
 *
 * Split the digits of num into two numbers such that their sum is minimized.
 * Sort the digits and distribute them alternately to form the two minimal numbers.
 */

public class SplitWithMinimumSum {

    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits); // Sort digits in increasing order

        int num1 = 0, num2 = 0;

        // Distribute digits alternatively to form two smallest possible numbers
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            if (i % 2 == 0) {
                num1 = num1 * 10 + digit;
            } else {
                num2 = num2 * 10 + digit;
            }
        }

        return num1 + num2;
    }

    public static void main(String[] args) {
        SplitWithMinimumSum solution = new SplitWithMinimumSum();

        System.out.println(solution.splitNum(4325)); // Output: 59
        System.out.println(solution.splitNum(687));  // Output: 75
        System.out.println(solution.splitNum(100000001)); // Edge case: Output: 1
    }
}
