/*
 add solution for checking good integer
*/

/**
 * Problem: Check Good Integer
 * Difficulty: Easy
 *
 * Description:
 * Given a positive integer n:
 *
 * - digitSum = sum of all digits of n
 * - squareSum = sum of squares of all digits of n
 *
 * An integer is called good if:
 *
 * squareSum - digitSum >= 50
 *
 * Return true if n is good, otherwise return false.
 *
 * Key Insight:
 * - Extract each digit using modulo (% 10).
 * - Maintain both digitSum and squareSum.
 * - Check whether their difference is at least 50.
 *
 * Approach:
 * - Initialize digitSum and squareSum as 0.
 * - Traverse all digits of n.
 * - Add digit to digitSum.
 * - Add digit * digit to squareSum.
 * - Return whether (squareSum - digitSum) >= 50.
 *
 * Why this works:
 * - Every digit contributes to both required sums.
 * - After processing all digits, we directly evaluate
 *   the condition given in the problem.
 *
 * Time Complexity: O(d)
 * where d = number of digits in n.
 *
 * Space Complexity: O(1)
 */
public class CheckGoodInteger {

    public boolean checkGoodInteger(int n) {

        int digitSum = 0;
        int squareSum = 0;

        while (n > 0) {

            int digit = n % 10;

            digitSum += digit;
            squareSum += digit * digit;

            n /= 10;
        }

        return (squareSum - digitSum) >= 50;
    }

    public static void main(String[] args) {

        CheckGoodInteger obj = new CheckGoodInteger();

        // Example 1
        int n1 = 1000;
        System.out.println(
                "Output 1: " + obj.checkGoodInteger(n1));

        // Example 2
        int n2 = 19;
        System.out.println(
                "Output 2: " + obj.checkGoodInteger(n2));
    }
}