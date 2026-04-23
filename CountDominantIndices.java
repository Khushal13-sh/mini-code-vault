/*
 add solution for count dominant indices using suffix sum approach
*/

/**
 * Problem: Count Dominant Indices
 * Difficulty: Easy
 *
 * Description:
 * An index i is dominant if:
 * nums[i] > average of elements to its right
 *
 * Key Insight:
 * nums[i] > (sumRight / countRight)
 * → nums[i] * countRight > sumRight  (avoid division)
 *
 * Approach:
 * - Calculate total sum of array
 * - Iterate from left to right
 * - Maintain remaining (right side) sum
 * - For each index:
 *      → reduce current element from total
 *      → check condition using multiplication
 *
 * Why this works:
 * Avoids floating point operations and uses efficient math comparison.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class CountDominantIndices {

    public int countDominant(int[] nums) {

        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            totalSum -= nums[i]; // right side sum
            int rightCount = n - i - 1;

            if (nums[i] * rightCount > totalSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountDominantIndices obj = new CountDominantIndices();

        // Example 1
        int[] nums1 = {5, 4, 3};
        System.out.println("Output 1: " + obj.countDominant(nums1)); // 2

        // Example 2
        int[] nums2 = {4, 1, 2};
        System.out.println("Output 2: " + obj.countDominant(nums2)); // 1
    }
}