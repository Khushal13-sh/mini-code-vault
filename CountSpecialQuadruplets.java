/**
 * Problem: Count Special Quadruplets
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Given an array nums, count the number of quadruplets (a, b, c, d) such that:
 * - nums[a] + nums[b] + nums[c] == nums[d]
 * - and a < b < c < d
 *
 * 🧪 Example:
 * Input: [1, 2, 3, 6]
 * Output: 1
 */

public class CountSpecialQuadruplets {

    public static int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Brute-force solution: O(n^4), but fine for constraints (n <= 50)
        for (int a = 0; a < n - 3; a++) {
            for (int b = a + 1; b < n - 2; b++) {
                for (int c = b + 1; c < n - 1; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countQuadruplets(new int[]{1, 2, 3, 6}));       // Output: 1
        System.out.println(countQuadruplets(new int[]{3, 3, 6, 4, 5}));    // Output: 0
        System.out.println(countQuadruplets(new int[]{1, 1, 1, 3, 5}));    // Output: 4
        System.out.println(countQuadruplets(new int[]{1, 1, 1, 1, 3}));    // Output: 1
    }
}
