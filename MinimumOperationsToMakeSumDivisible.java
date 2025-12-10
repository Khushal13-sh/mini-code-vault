/**
 * Problem: Minimum Operations to Make Array Sum Divisible by K
 * Difficulty: Easy
 *
 * You may reduce any element by 1 in a single operation.
 * Each operation decreases the sum by exactly 1.
 *
 * To make the total sum divisible by k, we only need to remove
 * the remainder of (sum % k).
 */
public class MinimumOperationsToMakeSumDivisible {

    public int minOperations(int[] nums, int k) {

        int sum = 0;

        // Calculate total sum
        for (int num : nums) {
            sum += num;
        }

        // Remainder when divided by k
        int remainder = sum % k;

        // If already divisible
        if (remainder == 0) {
            return 0;
        }

        // Otherwise operations needed = remainder
        return remainder;
    }


    // ---------------- MAIN METHOD (TEST CASES) ---------------- //
    public static void main(String[] args) {

        MinimumOperationsToMakeSumDivisible obj = new MinimumOperationsToMakeSumDivisible();

        int[] nums1 = {3, 9, 7};
        System.out.println(obj.minOperations(nums1, 5));
        // Expected Output: 4

        int[] nums2 = {4, 1, 3};
        System.out.println(obj.minOperations(nums2, 4));
        // Expected Output: 0

        int[] nums3 = {3, 2};
        System.out.println(obj.minOperations(nums3, 6));
        // Expected Output: 5
    }
}
