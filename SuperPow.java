/**
 * Problem: Super Pow
 * Difficulty: Medium
 *
 * Task:
 * Given a positive integer `a` and a very large integer `b` represented as an array of digits,
 * return (a^b) % 1337.
 *
 * Key Idea:
 * - Since `b` can be extremely large, we can't directly build the number.
 * - Use modular exponentiation property:
 *   (a^(xy)) % m = ((a^x % m)^(y)) % m
 * - Process `b` digit by digit:
 *   result = (result^10 * a^digit) % 1337
 *
 * Example 1:
 * Input: a = 2, b = [3]
 * Output: 8
 *
 * Example 2:
 * Input: a = 2, b = [1,0]
 * Output: 1024
 *
 * Example 3:
 * Input: a = 1, b = [4,3,3,8,5,2]
 * Output: 1
 *
 * Constraints:
 * - 1 <= a <= 2^31 - 1
 * - 1 <= b.length <= 2000
 * - 0 <= b[i] <= 9
 * - b does not contain leading zeros
 */
public class SuperPow {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;
        a %= MOD;

        for (int digit : b) {
            result = (powmod(result, 10) * powmod(a, digit)) % MOD;
        }

        return result;
    }

    // Fast exponentiation (x^n % MOD)
    private int powmod(int x, int n) {
        int res = 1;
        x %= MOD;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}
