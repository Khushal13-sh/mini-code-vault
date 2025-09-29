/**
 * Problem: Rotate Array
 * Difficulty: Medium
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -2^31 <= nums[i] <= 2^31 - 1
 * - 0 <= k <= 10^5
 *
 * Approach:
 * - Compute effective rotation using k % n
 * - Create a temporary array and place each element at its new rotated position
 * - Copy the rotated values back into the original array
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Test cases
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 3);
        System.out.print("Output 1: ");
        for (int num : nums1) System.out.print(num + " "); // 5 6 7 1 2 3 4

        System.out.println();

        int[] nums2 = {-1, -100, 3, 99};
        solution.rotate(nums2, 2);
        System.out.print("Output 2: ");
        for (int num : nums2) System.out.print(num + " "); // 3 99 -1 -100
    }
}
