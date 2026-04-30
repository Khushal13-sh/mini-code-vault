/*
 add solution for minimum operations to make all elements divisible by three using modulo observation
*/

/**
 * Problem: Find Minimum Operations to Make All Elements Divisible by Three
 * Difficulty: Easy
 *
 * Description:
 * In one operation, we can add or subtract 1 from any element.
 * Find the minimum operations required to make all elements divisible by 3.
 *
 * Key Insight:
 * - If num % 3 == 0 → no operation needed
 * - If num % 3 == 1 → subtract 1 OR add 2 → minimum = 1 operation
 * - If num % 3 == 2 → add 1 OR subtract 2 → minimum = 1 operation
 *
 * So, every non-multiple of 3 needs exactly 1 operation.
 *
 * Approach:
 * - Traverse array
 * - Count elements where num % 3 != 0
 *
 * Why this works:
 * Each element independently needs at most one step to reach nearest multiple of 3.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinOperationsDivisibleByThree {

    public int minimumOperations(int[] nums) {

        int operations = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                operations++;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MinOperationsDivisibleByThree obj = new MinOperationsDivisibleByThree();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Output 1: " + obj.minimumOperations(nums1)); // 3

        // Example 2
        int[] nums2 = {3, 6, 9};
        System.out.println("Output 2: " + obj.minimumOperations(nums2)); // 0
    }
}