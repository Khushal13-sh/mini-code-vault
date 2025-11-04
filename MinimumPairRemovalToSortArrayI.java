/**
 * Problem: Minimum Pair Removal to Sort Array I
 * Difficulty: Easy
 *
 * Description:
 * You can perform this operation on array `nums`:
 *   - Choose the adjacent pair with the smallest sum.
 *   - If multiple pairs have the same sum, choose the leftmost.
 *   - Replace that pair with their sum.
 *
 * Repeat until the array becomes non-decreasing.
 * Return the minimum number of operations needed.
 *
 * Example 1:
 * Input: nums = [5, 2, 3, 1]
 * Output: 2
 *
 * Steps:
 * (3,1) -> sum = 4 → nums = [5,2,4]
 * (2,4) -> sum = 6 → nums = [5,6]
 * Result = 2 operations
 *
 * Example 2:
 * Input: nums = [1,2,2]
 * Output: 0 (already sorted)
 */

public class MinimumPairRemovalToSortArrayI {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ops = 0;

        // Copy original array (so nums isn't modified)
        int[] arr = new int[n];
        System.arraycopy(nums, 0, arr, 0, n);
        int size = n;

        // Repeat until array is sorted
        while (!isSorted(arr, size)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            // Find leftmost pair with minimum sum
            for (int i = 0; i < size - 1; i++) {
                int sum = arr[i] + arr[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Replace the pair with their sum
            arr[index] = arr[index] + arr[index + 1];

            // Shift elements to remove the second of the pair
            for (int j = index + 1; j < size - 1; j++) {
                arr[j] = arr[j + 1];
            }

            size--; // one element removed
            ops++;  // one operation done
        }

        return ops;
    }

    private boolean isSorted(int[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    // --- main method for quick testing ---
    public static void main(String[] args) {
        MinimumPairRemovalToSortArrayI obj = new MinimumPairRemovalToSortArrayI();

        System.out.println(obj.minimumPairRemoval(new int[]{5, 2, 3, 1})); // Expected: 2
        System.out.println(obj.minimumPairRemoval(new int[]{1, 2, 2}));     // Expected: 0
        System.out.println(obj.minimumPairRemoval(new int[]{4, 3, 2, 1})); // Expected: 3
    }
}
