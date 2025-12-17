import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Minimum Number of Operations to Make Elements in Array Distinct
 * Difficulty: Easy
 *
 * Repeatedly remove 3 elements from the beginning of the array
 * until the remaining elements are all distinct.
 */

public class MinimumOperationsToMakeArrayDistinct {

    public int minimumOperations(int[] nums) {
        int n = nums.length;

        // Maximum operations possible
        int maxOps = (n + 2) / 3;

        for (int ops = 0; ops <= maxOps; ops++) {
            int start = ops * 3;

            // If all elements are removed
            if (start >= n) {
                return ops;
            }

            Set<Integer> seen = new HashSet<>();
            boolean distinct = true;

            // Check if remaining elements are distinct
            for (int i = start; i < n; i++) {
                if (!seen.add(nums[i])) {
                    distinct = false;
                    break;
                }
            }

            if (distinct) {
                return ops;
            }
        }

        return maxOps;
    }

    // Main method for testing
    public static void main(String[] args) {
        MinimumOperationsToMakeArrayDistinct obj =
                new MinimumOperationsToMakeArrayDistinct();

        System.out.println(obj.minimumOperations(
                new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7})); // 2

        System.out.println(obj.minimumOperations(
                new int[]{4, 5, 6, 4, 4})); // 2

        System.out.println(obj.minimumOperations(
                new int[]{6, 7, 8, 9})); // 0
    }
}
