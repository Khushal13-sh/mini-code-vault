/**
 * Problem Title: Create Target Array in the Given Order
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * You are given two integer arrays `nums` and `index`. You need to create a target array by:
 * - Reading from left to right.
 * - Inserting `nums[i]` at position `index[i]` in the target array.
 *
 * 🧠 Constraints:
 * - All insertions are valid (no index out of bounds).
 *
 * 📥 Example 1:
 * Input:  nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 *
 * 📥 Example 2:
 * Input:  nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 *
 * 📥 Example 3:
 * Input:  nums = [1], index = [0]
 * Output: [1]
 */

import java.util.*;

public class CreateTargetArray {

    /**
     * 🧠 Logic:
     * - Start with an empty list.
     * - For each element in nums, insert it at the given position from index[].
     * - Return the final list as an array.
     */
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);  // insert at index[i]
        }

        // Convert list to array
        int[] result = new int[targetList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = targetList.get(i);
        }

        return result;
    }

    // 🧪 Main method to test the implementation
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4};
        int[] index1 = {0, 1, 2, 2, 1};
        System.out.println("Target Array: " + Arrays.toString(createTargetArray(nums1, index1))); // [0, 4, 1, 3, 2]

        int[] nums2 = {1, 2, 3, 4, 0};
        int[] index2 = {0, 1, 2, 3, 0};
        System.out.println("Target Array: " + Arrays.toString(createTargetArray(nums2, index2))); // [0, 1, 2, 3, 4]

        int[] nums3 = {1};
        int[] index3 = {0};
        System.out.println("Target Array: " + Arrays.toString(createTargetArray(nums3, index3))); // [1]
    }
}
