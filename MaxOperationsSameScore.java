/*
 add solution for maximum number of operations with same score using pair sum comparison
*/

/**
 * Problem: Maximum Number of Operations With the Same Score I
 * Difficulty: Easy
 *
 * Description:
 * In each operation:
 * - Remove first two elements
 * - Score = sum of those two elements
 * All operations must have the same score.
 *
 * Goal:
 * Find maximum number of such operations.
 *
 * Key Insight:
 * - First operation decides the fixed score
 * - After that, every next pair must match this score
 * - We process array in pairs (0,1), (2,3), (4,5)...
 *
 * Approach:
 * - Calculate initial score = nums[0] + nums[1]
 * - Iterate in steps of 2
 * - Check if each pair sum equals score
 * - Stop when mismatch occurs
 *
 * Why this works:
 * Since we always remove first two elements, order is fixed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxOperationsSameScore {

    public int maxOperations(int[] nums) {

        int n = nums.length;
        int score = nums[0] + nums[1];
        int count = 1;

        for (int i = 2; i < n - 1; i += 2) {

            if (nums[i] + nums[i + 1] == score) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxOperationsSameScore obj = new MaxOperationsSameScore();

        // Example 1
        int[] nums1 = {3, 2, 1, 4, 5};
        System.out.println("Output 1: " + obj.maxOperations(nums1)); // 2

        // Example 2
        int[] nums2 = {1, 5, 3, 3, 4, 1, 3, 2, 2, 3};
        System.out.println("Output 2: " + obj.maxOperations(nums2)); // 2

        // Example 3
        int[] nums3 = {5, 3};
        System.out.println("Output 3: " + obj.maxOperations(nums3)); // 1
    }
}