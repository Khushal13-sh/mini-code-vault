/**
 * Problem: Single Number II
 * Difficulty: Medium
 *
 * Given an integer array nums where every element appears three times except 
 * for one, which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with:
 * - Linear runtime complexity (O(n)).
 * - Constant extra space (O(1)).
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 * - Each element in nums appears exactly three times except for one element 
 *   which appears once.
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate over 32-bit representation of integers
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            
            // Count set bits at position i across all numbers
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    sum++;
                }
            }
            
            // If bit count not divisible by 3, then unique number has this bit
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    // Quick test
    public static void main(String[] args) {
        SingleNumberII solution = new SingleNumberII();

        int[] nums1 = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums1)); // 3

        int[] nums2 = {0,1,0,1,0,1,99};
        System.out.println(solution.singleNumber(nums2)); // 99
    }
}
