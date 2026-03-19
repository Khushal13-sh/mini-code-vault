/**
 * ------------------------------------------------------------
 * Problem : Shortest Subarray With OR at Least K I
 * Class   : ShortestORSubarrayFinder
 * ------------------------------------------------------------
 */

public class ShortestORSubarrayFinder {

    public int minimumSubarrayLength(int[] nums, int k) {

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int currentOR = 0;

            for (int j = i; j < n; j++) {

                currentOR |= nums[j];

                if (currentOR >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {

        ShortestORSubarrayFinder obj = new ShortestORSubarrayFinder();

        // Example 1
        int[] nums1 = {1,2,3};
        System.out.println("Output: " + obj.minimumSubarrayLength(nums1, 2));
        // Expected: 1

        // Example 2
        int[] nums2 = {2,1,8};
        System.out.println("Output: " + obj.minimumSubarrayLength(nums2, 10));
        // Expected: 3

        // Example 3
        int[] nums3 = {1,2};
        System.out.println("Output: " + obj.minimumSubarrayLength(nums3, 0));
        // Expected: 1
    }
}