/**
 * Problem: Minimum Operations to Exceed Threshold Value I
 * Difficulty: Easy
 *
 * In one operation, remove the smallest element.
 * Count how many elements are less than k.
 */
public class MinimumOperationsToExceedThresholdValueI {

    public int minOperations(int[] nums, int k) {
        int operations = 0;

        // Count elements smaller than k
        for (int num : nums) {
            if (num < k) {
                operations++;
            }
        }

        return operations;
    }

    // Main method for testing
    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValueI obj =
                new MinimumOperationsToExceedThresholdValueI();

        System.out.println(obj.minOperations(
                new int[]{2, 11, 10, 1, 3}, 10)); // 3

        System.out.println(obj.minOperations(
                new int[]{1, 1, 2, 4, 9}, 1)); // 0

        System.out.println(obj.minOperations(
                new int[]{1, 1, 2, 4, 9}, 9)); // 4
    }
}
