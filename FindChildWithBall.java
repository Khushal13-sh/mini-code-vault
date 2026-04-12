/*
 add solution for finding child with ball after k seconds using cycle simulation
*/

/**
 * Problem: Find the Child Who Has the Ball After K Seconds
 * Difficulty: Easy
 *
 * Description:
 * There are n children in a line. A ball is passed every second.
 * The direction reverses at both ends.
 * Find which child has the ball after k seconds.
 *
 * Key Insight:
 * - Movement follows a back-and-forth pattern
 * - One full cycle = 2 * (n - 1)
 *
 * Approach:
 * - Compute cycle length = 2 * (n - 1)
 * - Reduce k using modulo (k % cycle)
 * - If k < n → moving forward → index = k
 * - Else → moving backward → index = cycle - k
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class FindChildWithBall {

    public int numberOfChild(int n, int k) {

        int cycle = 2 * (n - 1);
        k = k % cycle;

        if (k < n) {
            return k;
        } else {
            return cycle - k;
        }
    }

    public static void main(String[] args) {
        FindChildWithBall obj = new FindChildWithBall();

        // Example 1
        int n1 = 3, k1 = 5;
        System.out.println("Output 1: " + obj.numberOfChild(n1, k1)); // 1

        // Example 2
        int n2 = 5, k2 = 6;
        System.out.println("Output 2: " + obj.numberOfChild(n2, k2)); // 2

        // Example 3
        int n3 = 4, k3 = 2;
        System.out.println("Output 3: " + obj.numberOfChild(n3, k3)); // 2
    }
}