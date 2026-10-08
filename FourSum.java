import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 4Sum
 * Difficulty: Medium
 *
 * Problem Description:
 *
 * Given an integer array nums and an integer target,
 * return all unique quadruplets:
 *
 *     [nums[a], nums[b], nums[c], nums[d]]
 *
 * such that:
 *
 *     nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * The four indices must be different.
 *
 * The result should not contain duplicate quadruplets.
 *
 * Example:
 *
 * Input:
 *
 *     nums = [1, 0, -1, 0, -2, 2]
 *     target = 0
 *
 * Output:
 *
 *     [
 *         [-2, -1, 1, 2],
 *         [-2, 0, 0, 2],
 *         [-1, 0, 0, 1]
 *     ]
 *
 * Approach:
 *
 * 4Sum can be solved by extending the 3Sum approach.
 *
 * We first sort the array.
 *
 * Then:
 *
 * 1. Fix the first number using index i.
 * 2. Fix the second number using index j.
 * 3. Use two pointers:
 *        left  -> j + 1
 *        right -> n - 1
 * 4. Calculate the sum of the four numbers.
 *
 * If the sum equals target:
 *
 *     Add the quadruplet to the result.
 *
 *     Then skip duplicate values from both sides.
 *
 * If the sum is smaller than target:
 *
 *     Move left forward to increase the sum.
 *
 * If the sum is greater than target:
 *
 *     Move right backward to decrease the sum.
 *
 * Duplicate Handling:
 *
 * Since the array is sorted, duplicate values appear together.
 *
 * We skip duplicate values for both i and j:
 *
 *     if (i > 0 && nums[i] == nums[i - 1])
 *
 *     if (j > i + 1 && nums[j] == nums[j - 1])
 *
 * After finding a valid quadruplet, we also skip duplicate
 * values for left and right.
 *
 * Integer Overflow:
 *
 * nums[i] can be as large as 10^9.
 *
 * The sum of four values can exceed the int range.
 * Therefore, the sum is stored in a long variable.
 *
 * Time Complexity:
 *
 * O(n^3)
 *
 * We have two fixed loops and one two-pointer traversal.
 *
 * Space Complexity:
 *
 * O(1) extra space, excluding the result list.
 *
 * Arrays.sort() may use additional internal space depending
 * on the Java implementation.
 */
public class FourSum {

    /**
     * Finds all unique quadruplets whose sum equals target.
     *
     * @param nums   input integer array
     * @param target required sum of four numbers
     * @return list of unique quadruplets
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort the array so that we can use two pointers.
        Arrays.sort(nums);

        int n = nums.length;

        /*
         * First number.
         *
         * We need at least three more numbers after i,
         * so i can go only until n - 4.
         */
        for (int i = 0; i < n - 3; i++) {

            /*
             * Skip duplicate values for the first number.
             *
             * Example:
             *
             * [-2, -2, -1, 0, 1]
             *
             * We only need to process -2 once as i.
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            /*
             * Second number.
             *
             * j starts after i because all four indices
             * must be different.
             */
            for (int j = i + 1; j < n - 2; j++) {

                /*
                 * Skip duplicate values for the second number.
                 */
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                /*
                 * Two pointers for the remaining
                 * two numbers.
                 */
                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    /*
                     * Use long to prevent integer overflow.
                     *
                     * nums[i], nums[j], nums[left] and nums[right]
                     * can each be as large as 10^9.
                     */
                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[left]
                            + nums[right];

                    /*
                     * Found a valid quadruplet.
                     */
                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        /*
                         * Skip duplicate values for left.
                         *
                         * Example:
                         *
                         * [-2, 0, 0, 0, 2]
                         *
                         * After using one 0, the next 0
                         * would create the same quadruplet.
                         */
                        while (left < right
                                && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        /*
                         * Skip duplicate values for right.
                         */
                        while (left < right
                                && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        /*
                         * Move both pointers after processing
                         * the current quadruplet.
                         */
                        left++;
                        right--;

                    } else if (sum < target) {

                        /*
                         * Sum is too small.
                         *
                         * Because the array is sorted, moving
                         * left forward gives us a larger value.
                         */
                        left++;

                    } else {

                        /*
                         * Sum is too large.
                         *
                         * Moving right backward gives us
                         * a smaller value.
                         */
                        right--;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        FourSum solution = new FourSum();

        // Example 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        System.out.println(
                solution.fourSum(nums1, target1)
        );

        /*
         * Expected:
         *
         * [[-2, -1, 1, 2],
         *  [-2, 0, 0, 2],
         *  [-1, 0, 0, 1]]
         */

        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println(
                solution.fourSum(nums2, target2)
        );

        /*
         * Expected:
         *
         * [[2, 2, 2, 2]]
         */

        // Example 3
        int[] nums3 = {0, 0, 0, 0};
        int target3 = 0;

        System.out.println(
                solution.fourSum(nums3, target3)
        );

        /*
         * Expected:
         *
         * [[0, 0, 0, 0]]
         */

        // Example 4
        int[] nums4 = {1, 2, 3, 4};
        int target4 = 10;

        System.out.println(
                solution.fourSum(nums4, target4)
        );

        /*
         * Expected:
         *
         * [[1, 2, 3, 4]]
         */
    }
}