/**
 * Problem: Remove Zeros in Decimal Representation
 * Difficulty: Easy
 *
 * Description:
 * Given a positive integer n, return the integer obtained 
 * by removing all zeros from its decimal representation.
 *
 * Example 1:
 * Input: n = 1020030
 * Output: 123
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 */

public class RemoveZerosInDecimal {

    public long removeZeros(long n) {
        long result = 0;
        long place = 1;

        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                result += digit * place;
                place *= 10;
            }
            n /= 10;
        }

        return result;
    }

    // main() for quick testing
    public static void main(String[] args) {
        RemoveZerosInDecimal sol = new RemoveZerosInDecimal();

        System.out.println("Example 1 Output: " + sol.removeZeros(1020030)); // 123
        System.out.println("Example 2 Output: " + sol.removeZeros(1));       // 1
        System.out.println("Extra Test Output: " + sol.removeZeros(900090)); // 99
    }
}
