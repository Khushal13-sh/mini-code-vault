/**
 * Problem: Number of Arithmetic Triplets
 * Difficulty: Easy
 *
 * Description:
 * You are given a strictly increasing integer array `nums` and a positive integer `diff`.
 * A triplet (i, j, k) is considered an arithmetic triplet if:
 *  1. i < j < k
 *  2. nums[j] - nums[i] == diff
 *  3. nums[k] - nums[j] == diff
 *
 * Task:
 * Return the total count of unique arithmetic triplets.
 *
 * Example:
 * Input: nums = [0,1,4,6,7,10], diff = 3
 * Output: 2
 * Explanation:
 *  (1, 2, 4) → 4 - 1 == 3 and 7 - 4 == 3
 *  (2, 4, 5) → 7 - 4 == 3 and 10 - 7 == 3
 *
 * Constraints:
 * - 3 <= nums.length <= 200
 * - 0 <= nums[i] <= 200
 * - 1 <= diff <= 50
 * - nums is strictly increasing
 *
 * Approach:
 * - Use three nested loops to check all triplets.
 * - Verify both conditions (nums[j] - nums[i] == diff and nums[k] - nums[j] == diff).
 * - Increment count for each valid triplet.
 *
 * Time Complexity: O(n^3) [n = nums.length]
 * Space Complexity: O(1)
 */
public class NumberOfArithmeticTriplets {

    /**
     * Counts the number of arithmetic triplets in the given array.
     *
     * @param nums The strictly increasing integer array
     * @param diff The required difference between consecutive elements in the triplet
     * @return Number of unique arithmetic triplets
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] - nums[j] == diff) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        NumberOfArithmeticTriplets solution = new NumberOfArithmeticTriplets();

        System.out.println(solution.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3)); // Output: 2
        System.out.println(solution.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));   // Output: 2
    }
}
