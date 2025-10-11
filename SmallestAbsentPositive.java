/**
 * Problem: Smallest Absent Positive Greater Than Average
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums.
 * Return the smallest absent positive integer in nums
 * that is strictly greater than the average of all elements in nums.
 *
 * Example:
 * Input: nums = [3,5]
 * Output: 6
 *
 * Approach:
 * - Compute the average of all elements.
 * - Start checking from (floor(avg) + 1) or 1 (whichever is higher).
 * - Increment until you find a positive integer not present in nums
 *   that is strictly greater than the average.
 *
 * Time Complexity: O(n * m) where m is small (searching for missing number)
 * Space Complexity: O(1)
 */

import java.util.*;

public class SmallestAbsentPositive {

    public int smallestAbsent(int[] nums) {
        double sum = 0;
        for (int x : nums) sum += x;

        double avg = sum / nums.length;
        int candidate = (int) Math.floor(avg) + 1;

        if (candidate < 1) candidate = 1;
        while (candidate <= avg) candidate++;

        while (true) {
            boolean found = false;
            for (int x : nums) {
                if (x == candidate) {
                    found = true;
                    break;
                }
            }
            if (!found) return candidate;
            candidate++;
        }
    }

    // main method for testing examples
    public static void main(String[] args) {
        SmallestAbsentPositive solution = new SmallestAbsentPositive();

        // Example 1
        int[] nums1 = {3, 5};
        System.out.println("Example 1 Output: " + solution.smallestAbsent(nums1));
        // Expected: 6

        // Example 2
        int[] nums2 = {-1, 1, 2};
        System.out.println("Example 2 Output: " + solution.smallestAbsent(nums2));
        // Expected: 3

        // Example 3
        int[] nums3 = {4, -1};
        System.out.println("Example 3 Output: " + solution.smallestAbsent(nums3));
        // Expected: 2
    }
}
