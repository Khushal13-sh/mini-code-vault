/*
 add solution for finding smallest stable index using prefix maximum and suffix minimum
*/

/**
 * Problem: Smallest Stable Index I
 * Difficulty: Easy
 *
 * Description:
 * For each index i, calculate:
 *
 * instability score =
 * max(nums[0..i]) - min(nums[i..n-1])
 *
 * Return the smallest index whose instability score
 * is less than or equal to k.
 *
 * Key Insight:
 * To efficiently compute instability:
 *
 * - Maintain Prefix Maximum while traversing
 * - Precompute Suffix Minimum array
 *
 * Then:
 * instability = prefixMax - suffixMin[i]
 *
 * Approach:
 * 1. Build suffixMin array
 * 2. Traverse from left to right
 * 3. Update prefixMax
 * 4. Compute instability score
 * 5. Return first index where instability <= k
 *
 * Why this works:
 * suffixMin[i] gives minimum value in nums[i...n-1]
 * prefixMax gives maximum value in nums[0...i]
 *
 * Therefore instability can be calculated in O(1)
 * for every index.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 * (for suffix minimum array)
 */
public class SmallestStableIndex {

    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            prefixMax = Math.max(prefixMax, nums[i]);

            long instability = (long) prefixMax - suffixMin[i];

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        SmallestStableIndex obj = new SmallestStableIndex();

        // Example 1
        int[] nums1 = {5, 0, 1, 4};
        System.out.println(
                "Output 1: " +
                obj.firstStableIndex(nums1, 3)
        ); // 3

        // Example 2
        int[] nums2 = {3, 2, 1};
        System.out.println(
                "Output 2: " +
                obj.firstStableIndex(nums2, 1)
        ); // -1

        // Example 3
        int[] nums3 = {0};
        System.out.println(
                "Output 3: " +
                obj.firstStableIndex(nums3, 0)
        ); // 0
    }
}