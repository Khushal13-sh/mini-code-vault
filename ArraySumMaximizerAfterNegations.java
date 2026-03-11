/**
 * ------------------------------------------------------------
 * Problem : Maximize Sum Of Array After K Negations
 * Class   : ArraySumMaximizerAfterNegations
 * ------------------------------------------------------------
 */

import java.util.Arrays;

public class ArraySumMaximizerAfterNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);

        // Flip negative numbers first
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        Arrays.sort(nums);

        // If k still odd → flip smallest element
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {

        ArraySumMaximizerAfterNegations obj = new ArraySumMaximizerAfterNegations();

        // Example 1
        int[] nums1 = {4,2,3};
        System.out.println(obj.largestSumAfterKNegations(nums1, 1));
        // Expected Output: 5

        // Example 2
        int[] nums2 = {3,-1,0,2};
        System.out.println(obj.largestSumAfterKNegations(nums2, 3));
        // Expected Output: 6

        // Example 3
        int[] nums3 = {2,-3,-1,5,-4};
        System.out.println(obj.largestSumAfterKNegations(nums3, 2));
        // Expected Output: 13
    }
}