/**
 * ------------------------------------------------------------
 * Class Name : LongestAlternatingSubarray
 *
 * Description :
 * Finds the maximum length of a contiguous subarray where
 * elements alternate between +1 and -1 differences, starting
 * with a +1 difference. Returns -1 if no such subarray exists.
 *
 * Approach :
 * Start from each index where nums[i+1] = nums[i] + 1 and
 * extend the subarray while the difference alternates.
 *
 * ------------------------------------------------------------
 */
public class LongestAlternatingSubarray {

    /**
     * Returns the maximum length of an alternating subarray.
     */
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                int len = 2;
                int expectedDiff = -1;

                for (int j = i + 2; j < n; j++) {
                    if (nums[j] - nums[j - 1] == expectedDiff) {
                        len++;
                        expectedDiff *= -1;
                    } else {
                        break;
                    }
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        LongestAlternatingSubarray solution = new LongestAlternatingSubarray();

        int[] nums1 = {2, 3, 4, 3, 4};
        System.out.println("Output (Example 1): " + solution.alternatingSubarray(nums1)); // 4

        int[] nums2 = {4, 5, 6};
        System.out.println("Output (Example 2): " + solution.alternatingSubarray(nums2)); // 2
    }
}
