/**
 * Problem: Number of Even and Odd Bits
 * Difficulty: Easy
 *
 * Description:
 * You are given a positive integer `n`.
 * Let:
 *   - even = number of 1-bits at even indices in the binary representation of n
 *   - odd  = number of 1-bits at odd indices in the binary representation of n
 *
 * Note:
 * - Bits are indexed from right to left, starting at 0.
 *
 * Return an array [even, odd].
 *
 * Example 1:
 * Input: n = 50
 * Output: [1, 2]
 * Explanation:
 * Binary of 50 → "110010"
 * 1-bits at indices {1, 4, 5}
 * Index 4 → even
 * Indices 1, 5 → odd
 * So answer = [1, 2].
 *
 * Example 2:
 * Input: n = 2
 * Output: [0, 1]
 * Explanation:
 * Binary of 2 → "10"
 * 1-bit at index 1 (odd index).
 * So answer = [0, 1].
 *
 * Constraints:
 * - 1 <= n <= 1000
 *
 * Approach:
 * - Convert integer `n` to its binary string.
 * - Traverse from right to left while tracking index parity.
 * - If bit is '1':
 *    → If index is even, increment even counter.
 *    → Else increment odd counter.
 *
 * Time Complexity: O(log n) [length of binary string]
 * Space Complexity: O(1)
 */
public class EvenOddBits {

    /**
     * Counts the number of 1-bits at even and odd indices in the binary representation of n.
     *
     * @param n the input integer
     * @return array [even, odd]
     */
    public int[] evenOddBit(int n) {
        String binary = Integer.toBinaryString(n);
        int even = 0, odd = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            if (binary.charAt(length - 1 - i) == '1') {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        EvenOddBits solution = new EvenOddBits();
        int[] result1 = solution.evenOddBit(50);
        System.out.println("Output for n=50: [" + result1[0] + ", " + result1[1] + "]"); // [1, 2]

        int[] result2 = solution.evenOddBit(2);
        System.out.println("Output for n=2: [" + result2[0] + ", " + result2[1] + "]"); // [0, 1]
    }
}
