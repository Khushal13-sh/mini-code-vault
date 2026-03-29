/*
 add solution for finding subsequence of length k with largest sum with example execution
*/

/**
 * Problem: Find Subsequence of Length K With the Largest Sum
 * Difficulty: Easy
 *
 * Description:
 * Given an array, return a subsequence of length k that has the maximum sum.
 * The order of elements in the subsequence must be the same as in the original array.
 *
 * Approach:
 * - Copy the array and sort it to find the k largest elements
 * - Store these k elements in a map (frequency-based)
 * - Traverse the original array and pick elements that are part of top k
 *   while maintaining order
 *
 * Why this works:
 * Sorting helps identify largest elements, and using frequency ensures
 * correct handling of duplicates.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
import java.util.*;

public class LargestSumSubsequence {

    public int[] maxSubsequence(int[] nums, int k) {

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> freq = new HashMap<>();

        // Take k largest elements
        for (int i = sorted.length - k; i < sorted.length; i++) {
            freq.put(sorted[i], freq.getOrDefault(sorted[i], 0) + 1);
        }

        int[] result = new int[k];
        int index = 0;

        // Maintain original order
        for (int num : nums) {
            if (freq.getOrDefault(num, 0) > 0) {
                result[index++] = num;
                freq.put(num, freq.get(num) - 1);
            }
            if (index == k) break;
        }

        return result;
    }

    public static void main(String[] args) {
        LargestSumSubsequence obj = new LargestSumSubsequence();

        // Example 1
        int[] nums1 = {2, 1, 3, 3};
        int k1 = 2;
        System.out.println("Output 1: " + Arrays.toString(obj.maxSubsequence(nums1, k1))); // [3,3]

        // Example 2
        int[] nums2 = {-1, -2, 3, 4};
        int k2 = 3;
        System.out.println("Output 2: " + Arrays.toString(obj.maxSubsequence(nums2, k2))); // [-1,3,4]

        // Example 3
        int[] nums3 = {3, 4, 3, 3};
        int k3 = 2;
        System.out.println("Output 3: " + Arrays.toString(obj.maxSubsequence(nums3, k3))); // [3,4]
    }
}