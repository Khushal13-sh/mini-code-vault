/*
 add solution for minimum bit flips to convert one number into another
*/

/**
 * Problem: Minimum Bit Flips to Convert Number
 * Difficulty: Easy
 *
 * Description:
 * Given two integers start and goal,
 * return the minimum number of bit flips required
 * to convert start into goal.
 *
 * A bit flip changes a bit from:
 * - 0 to 1
 * - 1 to 0
 *
 * Key Insight:
 * - Compare bits of start and goal one by one.
 * - Whenever corresponding bits are different,
 *   one flip is required.
 *
 * Approach:
 * - Extract the last bit of both numbers using % 2.
 * - If bits are different, increment count.
 * - Remove the processed bit using / 2.
 * - Continue until both numbers become 0.
 *
 * Why this works:
 * Every differing bit must be flipped exactly once.
 * Counting differing bits gives the minimum flips.
 *
 * Time Complexity: O(log(max(start, goal)))
 *
 * Space Complexity: O(1)
 */
public class MinimumBitFlipsToConvertNumber {

    public int minBitFlips(int start, int goal) {

        int count = 0;

        while (start > 0 || goal > 0) {

            int bit1 = start % 2;
            int bit2 = goal % 2;

            if (bit1 != bit2) {
                count++;
            }

            start /= 2;
            goal /= 2;
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumBitFlipsToConvertNumber obj =
                new MinimumBitFlipsToConvertNumber();

        // Example 1
        System.out.println(obj.minBitFlips(10, 7)); // 3

        // Example 2
        System.out.println(obj.minBitFlips(3, 4)); // 3
    }
}