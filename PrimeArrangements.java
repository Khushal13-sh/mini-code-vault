/**
 * Problem Title: Prime Arrangements
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * Return the number of permutations of numbers from 1 to n such that 
 * all prime numbers are placed at **prime indices** (1-based indexing).
 *
 * A prime number is an integer greater than 1 with no positive divisors other than 1 and itself.
 * 
 * Since the result may be large, return it modulo 10^9 + 7.
 * 
 * 📥 Example 1:
 * Input: n = 5
 * Output: 12
 * Explanation:
 * - Primes <= 5 are {2, 3, 5} → 3 primes
 * - Prime indices <= 5 are also {2, 3, 5} → 3 positions
 * - So, arrange 3 primes in 3 prime positions → 3! = 6
 * - Arrange 2 non-primes in 2 non-prime positions → 2! = 2
 * - Total valid permutations = 6 * 2 = 12
 *
 * 📥 Example 2:
 * Input: n = 100
 * Output: 682289015
 *
 * 📌 Constraints:
 * - 1 <= n <= 100
 */

public class PrimeArrangements {
    static final int MOD = 1_000_000_007;

    /**
     * 🧠 Logic:
     * - Count how many numbers from 1 to n are prime.
     * - Those primes must be placed at prime indices (positions).
     * - So answer = primeCount! * (n - primeCount)!
     */
    public static int numPrimeArrangements(int n) {
        int primeCount = 0;

        // Count primes up to n
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        // Calculate factorial(primeCount) * factorial(n - primeCount) % MOD
        long result = (factorial(primeCount) * factorial(n - primeCount)) % MOD;
        return (int) result;
    }

    // 🔍 Prime check
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 🔢 Factorial with modulo
    private static long factorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    // 🧪 Main method for testing
    public static void main(String[] args) {
        int n1 = 5;
        System.out.println("Valid Prime Arrangements for n = " + n1 + ": " + numPrimeArrangements(n1));  // Expected: 12

        int n2 = 100;
        System.out.println("Valid Prime Arrangements for n = " + n2 + ": " + numPrimeArrangements(n2));  // Expected: 682289015
    }
}
