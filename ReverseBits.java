/**
 * Problem: Reverse Bits
 * Difficulty: Easy
 *
 * Description:
 * Reverse bits of a given 32-bit unsigned integer.
 *
 * Example 1:
 * Input: n = 43261596 (00000010100101000001111010011100 in binary)
 * Output: 964176192 (00111001011110000010100101000000 in binary)
 *
 * Example 2:
 * Input: n = -3 (11111111111111111111111111111101 in binary)
 * Output: 3221225471 (10111111111111111111111111111111 in binary)
 *
 * Constraints:
 * The input is a 32-bit signed integer, but we consider it as unsigned for bit reversal.
 *
 * Approach:
 * - Treat the integer as unsigned
 * - Extract each bit from right to left
 * - Place it in the reversed position (left to right)
 *
 * Time Complexity: O(32) → O(1)
 * Space Complexity: O(1)
 */

public class ReverseBits {

    /**
     * Reverses the bits of a given 32-bit signed integer.
     *
     * @param n input number (treated as unsigned)
     * @return integer with reversed bits
     */
    public int reverseBits(int n) {
        int result = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            // Extract last bit of n
            int bit = n & 1;

            // Shift result left and add the bit
            result = (result << 1) | bit;

            // Right shift n to process next bit
            n >>>= 1; // unsigned shift
        }
        return result;
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        System.out.println("Input: 43261596 → Output: " + solution.reverseBits(43261596));
        System.out.println("Input: -3 → Output: " + solution.reverseBits(-3));
    }
}
