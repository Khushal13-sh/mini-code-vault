/**
 * Problem: Divide Two Integers
 * Difficulty: Medium
 *
 * Divides two integers without using multiplication,
 * division, or modulo operators.
 *
 * Uses bit shifting and subtraction to calculate
 * the quotient.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // Special case:
        // -2147483648 / -1 = 2147483648
        // which cannot be stored in an int.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // If signs are different, result will be negative.
        boolean negative = (dividend < 0) != (divisor < 0);

        // Use long because Integer.MIN_VALUE cannot be
        // converted to positive int directly.
        long a = dividend;
        long b = divisor;

        // Work with positive values.
        if (a < 0) {
            a = -a;
        }

        if (b < 0) {
            b = -b;
        }

        long quotient = 0;

        while (a >= b) {

            // Current value of divisor.
            long temp = b;

            // How many times the divisor is represented.
            long multiple = 1;

            // Keep doubling the divisor while it fits.
            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            // Subtract the largest possible multiple.
            a = a - temp;

            // Add that multiple to the quotient.
            quotient = quotient + multiple;
        }

        // Apply the original sign.
        if (negative) {
            quotient = -quotient;
        }

        // Handle integer boundaries.
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }

    public static void main(String[] args) {

        DivideTwoIntegers solution = new DivideTwoIntegers();

        System.out.println(solution.divide(10, 3));            // 3
        System.out.println(solution.divide(7, -3));           // -2
        System.out.println(solution.divide(-10, 3));          // -3
        System.out.println(solution.divide(-10, -3));         // 3

        System.out.println(solution.divide(43, 3));           // 14
        System.out.println(solution.divide(1, 1));            // 1
        System.out.println(solution.divide(0, 5));            // 0

        System.out.println(
            solution.divide(Integer.MIN_VALUE, -1)
        );                                                     // 2147483647

        System.out.println(
            solution.divide(Integer.MIN_VALUE, 1)
        );                                                     // -2147483648
    }
}