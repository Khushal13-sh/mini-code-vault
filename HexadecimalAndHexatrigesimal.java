/**
 * Problem: Hexadecimal and Hexatrigesimal Conversion
 * Difficulty: Easy
 *
 * Description:
 * Given an integer n, return the concatenation of:
 *   - Hexadecimal representation of n²
 *   - Hexatrigesimal (base-36) representation of n³
 *
 * Hexadecimal uses digits 0–9 and A–F (base 16)
 * Hexatrigesimal uses digits 0–9 and A–Z (base 36)
 *
 * Example 1:
 * Input: n = 13
 * Output: "A91P1"
 * Explanation:
 *   n² = 169 → Hex = "A9"
 *   n³ = 2197 → Base-36 = "1P1"
 *   Result = "A9" + "1P1" = "A91P1"
 *
 * Example 2:
 * Input: n = 36
 * Output: "5101000"
 * Explanation:
 *   n² = 1296 → Hex = "510"
 *   n³ = 46656 → Base-36 = "1000"
 *   Result = "5101000"
 */

public class HexadecimalAndHexatrigesimal {

    // Main logic
    public String concatHex36(int n) {
        long n2 = (long) n * n;
        long n3 = (long) n * n * n;

        // Convert n² → Hexadecimal (base 16)
        String hex = toBase(n2, 16);

        // Convert n³ → Hexatrigesimal (base 36)
        String hex36 = toBase(n3, 36);

        return hex + hex36;
    }

    // Converts a given number into base-N (supports up to base-36)
    private String toBase(long num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = (int) (num % base);
            char ch = (rem < 10) ? (char) ('0' + rem) : (char) ('A' + (rem - 10));
            sb.append(ch);
            num /= base;
        }
        return sb.reverse().toString();
    }

    // main() for testing examples
    public static void main(String[] args) {
        HexadecimalAndHexatrigesimal sol = new HexadecimalAndHexatrigesimal();

        // Example 1
        int n1 = 13;
        System.out.println("Example 1 Output: " + sol.concatHex36(n1));
        // Expected: A91P1

        // Example 2
        int n2 = 36;
        System.out.println("Example 2 Output: " + sol.concatHex36(n2));
        // Expected: 5101000

        // Example 3 (extra test)
        int n3 = 5;
        System.out.println("Example 3 Output: " + sol.concatHex36(n3));
        // n²=25→19, n³=125→3H → Expected: 193H
    }
}
