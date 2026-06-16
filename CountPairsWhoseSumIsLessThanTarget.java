/*
 add solution for counting pairs whose sum is less than target
*/

import java.util.Collections;
import java.util.List;

/**
 * Problem: Count Pairs Whose Sum is Less than Target
 * Difficulty: Easy
 *
 * Description:
 * Given a list of integers nums and an integer target,
 * return the number of pairs (i, j) such that:
 *
 * - 0 <= i < j < n
 * - nums[i] + nums[j] < target
 *
 * Key Insight:
 * - Sort the array first.
 * - Use two pointers:
 *      left  -> smallest value
 *      right -> largest value
 * - If nums[left] + nums[right] < target,
 *   then every element between left and right
 *   can form a valid pair with left.
 *
 * Approach:
 * - Sort nums.
 * - Initialize left = 0 and right = n - 1.
 * - If sum < target:
 *      count += (right - left)
 *      move left forward.
 * - Otherwise:
 *      move right backward.
 * - Return count.
 *
 * Why this works:
 * After sorting, when nums[left] + nums[right]
 * is less than target, all elements between
 * left and right also form valid pairs with left.
 *
 * Time Complexity: O(n log n)
 * Sorting dominates the complexity.
 *
 * Space Complexity: O(1)
 * Ignoring sorting space.
 */
public class CountPairsWhoseSumIsLessThanTarget {

    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {

            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountPairsWhoseSumIsLessThanTarget obj =
                new CountPairsWhoseSumIsLessThanTarget();

        // Example 1
        List<Integer> nums1 =
                List.of(-1, 1, 2, 3, 1);

        System.out.println(
                "Output 1: " +
                obj.countPairs(nums1, 2)
        );

        // Example 2
        List<Integer> nums2 =
                List.of(-6, 2, 5, -2, -7, -1, 3);

        System.out.println(
                "Output 2: " +
                obj.countPairs(nums2, -2)
        );
    }
}