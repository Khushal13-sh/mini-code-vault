import java.util.Arrays;

/**
 * Problem: Count Primes
 * Difficulty: Medium
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * We solve this using the Sieve of Eratosthenes:
 * 1. Assume all numbers are prime initially.
 * 2. Starting from 2, mark all multiples of each prime as non-prime.
 * 3. Count the remaining true values in the array.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * - 0 <= n <= 5 * 10^6
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // Quick test
    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();

        System.out.println(solution.countPrimes(10)); // 4
        System.out.println(solution.countPrimes(0));  // 0
        System.out.println(solution.countPrimes(1));  // 0
    }
}
