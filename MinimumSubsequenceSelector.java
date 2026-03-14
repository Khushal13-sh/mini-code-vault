/**
 * ------------------------------------------------------------
 * Problem : Minimum Subsequence in Non-Increasing Order
 * Class   : MinimumSubsequenceSelector
 * ------------------------------------------------------------
 */

import java.util.*;

public class MinimumSubsequenceSelector {

    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> result = new ArrayList<>();

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        Arrays.sort(nums);

        int currSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            currSum += nums[i];
            result.add(nums[i]);

            if (currSum > totalSum - currSum) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        MinimumSubsequenceSelector obj = new MinimumSubsequenceSelector();

        // Example 1
        int[] nums1 = {4,3,10,9,8};
        System.out.println("Input: [4,3,10,9,8]");
        System.out.println("Output: " + obj.minSubsequence(nums1));
        // Expected: [10, 9]

        // Example 2
        int[] nums2 = {4,4,7,6,7};
        System.out.println("\nInput: [4,4,7,6,7]");
        System.out.println("Output: " + obj.minSubsequence(nums2));
        // Expected: [7,7,6]
    }
}