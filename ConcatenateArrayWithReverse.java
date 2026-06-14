/*
 add solution for concatenating array with its reverse
*/

/**
 * Problem: Concatenate Array With Reverse
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums of length n,
 * create a new array ans of length 2 * n:
 *
 * - First n elements are the same as nums
 * - Next n elements are nums in reverse order
 *
 * Return the resulting array.
 *
 * Key Insight:
 * - Copy the original array into the first half.
 * - Copy the reversed array into the second half.
 *
 * Approach:
 * - Create an array of size 2 * n.
 * - Fill indices [0...n-1] with nums.
 * - Fill indices [n...2n-1] with nums in reverse order.
 * - Return the new array.
 *
 * Why this works:
 * The problem directly defines how each element
 * of the resulting array should be placed.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 * Extra array of size 2 * n is used.
 */
public class ConcatenateArrayWithReverse {

    public int[] concatWithReverse(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[n - 1 - i];
        }

        return ans;
    }

    public static void main(String[] args) {

        ConcatenateArrayWithReverse obj =
                new ConcatenateArrayWithReverse();

        // Example 1
        int[] nums1 = {1, 2, 3};
        int[] result1 = obj.concatWithReverse(nums1);

        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2
        int[] nums2 = {1};
        int[] result2 = obj.concatWithReverse(nums2);

        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}