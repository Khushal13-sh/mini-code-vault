/*
 add solution for checking exactly one consecutive set bits pair
*/

/**
 * Problem: Exactly One Consecutive Set Bits Pair
 * Difficulty: Easy
 *
 * Description:
 * Given an integer n, return true if its binary
 * representation contains exactly one adjacent
 * pair of set bits ('11'), otherwise return false.
 *
 * Examples:
 * 6  -> 110  -> true
 * 5  -> 101  -> false
 *
 * Key Insight:
 * - Check every pair of adjacent bits.
 * - A pair of consecutive set bits exists when
 *   the last two bits are both 1.
 * - In binary, "11" equals decimal 3.
 *
 * Approach:
 * - Traverse the binary representation using
 *   right shift operations.
 * - Check whether the last two bits are "11"
 *   using (n & 3) == 3.
 * - Count such occurrences.
 * - If more than one pair is found,
 *   return false immediately.
 * - Return true only if exactly one pair exists.
 *
 * Why this works:
 * - (n & 3) extracts the last two bits.
 * - Every adjacent bit pair is checked once
 *   while shifting through the number.
 *
 * Time Complexity: O(log n)
 *
 * Space Complexity: O(1)
 */
public class ExactlyOneConsecutiveSetBitsPair {

    public boolean consecutiveSetBits(int n) {

        int count = 0;

        while (n > 0) {

            if ((n & 3) == 3) {
                count++;

                if (count > 1) {
                    return false;
                }
            }

            n >>= 1;
        }

        return count == 1;
    }

    public static void main(String[] args) {

        ExactlyOneConsecutiveSetBitsPair obj =
                new ExactlyOneConsecutiveSetBitsPair();

        // Example 1
        int n1 = 6;
        System.out.println(
                "Output 1: " +
                obj.consecutiveSetBits(n1));

        // Example 2
        int n2 = 5;
        System.out.println(
                "Output 2: " +
                obj.consecutiveSetBits(n2));
    }
}