import java.util.HashMap;

/**
 * Problem: Split the Array
 * Difficulty: Easy
 *
 * You are given an integer array nums of even length.
 * You have to split nums into two equal parts (nums1, nums2) such that:
 * 1. nums1.length == nums2.length == nums.length / 2
 * 2. nums1 contains distinct elements
 * 3. nums2 contains distinct elements
 *
 * Return true if such a split is possible, otherwise return false.
 *
 * Example 1:
 * Input: nums = [1,1,2,2,3,4]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: false
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class SplitArray {

    /**
     * Checks if it is possible to split the array into two valid halves.
     *
     * @param nums input array
     * @return true if possible, false otherwise
     */
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            // If any number appears more than 2 times, split is not possible
            if (frequency.get(num) > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        SplitArray solution = new SplitArray();

        int[] nums1 = {1, 1, 2, 2, 3, 4};
        System.out.println(solution.isPossibleToSplit(nums1)); // true

        int[] nums2 = {1, 1, 1, 1};
        System.out.println(solution.isPossibleToSplit(nums2)); // false

        int[] nums3 = {1, 2, 3, 4};
        System.out.println(solution.isPossibleToSplit(nums3)); // true
    }
}
