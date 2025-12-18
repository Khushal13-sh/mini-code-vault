/**
 * Problem: Hamming Distance
 * Difficulty: Easy
 *
 * The Hamming distance is the number of bit positions
 * at which two numbers differ.
 */

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        // Count set bits in xor
        while (xor != 0) {
            xor = xor & (xor - 1); // remove rightmost set bit
            count++;
        }

        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();

        System.out.println("Output: " + obj.hammingDistance(1, 4)); // 2
        System.out.println("Output: " + obj.hammingDistance(3, 1)); // 1
    }
}
