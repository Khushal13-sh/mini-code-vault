/**
 * Problem: Find Closest Number to Zero
 * Difficulty: Easy
 *
 * Return the number closest to zero.
 * If two numbers are equally close, return the larger one.
 */
public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int num : nums) {
            // Check if current number is closer to zero
            if (abs(num) < abs(closest)) {
                closest = num;
            }
            // If equal distance, choose the larger value
            else if (abs(num) == abs(closest) && num > closest) {
                closest = num;
            }
        }

        return closest;
    }

    // Helper method to calculate absolute value
    private int abs(int x) {
        return x < 0 ? -x : x;
    }

    // Main method for testing
    public static void main(String[] args) {
        FindClosestNumberToZero obj = new FindClosestNumberToZero();

        System.out.println(obj.findClosestNumber(
                new int[]{-4, -2, 1, 4, 8})); // 1

        System.out.println(obj.findClosestNumber(
                new int[]{2, -1, 1})); // 1
    }
}
