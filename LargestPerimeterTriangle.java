/**
 * Problem: Largest Perimeter Triangle
 * Difficulty: Easy
 *
 * Return the largest perimeter of a triangle with non-zero area
 * formed from three lengths in the array.
 * If no valid triangle exists, return 0.
 */
import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {

        // Sort array in ascending order
        Arrays.sort(nums);

        // Check from largest sides
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        LargestPerimeterTriangle obj = new LargestPerimeterTriangle();

        System.out.println(obj.largestPerimeter(
                new int[]{2, 1, 2})); // 5

        System.out.println(obj.largestPerimeter(
                new int[]{1, 2, 1, 10})); // 0
    }
}
