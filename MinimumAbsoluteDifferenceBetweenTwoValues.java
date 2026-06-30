/*
 add solution for finding the minimum absolute difference
 between indices of values 1 and 2
*/

/**
 * Problem: Minimum Absolute Difference Between Two Values
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array containing only 0, 1, and 2,
 * find the minimum absolute difference between the
 * indices of a value 1 and a value 2.
 *
 * A valid pair is:
 * - nums[i] == 1
 * - nums[j] == 2
 *
 * Return the minimum absolute difference between all
 * valid pairs. If no valid pair exists, return -1.
 *
 * Key Insight:
 * - Keep track of the most recent index of 1 and 2.
 * - Whenever a new 1 or 2 is found, compare it with
 *   the latest occurrence of the other value.
 *
 * Approach:
 * - Initialize last seen indices of 1 and 2 as -1.
 * - Traverse the array once.
 * - Update the corresponding last seen index.
 * - If both values have been seen, update the minimum
 *   absolute difference.
 * - Return -1 if no valid pair exists.
 *
 * Why this works:
 * The closest pair involving the current element can
 * only be formed with the latest occurrence of the
 * opposite value encountered so far.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only constant extra space is used.
 */
public class MinimumAbsoluteDifferenceBetweenTwoValues {

    public int minAbsoluteDifference(int[] nums) {

        int lastOne = -1;
        int lastTwo = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                lastOne = i;

                if (lastTwo != -1) {
                    ans = Math.min(ans,
                            Math.abs(lastOne - lastTwo));
                }

            } else if (nums[i] == 2) {
                lastTwo = i;

                if (lastOne != -1) {
                    ans = Math.min(ans,
                            Math.abs(lastOne - lastTwo));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        MinimumAbsoluteDifferenceBetweenTwoValues obj =
                new MinimumAbsoluteDifferenceBetweenTwoValues();

        // Example 1
        int[] nums1 = {1, 0, 0, 2, 0, 1};
        System.out.println("Output 1: " +
                obj.minAbsoluteDifference(nums1));

        // Example 2
        int[] nums2 = {1, 0, 1, 0};
        System.out.println("Output 2: " +
                obj.minAbsoluteDifference(nums2));
    }
}