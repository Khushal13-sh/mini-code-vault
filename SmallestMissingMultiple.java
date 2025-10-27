/**
 * Problem: Smallest Missing Multiple of K
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array `nums` and an integer `k`,
 * return the smallest positive multiple of `k` that is missing from the array.
 *
 * A multiple of k is any positive integer divisible by k.
 *
 * Example 1:
 * Input: nums = [8, 2, 3, 4, 6], k = 2
 * Output: 10
 * Explanation:
 * Multiples of 2 → [2, 4, 6, 8, 10, 12...]
 * Missing first multiple = 10 ✅
 *
 * Example 2:
 * Input: nums = [1, 4, 7, 10, 15], k = 5
 * Output: 5
 * Explanation:
 * Multiples of 5 → [5, 10, 15, 20...]
 * 5 is missing from nums, so output = 5 ✅
 *
 * Approach:
 * - Generate multiples of k starting from k, 2k, 3k, ...
 * - For each multiple, check if it exists in nums.
 * - Return the first multiple not found.
 *
 * Time Complexity: O(n * M) where M is number of multiples checked
 * Space Complexity: O(1)
 */

public class SmallestMissingMultiple {

    public int missingMultiple(int[] nums, int k) {
        int i = 1;
        while (true) {
            int multiple = i * k;
            boolean found = false;

            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return multiple;
            }

            i++;
        }
    }

    // main() method for testing examples
    public static void main(String[] args) {
        SmallestMissingMultiple solution = new SmallestMissingMultiple();

        // Example 1
        int[] nums1 = {8, 2, 3, 4, 6};
        int k1 = 2;
        System.out.println("Example 1 Output: " + solution.missingMultiple(nums1, k1));
        // Expected: 10

        // Example 2
        int[] nums2 = {1, 4, 7, 10, 15};
        int k2 = 5;
        System.out.println("Example 2 Output: " + solution.missingMultiple(nums2, k2));
        // Expected: 5

        // Example 3 (extra test)
        int[] nums3 = {5, 10, 15, 20};
        int k3 = 5;
        System.out.println("Example 3 Output: " + solution.missingMultiple(nums3, k3));
        // Expected: 25
    }
}
