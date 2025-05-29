/**
 * Problem: How Many Numbers Are Smaller Than the Current Number
 * Difficulty: Easy
 *
 * 🧠 Description:
 * For each element in the array, count how many numbers are smaller than it.
 *
 * 📥 Example:
 * Input:  nums = [8,1,2,2,3]
 * Output:        [4,0,1,1,3]
 *
 * 🧪 Constraints:
 * - 2 <= nums.length <= 500
 * - 0 <= nums[i] <= 100
 */

import java.util.*;

public class SmallerNumbersThanCurrent {

    // ✅ Brute-force solution: O(n^2)
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    // ✅ Optimized solution: O(n) using frequency counting
    public static int[] optimizedSmallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // nums[i] <= 100
        for (int num : nums) {
            count[num]++;
        }

        // Prefix sum to get number of elements less than i
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }

    // 🧪 Main method to test both solutions
    public static void main(String[] args) {
        int[] nums1 = {8, 1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 8};
        int[] nums3 = {7, 7, 7, 7};

        System.out.println("Brute-force Results:");
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums1))); // [4, 0, 1, 1, 3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums2))); // [2, 1, 0, 3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums3))); // [0, 0, 0, 0]

        System.out.println("Optimized Results:");
        System.out.println(Arrays.toString(optimizedSmallerNumbersThanCurrent(nums1))); // [4, 0, 1, 1, 3]
        System.out.println(Arrays.toString(optimizedSmallerNumbersThanCurrent(nums2))); // [2, 1, 0, 3]
        System.out.println(Arrays.toString(optimizedSmallerNumbersThanCurrent(nums3))); // [0, 0, 0, 0]
    }
}
