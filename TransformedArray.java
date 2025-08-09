import java.util.*;

/**
 * Problem: Transformed Array
 * Difficulty: Easy
 *
 * You are given an integer array nums of length n.
 * Each element nums[i] represents the number of steps to move forward
 * (if positive) or backward (if negative) from index i.
 *
 * Movement wraps around the array circularly.
 * If nums[i] == 0, the value at index i in the transformed array will be 0.
 *
 * Approach:
 * 1. Iterate over each index i in nums.
 * 2. If nums[i] is zero, directly set result[i] = 0.
 * 3. Otherwise, calculate the new index after moving nums[i] steps (mod n for circular effect).
 * 4. Handle negative index by adding n if needed.
 * 5. Assign result[i] = nums[newIndex].
 *
 * Example:
 * Input: nums = [3, -2, 1, 1]
 * Output: [1, 1, 1, 3]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TransformedArray {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int steps = nums[i];
                int newIndex = (i + steps) % n;
                if (newIndex < 0) {
                    newIndex += n;
                }
                result[i] = nums[newIndex];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TransformedArray solution = new TransformedArray();

        int[] nums1 = {3, -2, 1, 1};
        int[] nums2 = {-1, 4, -1};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {2, -3, 1, -4};

        System.out.println(Arrays.toString(solution.constructTransformedArray(nums1))); // Output: [1, 1, 1, 3]
        System.out.println(Arrays.toString(solution.constructTransformedArray(nums2))); // Output: [-1, -1, 4]
        System.out.println(Arrays.toString(solution.constructTransformedArray(nums3))); // Output: [0, 0, 0]
        System.out.println(Arrays.toString(solution.constructTransformedArray(nums4))); // Output: [-4, -4, -3, 2]
    }
}
