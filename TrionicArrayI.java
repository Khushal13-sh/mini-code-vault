/**
 * Problem: Trionic Array I
 * Difficulty: Easy
 *
 * Description:
 * An array is called TRIONIC if there exist indices 0 < p < q < n−1 such that:
 *   1. nums[0...p] is strictly increasing
 *   2. nums[p...q] is strictly decreasing
 *   3. nums[q...n−1] is strictly increasing
 *
 * Task:
 * Return true if the given array is trionic, otherwise return false.
 *
 * Example 1:
 * Input: nums = [1, 3, 5, 4, 2, 6]
 * Output: true
 * Explanation:
 *   - [1,3,5] → strictly increasing
 *   - [5,4,2] → strictly decreasing
 *   - [2,6]   → strictly increasing
 *
 * Example 2:
 * Input: nums = [2, 1, 3]
 * Output: false
 * Explanation:
 *   - No way to form increasing → decreasing → increasing pattern.
 *
 * Approach:
 * 1. Traverse array to find the first strictly increasing sequence.
 * 2. Then find the strictly decreasing sequence.
 * 3. Finally, check for the last strictly increasing sequence.
 * 4. If all 3 phases exist and end reaches last index → return true.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class TrionicArrayI {

    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        // Step 1: Strictly Increasing
        while (i + 1 < n && nums[i + 1] > nums[i]) i++;
        if (i == 0 || i == n - 1) return false;

        // Step 2: Strictly Decreasing
        while (i + 1 < n && nums[i + 1] < nums[i]) i++;
        if (i == n - 1) return false;

        // Step 3: Strictly Increasing again
        while (i + 1 < n && nums[i + 1] > nums[i]) i++;

        return i == n - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        TrionicArrayI solution = new TrionicArrayI();

        int[] nums1 = {1, 3, 5, 4, 2, 6};
        System.out.println("Example 1 Output: " + solution.isTrionic(nums1));
        // Expected: true

        int[] nums2 = {2, 1, 3};
        System.out.println("Example 2 Output: " + solution.isTrionic(nums2));
        // Expected: false

        int[] nums3 = {1, 2, 3, 2, 1, 2, 3};
        System.out.println("Example 3 Output: " + solution.isTrionic(nums3));
        // Expected: true
    }
}
