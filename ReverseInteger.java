
/**
 * Problem: Reverse Integer
 * Difficulty: Medium
 *
 * Reverses the digits of a signed 32-bit integer.
 * Returns 0 if the reversed number causes integer overflow.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {

            // Extract the last digit.
            int digit = x % 10;

            // Remove the last digit from x.
            x = x / 10;

            // Check for positive integer overflow.
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for negative integer overflow.
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Append the extracted digit.
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        System.out.println(solution.reverse(123));           // 321
        System.out.println(solution.reverse(-123));          // -321
        System.out.println(solution.reverse(120));           // 21
        System.out.println(solution.reverse(0));             // 0
        System.out.println(solution.reverse(1534236469));    // 0
    }
}