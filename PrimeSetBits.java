/**
 * Problem Title: Prime Number of Set Bits in Binary Representation
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given two integers 'left' and 'right', return the count of numbers within the 
 * inclusive range [left, right] that have a prime number of set bits in their 
 * binary representation.
 * 
 * 📝 Definition:
 * - A set bit in a binary number is a bit with value '1'.
 * - Prime numbers are natural numbers greater than 1 that have only two factors: 1 and itself.
 * 
 * 📥 Example 1:
 * Input:  left = 6, right = 10
 * Output: 4
 * Explanation:
 * - 6  -> 110  (2 set bits, prime)
 * - 7  -> 111  (3 set bits, prime)
 * - 8  -> 1000 (1 set bit, not prime)
 * - 9  -> 1001 (2 set bits, prime)
 * - 10 -> 1010 (2 set bits, prime)
 * - Total prime set bits count: 4
 * 
 * 📥 Example 2:
 * Input:  left = 10, right = 15
 * Output: 5
 * Explanation:
 * - 10 -> 1010 (2 set bits, prime)
 * - 11 -> 1011 (3 set bits, prime)
 * - 12 -> 1100 (2 set bits, prime)
 * - 13 -> 1101 (3 set bits, prime)
 * - 14 -> 1110 (3 set bits, prime)
 * - 15 -> 1111 (4 set bits, not prime)
 * - Total prime set bits count: 5
 * 
 * 📌 Constraints:
 * - 1 <= left <= right <= 10^6
 * - 0 <= right - left <= 10^4
 */

import java.util.*;

public class PrimeSetBits {

    /**
     * 🧠 Logic:
     * - Precompute a set of prime numbers within the range [1, 31] because:
     *   - The maximum number of set bits in an integer (32-bit) is 31.
     * - For each number between left and right:
     *   1. Count the set bits using Integer.bitCount().
     *   2. Check if the count is prime.
     *   3. Increment the count if prime.
     */
    public static int countPrimeSetBits(int left, int right) {
        // Prime numbers up to 31
        Set<Integer> primeSet = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int primeBitsCount = 0;

        // Loop through the range [left, right]
        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);  // Count the number of set bits

            // Check if the number of set bits is prime
            if (primeSet.contains(setBits)) {
                primeBitsCount++;
            }
        }

        return primeBitsCount;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int left1 = 6, right1 = 10;
        System.out.println("Prime Set Bits Count: " + countPrimeSetBits(left1, right1));  // Expected: 4

        int left2 = 10, right2 = 15;
        System.out.println("Prime Set Bits Count: " + countPrimeSetBits(left2, right2));  // Expected: 5
    }
}
