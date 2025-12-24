
/**
 * 
 * Problem: Smallest Range I
 * Difficulty: Easy
 * 
 * Minimize the difference between the maximum and minimumelements after adjusting each element by at most k.
*/
public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum values
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Adjust min and max
        min = min + k;
        max = max - k;

        int score = max - min;

        // Score cannot be negative
        return Math.max(score, 0);
    }

    // Main method for testing
    public static void main(String[] args) {
        SmallestRangeI obj = new SmallestRangeI();

        int[] nums1 = {1};
        System.out.println("Output: " + obj.smallestRangeI(nums1, 0)); // 0

        int[] nums2 = {0, 10};
        System.out.println("Output: " + obj.smallestRangeI(nums2, 2)); // 6

        int[] nums3 = {1, 3, 6};
        System.out.println("Output: " + obj.smallestRangeI(nums3, 3)); // 0
    }
}