/*
 add solution for finding largest almost missing integer using sliding window and hashmap
*/

/**
 * Problem: Find the Largest Almost Missing Integer
 * Difficulty: Easy
 *
 * Description:
 * An integer is almost missing if it appears in exactly one subarray of size k.
 * Return the largest such integer, or -1 if none exists.
 *
 * Approach:
 * - Generate all subarrays of size k
 * - Use a Set to store unique elements in each subarray
 * - Use a HashMap to count how many subarrays each element appears in
 * - Find elements that appear exactly once and return the maximum
 *
 * Why this works:
 * Using a Set ensures duplicates within the same subarray are counted once
 * HashMap tracks frequency across all subarrays
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n)
 */
import java.util.*;

public class LargestAlmostMissingInteger {

    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        // Sliding window of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            // Count occurrence in subarrays
            for (int num : seen) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int result = -1;

        // Find largest element appearing exactly once
        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                result = Math.max(result, num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LargestAlmostMissingInteger obj = new LargestAlmostMissingInteger();

        // Example 1
        int[] nums1 = {3, 9, 2, 1, 7};
        int k1 = 3;
        System.out.println("Output 1: " + obj.largestInteger(nums1, k1)); // 7

        // Example 2
        int[] nums2 = {3, 9, 7, 2, 1, 7};
        int k2 = 4;
        System.out.println("Output 2: " + obj.largestInteger(nums2, k2)); // 3

        // Example 3
        int[] nums3 = {0, 0};
        int k3 = 1;
        System.out.println("Output 3: " + obj.largestInteger(nums3, k3)); // -1
    }
}