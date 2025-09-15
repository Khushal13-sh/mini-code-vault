/**
 * Problem: Number of Common Factors
 * Difficulty: Easy
 *
 * Given two positive integers a and b, return the number of common factors.
 * An integer x is a common factor of a and b if x divides both a and b.
 *
 * Example 1:
 * Input: a = 12, b = 6
 * Output: 4
 * Explanation: The common factors are 1, 2, 3, 6.
 *
 * Example 2:
 * Input: a = 25, b = 30
 * Output: 2
 * Explanation: The common factors are 1, 5.
 *
 * Constraints:
 * 1 <= a, b <= 1000
 *
 * Approach:
 * - Iterate from 1 to min(a, b).
 * - Count all numbers that divide both a and b.
 * - Optimized approach: use gcd(a, b), and count its divisors only.
 */
public class NumberOfCommonFactors {

    /**
     * Brute force approach: check from 1 to min(a, b)
     */
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 0;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Optimized approach: find gcd, then count divisors of gcd
     */
    public int commonFactorsOptimized(int a, int b) {
        int gcd = gcd(a, b);
        int count = 0;

        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) {
                count++;
            }
        }
        return count;
    }

    // Euclidean Algorithm for GCD
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    // Quick test
    public static void main(String[] args) {
        NumberOfCommonFactors solution = new NumberOfCommonFactors();

        System.out.println(solution.commonFactors(12, 6));   // 4
        System.out.println(solution.commonFactors(25, 30));  // 2
        System.out.println(solution.commonFactors(10, 15));  // 2 (1, 5)
        System.out.println(solution.commonFactorsOptimized(12, 6));  // 4
    }
}
