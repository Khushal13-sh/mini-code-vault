/**
 * ------------------------------------------------------------
 * Problem : Neither Minimum nor Maximum
 * Class   : NonMinMaxElementFinder
 * ------------------------------------------------------------
 */

public class NonMinMaxElementFinder {

    public int findNonMinOrMax(int[] nums) {

        if (nums.length < 3) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Find element that is neither min nor max
        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        NonMinMaxElementFinder obj = new NonMinMaxElementFinder();

        // Example 1
        int[] nums1 = {3,2,1,4};
        System.out.println("Input: [3,2,1,4]");
        System.out.println("Output: " + obj.findNonMinOrMax(nums1));
        // Expected: 2 or 3

        // Example 2
        int[] nums2 = {1,2};
        System.out.println("\nInput: [1,2]");
        System.out.println("Output: " + obj.findNonMinOrMax(nums2));
        // Expected: -1

        // Example 3
        int[] nums3 = {2,1,3};
        System.out.println("\nInput: [2,1,3]");
        System.out.println("Output: " + obj.findNonMinOrMax(nums3));
        // Expected: 2
    }
}