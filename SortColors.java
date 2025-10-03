/**
 * Problem: Sort Colors
 * Difficulty: Medium
 *
 * Task:
 * Given an integer array nums with values 0, 1, and 2 representing red, white, and blue,
 * sort them in-place so that all 0s come first, then 1s, then 2s.
 *
 * Constraint:
 * - Do not use library sorting functions.
 *
 * Approach (Dutch National Flag Algorithm):
 * - Maintain three pointers:
 *   - low: boundary for 0s
 *   - mid: current element being checked
 *   - high: boundary for 2s
 * - Traverse until mid <= high:
 *   - If nums[mid] == 0 → swap with nums[low], move low & mid
 *   - If nums[mid] == 1 → move mid
 *   - If nums[mid] == 2 → swap with nums[high], move high
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (in-place)
 *
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
