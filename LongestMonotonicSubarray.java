/*
 add O(n) solution for longest strictly increasing or decreasing subarray with examples
*/

/**
 * Finds the length of the longest strictly increasing or decreasing subarray
 * using a single pass approach.
 */
public class LongestMonotonicSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int inc = 1;
        int dec = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }

            ans = Math.max(ans, Math.max(inc, dec));
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestMonotonicSubarray obj = new LongestMonotonicSubarray();

        int[] nums1 = {1, 4, 3, 3, 2};
        System.out.println(obj.longestMonotonicSubarray(nums1)); // 2

        int[] nums2 = {3, 3, 3, 3};
        System.out.println(obj.longestMonotonicSubarray(nums2)); // 1

        int[] nums3 = {3, 2, 1};
        System.out.println(obj.longestMonotonicSubarray(nums3)); // 3
    }
}