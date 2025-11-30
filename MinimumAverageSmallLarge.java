/**
 * Problem: Minimum Average of Smallest and Largest Elements
 * Difficulty: Easy
 *
 * Steps:
 * - Sort the array.
 * - Pair smallest with largest, compute average each step.
 * - Return the smallest average value.
 */

public class MinimumAverageSmallLarge {

    public double minimumAverage(int[] nums) {
        // Step 1: Sort the array (bubble sort)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // Step 2: Use two pointers and find minimum average
        double minAverage = Double.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            double avg = (nums[left] + nums[right]) / 2.0;
            if (avg < minAverage) {
                minAverage = avg;
            }
            left++;
            right--;
        }

        return minAverage;
    }

    public static void main(String[] args) {
        MinimumAverageSmallLarge solution = new MinimumAverageSmallLarge();

        System.out.println(solution.minimumAverage(new int[]{7,8,3,4,15,13,4,1})); // Expected: 5.5
        System.out.println(solution.minimumAverage(new int[]{1,9,8,3,10,5}));     // Expected: 5.5
        System.out.println(solution.minimumAverage(new int[]{1,2,3,7,8,9}));      // Expected: 5.0
    }
}
