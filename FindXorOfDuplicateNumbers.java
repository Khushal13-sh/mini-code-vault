/*
 add solution to find XOR of numbers appearing twice
*/

/**
 * Problem: Find the XOR of Numbers Which Appear Twice
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array where every number appears
 * either once or twice, return the XOR of all numbers
 * that appear exactly twice.
 *
 * If no number appears twice, return 0.
 *
 * Key Insight:
 * - Track numbers seen before using a HashSet.
 * - If a number is seen again, include it in the XOR.
 *
 * Approach:
 * - Create a HashSet to store visited numbers.
 * - Traverse the array.
 * - If the current number is already in the set,
 *   XOR it with the result.
 * - Otherwise, add it to the set.
 * - Return the final XOR value.
 *
 * Why this works:
 * Every duplicate is encountered exactly once after its
 * first occurrence, so each duplicated number is XORed
 * exactly one time.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 * HashSet stores visited elements.
 */

import java.util.HashSet;
import java.util.Set;

public class FindXorOfDuplicateNumbers {

    public int duplicateNumbersXOR(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        int xor = 0;

        for (int num : nums) {
            if (seen.contains(num)) {
                xor ^= num;
            } else {
                seen.add(num);
            }
        }

        return xor;
    }

    public static void main(String[] args) {

        FindXorOfDuplicateNumbers obj =
                new FindXorOfDuplicateNumbers();

        // Example 1
        int[] nums1 = {1, 2, 1, 3};
        System.out.println("Output 1: " +
                obj.duplicateNumbersXOR(nums1));

        // Example 2
        int[] nums2 = {1, 2, 3};
        System.out.println("Output 2: " +
                obj.duplicateNumbersXOR(nums2));

        // Example 3
        int[] nums3 = {1, 2, 2, 1};
        System.out.println("Output 3: " +
                obj.duplicateNumbersXOR(nums3));
    }
}