/**
 * Problem: Make Array Zero by Subtracting Equal Amounts
 * Difficulty: Easy
 *
 * You are given a non-negative integer array nums.
 *
 * Operation:
 * - Choose a positive integer x such that x <= smallest non-zero element in nums.
 * - Subtract x from every positive element in nums.
 *
 * Task:
 * Return the minimum number of operations to make every element in nums equal to 0.
 *
 * Key Idea:
 * - Each unique positive value in nums contributes to one operation.
 * - So, the answer is simply the count of unique positive numbers.
 *
 * Example 1:
 * Input: nums = [1,5,0,3,5]
 * Output: 3
 * Explanation:
 *   - Operation 1: subtract 1 → [0,4,0,2,4]
 *   - Operation 2: subtract 2 → [0,2,0,0,2]
 *   - Operation 3: subtract 2 → [0,0,0,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: 0
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
import java.util.*;

public class MakeArrayZeroBySubtractingEqualAmounts {

    /**
     * Function to calculate minimum operations
     *
     * @param nums array of integers
     * @return minimum operations to make all elements zero
     */
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        return set.size();
    }

    // Main method for quick testing
    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts solution = new MakeArrayZeroBySubtractingEqualAmounts();

        int[] nums1 = {1, 5, 0, 3, 5};
        System.out.println(solution.minimumOperations(nums1)); // 3

        int[] nums2 = {0};
        System.out.println(solution.minimumOperations(nums2)); // 0

        int[] nums3 = {2, 2, 2};
        System.out.println(solution.minimumOperations(nums3)); // 1

        int[] nums4 = {4, 0, 1, 3};
        System.out.println(solution.minimumOperations(nums4)); // 3
    }
}
