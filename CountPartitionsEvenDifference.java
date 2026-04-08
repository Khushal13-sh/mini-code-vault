/*
 add solution for count partitions with even sum difference using parity logic
*/

/**
 * Problem: Count Partitions with Even Sum Difference
 * Difficulty: Easy
 *
 * Description:
 * Count the number of ways to partition the array into two non-empty subarrays
 * such that the difference of their sums is even.
 *
 * Key Insight:
 * - Let totalSum = leftSum + rightSum
 * - Difference = leftSum - rightSum
 * - This difference is even when totalSum is even
 *
 * Why:
 * (left - right) = totalSum - 2 * right
 * → always even if totalSum is even
 *
 * Approach:
 * - Calculate total sum
 * - If total sum is even → all (n - 1) partitions are valid
 * - Else → no valid partitions
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class CountPartitionsEvenDifference {

    public int countPartitions(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is even, all partitions are valid
        if (totalSum % 2 == 0) {
            return nums.length - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        CountPartitionsEvenDifference obj = new CountPartitionsEvenDifference();

        // Example 1
        int[] nums1 = {10, 10, 3, 7, 6};
        System.out.println("Output 1: " + obj.countPartitions(nums1)); // 4

        // Example 2
        int[] nums2 = {1, 2, 2};
        System.out.println("Output 2: " + obj.countPartitions(nums2)); // 0

        // Example 3
        int[] nums3 = {2, 4, 6, 8};
        System.out.println("Output 3: " + obj.countPartitions(nums3)); // 3
    }
}