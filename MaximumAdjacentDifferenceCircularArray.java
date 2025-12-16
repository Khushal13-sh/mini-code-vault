/**
 * Problem: Maximum Difference Between Adjacent Elements in a Circular Array
 * Difficulty: Easy
 *
 * Find the maximum absolute difference between
 * adjacent elements in a circular array.
 */

public class MaximumAdjacentDifferenceCircularArray {

    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; // Circular adjacency

            int diff = nums[i] - nums[next];

            // Convert to absolute value
            if (diff < 0) {
                diff = -diff;
            }

            // Track maximum difference
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        return maxDiff;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaximumAdjacentDifferenceCircularArray obj =
                new MaximumAdjacentDifferenceCircularArray();

        System.out.println(obj.maxAdjacentDistance(new int[]{1, 2, 4}));      // 3
        System.out.println(obj.maxAdjacentDistance(new int[]{-5, -10, -5})); // 5
    }
}
