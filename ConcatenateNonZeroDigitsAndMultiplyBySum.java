/*
 add solution for concatenating non-zero digits and multiplying by their sum
*/

/**
 * Problem: Concatenate Non-Zero Digits and Multiply by Sum I
 * Difficulty: Easy
 *
 * Description:
 * Given an integer n:
 *
 * - Form a new integer x by concatenating all
 *   non-zero digits in their original order.
 * - Compute the sum of digits in x.
 * - Return x * sum.
 *
 * If n contains only zeros, x is 0.
 *
 * Key Insight:
 * - Traverse each digit as a character.
 * - Ignore zeros while building x.
 * - Simultaneously compute the digit sum.
 *
 * Approach:
 * - Handle the special case when n is 0.
 * - Convert n to a string.
 * - Traverse each character.
 * - If the digit is non-zero:
 *      - Append it to x.
 *      - Add it to sum.
 * - Return x * sum.
 *
 * Why this works:
 * The digits are processed in their original order,
 * allowing x and its digit sum to be built in a
 * single traversal.
 *
 * Time Complexity: O(d)
 * where d is the number of digits.
 *
 * Space Complexity: O(d)
 * String representation of the number is used.
 */
public class ConcatenateNonZeroDigitsAndMultiplyBySum {

    public long sumAndMultiply(int n) {

        if (n == 0) {
            return 0;
        }

        String num = String.valueOf(n);

        long x = 0;
        long sum = 0;

        for (char ch : num.toCharArray()) {

            int digit = ch - '0';

            if (digit != 0) {
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return x * sum;
    }

    public static void main(String[] args) {

        ConcatenateNonZeroDigitsAndMultiplyBySum obj =
                new ConcatenateNonZeroDigitsAndMultiplyBySum();

        // Example 1
        System.out.println("Output 1: " +
                obj.sumAndMultiply(10203004));

        // Example 2
        System.out.println("Output 2: " +
                obj.sumAndMultiply(1000));

        // Example 3
        System.out.println("Output 3: " +
                obj.sumAndMultiply(0));
    }
}