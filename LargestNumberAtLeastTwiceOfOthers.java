/**
 * Problem: Largest Number At Least Twice of Others
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Given an integer array nums, return the index of the largest number
 * if it is at least twice as much as every other number.
 * Otherwise, return -1.
 *
 * 🧪 Example:
 * Input: [3,6,1,0] ➞ Output: 1
 * Explanation: 6 is at least twice as much as every other number.
 */

public class LargestNumberAtLeastTwiceOfOthers {

    public static int dominantIndex(int[] nums) {
        int maxVal = -1;
        int indexOfMax = -1;

        // Step 1: Find the maximum number and its index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                indexOfMax = i;
            }
        }

        // Step 2: Check if max is at least twice every other number
        for (int num : nums) {
            if (num != maxVal && maxVal < 2 * num) {
                return -1;
            }
        }

        return indexOfMax;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0})); // Output: 1
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4})); // Output: -1
        System.out.println(dominantIndex(new int[]{0, 0, 0, 1})); // Output: 3
    }
}
