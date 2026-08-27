/*
 add solution for range sum query immutable
*/

/**
 * Problem: Range Sum Query - Immutable
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, handle multiple queries
 * to calculate the sum of elements between left and right
 * indices, inclusive.
 *
 * Key Insight:
 * Use a prefix sum array so that each range sum query
 * can be answered in O(1) time.
 *
 * Formula:
 * sumRange(left, right) =
 * prefix[right + 1] - prefix[left]
 *
 * Approach:
 * - Create a prefix array of size nums.length + 1.
 * - prefix[i + 1] stores the sum of nums[0] to nums[i].
 * - For every query, subtract the prefix sum before left
 *   from the prefix sum up to right.
 *
 * Time Complexity:
 * Constructor: O(n)
 * sumRange(): O(1)
 *
 * Space Complexity: O(n)
 */
public class RangeSumQueryImmutable {

    private int[] prefix;

    public RangeSumQueryImmutable(int[] nums) {

        prefix = new int[nums.length + 1];

        // Build prefix sum array.
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        // Return sum from left to right, inclusive.
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        RangeSumQueryImmutable obj =
                new RangeSumQueryImmutable(nums);

        // Example 1
        int result1 = obj.sumRange(0, 2);
        System.out.println("Output 1: " + result1);

        // Example 2
        int result2 = obj.sumRange(2, 5);
        System.out.println("Output 2: " + result2);

        // Example 3
        int result3 = obj.sumRange(0, 5);
        System.out.println("Output 3: " + result3);
    }
}