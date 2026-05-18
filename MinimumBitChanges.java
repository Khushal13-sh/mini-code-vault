/*
 add solution for minimum bit changes using bitwise operations
*/

/**
 * Problem: Number of Bit Changes to Make Two Integers Equal
 * Difficulty: Easy
 *
 * Description:
 * You can only change bits from 1 -> 0 in integer n.
 *
 * Return the minimum number of bit changes needed
 * to make n equal to k.
 *
 * If impossible, return -1.
 *
 * Approach:
 * - First check if conversion is possible:
 *      -> Every set bit in k must already exist in n
 * - Use:
 *      (n & k) == k
 *
 * - Find differing bits using XOR:
 *      diff = n ^ k
 *
 * - Count set bits in diff
 *
 * Why this works:
 * - XOR gives positions where bits differ
 * - Since only 1 -> 0 changes are allowed,
 *   k cannot contain a bit that n does not have
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class MinimumBitChanges {

    public int minChanges(int n, int k) {

        // Check if conversion is possible
        if ((n & k) != k) {
            return -1;
        }

        // Find differing bits
        int diff = n ^ k;

        int count = 0;

        // Count set bits
        while (diff > 0) {

            count += diff & 1;
            diff >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {

        MinimumBitChanges obj = new MinimumBitChanges();

        // Example 1
        System.out.println(
            "Output 1: " +
            obj.minChanges(13, 4)
        ); // 2

        // Example 2
        System.out.println(
            "Output 2: " +
            obj.minChanges(21, 21)
        ); // 0

        // Example 3
        System.out.println(
            "Output 3: " +
            obj.minChanges(14, 13)
        ); // -1
    }
}