/**
 * Problem: Sum of Good Numbers
 * Difficulty: Easy
 *
 * Description:
 * An element nums[i] is considered "good" if:
 * - It is strictly greater than nums[i - k] (if that index exists)
 * - It is strictly greater than nums[i + k] (if that index exists)
 * 
 * If neither index exists, nums[i] is automatically considered good.
 * 
 * You must return the sum of all good numbers.
 *
 * Example 1:
 * Input: nums = [1,3,2,1,5,4], k = 2
 * Output: 12
 * Explanation:
 * Good numbers are nums[1] = 3, nums[4] = 5, nums[5] = 4
 * Sum = 3 + 5 + 4 = 12
 *
 * Example 2:
 * Input: nums = [2,1], k = 1
 * Output: 2
 * Explanation:
 * nums[0] = 2 is greater than nums[1] = 1 → sum = 2
 */

public class SumOfGoodNumbers {

    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            boolean isGood = true;

            // Check left neighbor (i - k)
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                isGood = false;
            }

            // Check right neighbor (i + k)
            if (i + k < n && nums[i] <= nums[i + k]) {
                isGood = false;
            }

            if (isGood) {
                sum += nums[i];
            }
        }

        return sum;
    }

    // --- main method for quick testing ---
    public static void main(String[] args) {
        SumOfGoodNumbers obj = new SumOfGoodNumbers();
        System.out.println(obj.sumOfGoodNumbers(new int[]{1, 3, 2, 1, 5, 4}, 2)); // Expected: 12
        System.out.println(obj.sumOfGoodNumbers(new int[]{2, 1}, 1));             // Expected: 2
    }
}
