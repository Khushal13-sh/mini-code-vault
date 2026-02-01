/**
 * ------------------------------------------------------------
 * Class Name : MaximumDifferenceIncreasing
 *
 * Description :
 * Finds the maximum difference nums[j] - nums[i] such that
 * i < j and nums[i] < nums[j]. Returns -1 if no valid pair exists.
 *
 * ------------------------------------------------------------
 */
public class MaximumDifferenceIncreasing {

    /**
     * Returns the maximum valid difference.
     */
    public int maximumDifference(int[] nums) {
        int minValue = nums[0];
        int maxDiff = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minValue) {
                int diff = nums[i] - minValue;
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            } else {
                minValue = nums[i];
            }
        }
        return maxDiff;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        MaximumDifferenceIncreasing solution = new MaximumDifferenceIncreasing();

        System.out.println("Example 1 Output: " +
                solution.maximumDifference(new int[]{7, 1, 5, 4})); // 4

        System.out.println("Example 2 Output: " +
                solution.maximumDifference(new int[]{9, 4, 3, 2})); // -1

        System.out.println("Example 3 Output: " +
                solution.maximumDifference(new int[]{1, 5, 2, 10})); // 9
    }
}
