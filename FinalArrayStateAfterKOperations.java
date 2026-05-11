/*
 add solution for final array state after k multiplication operations using simulation
*/

/**
 * Problem: Final Array State After K Multiplication Operations I
 * Difficulty: Easy
 *
 * Description:
 * Perform k operations on the array:
 * - Find the minimum element
 * - If multiple minimums exist, choose the first one
 * - Multiply it by multiplier
 *
 * Return the final array after all operations.
 *
 * Key Insight:
 * - Each operation depends on the current minimum value
 * - We simulate operations one by one
 * - Track index of minimum element carefully
 *
 * Approach:
 * - Repeat k times:
 *      - Find index of smallest element
 *      - Multiply that element by multiplier
 * - Return updated array
 *
 * Why this works:
 * Simulation exactly follows the problem statement.
 * Choosing the first minimum automatically happens
 * because we only update when a strictly smaller
 * value is found.
 *
 * Time Complexity: O(k * n)
 * k = number of operations
 * n = array length
 *
 * Space Complexity: O(1)
 */
public class FinalArrayStateAfterKOperations {

    public int[] getFinalState(int[] nums,
                               int k,
                               int multiplier) {

        // Perform k operations
        for (int op = 0; op < k; op++) {

            int minIndex = 0;

            // Find first occurrence of minimum element
            for (int i = 1; i < nums.length; i++) {

                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            // Multiply minimum element
            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {

        FinalArrayStateAfterKOperations obj =
                new FinalArrayStateAfterKOperations();

        // Example 1
        int[] nums1 = {2, 1, 3, 5, 6};

        int[] result1 =
                obj.getFinalState(nums1, 5, 2);

        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        // 8 4 6 5 6

        System.out.println();

        // Example 2
        int[] nums2 = {1, 2};

        int[] result2 =
                obj.getFinalState(nums2, 3, 4);

        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        // 16 8
    }
}